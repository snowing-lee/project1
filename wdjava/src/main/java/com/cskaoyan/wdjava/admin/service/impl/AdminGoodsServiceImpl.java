package com.cskaoyan.wdjava.admin.service.impl;

import com.cskaoyan.wdjava.admin.bean.AddSpec;
import com.cskaoyan.wdjava.admin.bean.AdminAddGoods;
import com.cskaoyan.wdjava.admin.bean.AdminType;
import com.cskaoyan.wdjava.admin.bean.UpdateGoods;
import com.cskaoyan.wdjava.admin.mapper.AdminGoodsMapper;
import com.cskaoyan.wdjava.admin.service.AdminGoodsService;
import com.cskaoyan.wdjava.admin.vo.AdminGoodsReq;
import com.cskaoyan.wdjava.base.BaseRes;
import com.cskaoyan.wdjava.vue.bean.Good;
import com.cskaoyan.wdjava.vue.bean.Specs;
import com.cskaoyan.wdjava.admin.mapper.AdminLoginMapper;
import com.cskaoyan.wdjava.vue.vo.GoodRes;
import com.cskaoyan.wdjava.vue.vo.TypeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Service
@Transactional
public class AdminGoodsServiceImpl implements AdminGoodsService {

    @Autowired
    AdminGoodsMapper adminGoodsMapper;

    @Autowired
    AdminLoginMapper loginMapper;

    @Value("${img.urlIp}")
    String urlIp;

    @Value("${server.port}")
    String port;



