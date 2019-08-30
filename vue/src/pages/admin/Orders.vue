<template>
  <div class="Orders">
    <header class="clear">
  		<span>订单管理</span>
  	</header>
  	<Tag :tagList="tags" @indexChange="getOrdersByPage"/>
  	<div class="content">
  		<table class="ordersTable">
	        <thead>
	        	<tr><th>订单号</th><th>用户昵称</th><th>收件人</th><th>收货地址</th><th>联系电话</th><th>商品</th><th>规格</th><th>购买数量</th><th>金额</th><th>订单状态</th><th>更新时间</th><th>操作</th></tr>
	        </thead>
	        <tbody>
	            <tr v-for="(item,index) in orderList" :key="'order'+item.id">
	            	<td>{{item.id}}</td>
	            	<td>{{item.user.nickname}}</td>
	            	<td>{{item.user.name}}</td>
	            	<td>{{item.user.address}}</td>
	            	<td>{{item.user.phone}}</td>
	            	<td>{{item.goods}}</td>
	            	<td>{{item.spec}}</td>
	            	<td>{{item.goodsNum}}</td>
	            	<td>{{item.amount}}</td>
	            	<td>{{item.state}}</td>
	            	<td>{{item.time}}</td>
	                <td><button class="normal" @click="editOrder(item.id)">编辑</button><button class="delete" @click="deleteOrder(item.id)">删除</button></td>
	            </tr>
	        </tbody>
	    </table>

      <div class="block" style="text-align: center">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10]"
          :page-size="pagesize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
        </el-pagination>
      </div>

  	</div>
  </div>
</template>

<script>
import {getOrdersByPage,getOrders,deleteOrder} from '../../api/admin';
import Tag from '../../components/Tag';
export default {
  name: 'Orders',
  components:{
  	Tag
  },
  computed:{
  },
  data(){
  	return{
  		tags:['全部','未付款','未发货','已发货','已到货'],
  		orderList:[],


      currentPage: 1,// 当前页
      pagesize: 5, // 当前页条目
      total: 5,  // 条目数

      index:0
  	}
  },
  methods:{
    handleSizeChange(size) {
        this.pagesize = size
        this.getOrdersByPage(this.index)
    },
    handleCurrentChange(currentPage) {
        this.currentPage = currentPage
        this.getOrdersByPage(this.index)
    },
    getOrdersByPage(index){
        this.index = index
        const state = index-1; //  -1:全部信息,0:未付款,1:已付款, 2:已发货,3:已完成订单
        const currentPage = this.currentPage; // 第几页
        const pagesize = this.pagesize; // 页中有几条

        const res = getOrdersByPage({
            state,
            currentPage,
            pagesize
        });
        res.then((data)=>{
                this.orderList = data.orders;
                this.total = data.total;
            })
            .catch((e)=>{
                alert(e);
            })
    },

  	changeTag(index){
  		const res = getOrders(index-1);
  		res
  		.then((orders)=>{
  			this.orderList = orders;
  		})
  		.catch((e)=>{
  			alert(e);
  		})
  	},
  	editOrder(id){
  		this.$router.push('/backstage/orders/'+id)
  	},
  	deleteOrder(id){
  		const res = deleteOrder(id);
  		res
  		.then(()=>{
  			alert('删除成功');
  			this.orderList.map((item,index)=>{
  				if(item.id===id){
  					this.orderList.splice(index,1);
  				}
  			})
  		})
  		.catch((e)=>{
  			alert(e);
  		})
  	}
  },
  mounted(){
  	this.getOrdersByPage(0);
  }
}
</script>

<style scoped lang="less">
@import "../../assets/css/var.less";
.Orders{
	header{
		width: 100%;
		height: 40px;
		line-height: 40px;
		span{
			float: left;
		}
	}
	.content{
		width: 100%;
		background-color: white;
		position: relative;
		top: -3px;
		padding: 5px;
		.ordersTable{
			width: 100%;
			th{
				text-align: center;
			}
			tbody{
				tr{
					td{
						max-width: 100px;
						min-width: 30px;
						text-align: center;
						button{
							display: block;
							overflow: hidden;
							margin-bottom: 5px;
						}
					}
				}
			}
		}
	}
}
</style>
