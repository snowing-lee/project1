package com.cskaoyan.wdjava.admin.controller;

import com.cskaoyan.wdjava.admin.service.AdminSelectService;
import com.cskaoyan.wdjava.base.BaseRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@RestController
public class AdminImgUploadController {

    @Value("${wd.uploadPath}")
    String filePath;


    @RequestMapping(value = "/api/admin/imgUpload" , method = RequestMethod.POST)
    public BaseRes ImgUpload(@RequestParam("file") MultipartFile img,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             HttpSession session){
        BaseRes baseRes = new BaseRes();
        if (img.isEmpty()){
            baseRes.setCode(10000);
            baseRes.setMessage("上传图片为空");
            return baseRes;
        }

        String path=null;
        String type=null;
        String trueFileName = "";

        try {
            String fileName = img.getOriginalFilename();
            trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;

            path = filePath + trueFileName;
            System.out.println("--------");
            System.out.println(path);
            img.transferTo(new File(path));

        } catch (Exception e) {
            e.printStackTrace();
        }

        baseRes.setCode(0);
        baseRes.setData("/static/image/" + trueFileName);
        return baseRes;
    }


}