    @Override
    public BaseRes getType() throws Exception {
        BaseRes baseRes = new BaseRes();

        List<TypeRes> list = adminGoodsMapper.getType();

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes getGoodsByType(AdminGoodsReq adminGoodsReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer typeId = adminGoodsReq.getTypeId();

        List<GoodRes> list = adminGoodsMapper.getGoodsByType(typeId);

        baseRes.setCode(0);
        baseRes.setData(list);
        return baseRes;
    }

    @Override
    public BaseRes addType(AdminGoodsReq adminGoodsReq) throws Exception {
        BaseRes baseRes = new BaseRes();
        String name = adminGoodsReq.getName();

        // 查询重复
        List<AdminType> list = adminGoodsMapper.selectAllType();
        for (AdminType adminType : list) {
            String resName = adminType.getName();
            if (resName.equals(name)){
                baseRes.setCode(10000);
                baseRes.setMessage("该种类已经存在!");
                return baseRes;
            }
        }
        // 添加
        adminGoodsMapper.addType(name);
        // 更新type
        adminGoodsMapper.updateType();


        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes addGoods(AdminAddGoods adminAddGoods) throws Exception {
        BaseRes baseRes = new BaseRes();
        String desc = adminAddGoods.getDesc();
        String img = adminAddGoods.getImg();

        // http://192.168.2.100:8080/aaa/#/
        String imgUrl = "http://" + urlIp + ":" +port + img;
        adminAddGoods.setImg(imgUrl);


        String name = adminAddGoods.getName();
        String typeId = adminAddGoods.getTypeId();
        List<Specs> specList = adminAddGoods.getSpecList();
        for (Specs specs : specList) {
            if (adminAddGoods.getUnitPrice() == null){
                adminAddGoods.setUnitPrice(specs.getUnitPrice());
                adminAddGoods.setStockNum(specs.getStockNum());
            }else if (adminAddGoods.getUnitPrice()> specs.getUnitPrice()){
                adminAddGoods.setUnitPrice(specs.getUnitPrice());
                adminAddGoods.setStockNum(adminAddGoods.getStockNum()+specs.getStockNum());
            }else {
                adminAddGoods.setStockNum(adminAddGoods.getStockNum()+specs.getStockNum());
            }


        }
        adminGoodsMapper.insertGoods(adminAddGoods);
        for (Specs specs : specList) {
            specs.setId(adminAddGoods.getId());
            adminGoodsMapper.insertGoodsDetail(specs);
        }



        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes deleteGoods(AdminAddGoods adminAddGoods) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = adminAddGoods.getId();

        adminGoodsMapper.deleteGoodsById(id);

        adminGoodsMapper.deleteGoodsDetailById(id);
        adminGoodsMapper.deleteOrderByGoodsId(id);
        adminGoodsMapper.deleteMessageByGoodsId(id);

        baseRes.setCode(0);
        return baseRes;
    }

    @Override
    public BaseRes getGoodsInfo(AdminAddGoods adminAddGoods) throws Exception {
        BaseRes baseRes = new BaseRes();
        Integer id = adminAddGoods.getId();

        Good good = adminGoodsMapper.getGoodsInfoById(id);
        List<Specs> listSpecs = adminGoodsMapper.selectSpecsById(id);
        HashMap<Object, Object> map = new HashMap<>();

        map.put("goods",good);
        map.put("specs",listSpecs);
        baseRes.setCode(0);
        baseRes.setData(map);
        return baseRes;
    }

    @Override
    public BaseRes updateGoods(UpdateGoods updateGoods) throws Exception {
        BaseRes baseRes = new BaseRes();
        List<Specs> specList = updateGoods.getSpecList();
        Integer sumStock =  0;
        Float minimumPrice = 0.0f;

        String img = updateGoods.getImg();
        if (img.contains(urlIp)){}else {

            //img 中没有拼接ip和端口
            String imgUrl = "http://" + urlIp + ":" +port + img;
            updateGoods.setImg(imgUrl);
        }


        for (Specs specs : specList) {
            Integer stockNum = specs.getStockNum();
            float unitPrice = specs.getUnitPrice();
            if (minimumPrice < 0.1){
                minimumPrice = unitPrice;
            }
            if (unitPrice < minimumPrice){
                minimumPrice = unitPrice;
            }
            sumStock += stockNum;
        }
        updateGoods.setMinimumPrice(minimumPrice);
        updateGoods.setSumStock(sumStock);

        adminGoodsMapper.updateGoods(updateGoods);


//        adminGoodsMapper.deleteGoodsDetailById(Integer.parseInt(updateGoods.getId()));
        for (Specs specs : specList) {
//            specs.setId(Integer.parseInt(updateGoods.getId()));
            adminGoodsMapper.updateGoodsDetail(specs);
        }

        return baseRes;
    }

    @Override
    public BaseRes addSpec(AddSpec addSpec) throws Exception {
        BaseRes baseRes = new BaseRes();
        Specs specs = new Specs();
        specs.setId(Integer.parseInt(addSpec.getGoodsId()));
        specs.setSpecName(addSpec.getSpecName());
        specs.setStockNum(Integer.parseInt(addSpec.getStockNum()));
        specs.setUnitPrice(Float.parseFloat(addSpec.getUnitPrice()));

        //先判断这个小规格是否存在(name要不同)
        List<String> names  = adminGoodsMapper.selectGoodsDetailByGoodsId(Integer.parseInt(addSpec.getGoodsId()));
        boolean bool = true;

        for (String name : names) {
            if (name.equals(addSpec.getSpecName())){
                bool = false;
                baseRes.setCode(10000);
                baseRes.setMessage("分类重复");
                return baseRes;
            }
        }

        if (bool){
            adminGoodsMapper.insertGoodsDetail(specs);
        }

        baseRes.setCode(0);
        baseRes.setData(addSpec);
        return baseRes;
    }

    @Override
    public BaseRes deleteSpec(AddSpec addSpec) throws Exception {
        BaseRes baseRes = new BaseRes();
        String goodsId = addSpec.getGoodsId();
        String specName = addSpec.getSpecName();

        adminGoodsMapper.deleteSpec(Integer.parseInt(goodsId),specName);

        return baseRes;
    }

    @Override
    public BaseRes deleteType(AdminGoodsReq adminGoodsReq, HttpServletRequest httpServletRequest) throws Exception {
        String ip = httpServletRequest.getRemoteAddr();
        List<TypeRes> types = adminGoodsMapper.getType();
        Integer typeId = adminGoodsReq.getTypeId();
        String deleteTypeName = new String();
        for (TypeRes type : types) {
            if (type.getId().intValue() == typeId.intValue()){
                deleteTypeName = type.getName();
            }
        }

        adminGoodsMapper.insertDeleteTypeIp(ip,"删除分类------:" + deleteTypeName);




        List<GoodRes> list = adminGoodsMapper.getGoodsByType(typeId);
        // 删除分类之前,要删除: 评论--->商品明细--->商品--->订单
        // 删除分类之前,要删除:  商品问答-->商品问答回复-->商品
        // 删除分类之前,要删除:  订单-->商品
        // 删除分类之前,要删除:  商品
        // 删除分类之前,要删除:  分类
        for (GoodRes goodRes : list) {
            Integer id = goodRes.getId(); // goods  ---->  id

            adminGoodsMapper.deleteMessageByGoodsId(id);  // 删除提问
            loginMapper.deleteReMessageByUserid(id);      // 删除回复

            adminGoodsMapper.deleteCommentsByGoodsId(id); // 删除评论

            adminGoodsMapper.deleteGoodsDetailById(id);   //  删除小分类
            adminGoodsMapper.deleteGoodsById(id);         //  删除商品

        }

        adminGoodsMapper.deleteType(typeId);

        BaseRes baseRes = new BaseRes();
        return baseRes;
    }
}
