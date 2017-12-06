<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%String context=request.getContextPath();%>    
<script src="<%=context %>/js/vue.js"></script>
<style>
	.message{
	    min-width: 380px;
	    box-sizing: border-box;
	    border-width: 1px;
	    border-style: solid;
	    border-color: #e6ebf5;
	    position: fixed;
	    left: 50%;
	    top: 50px;
	    -webkit-transform: translateX(-50%);
	    transform: translateX(-50%);
	    background-color: #edf2fc;
	    -webkit-transition: opacity .3s,-webkit-transform .4s;
	    transition: opacity .3s,-webkit-transform .4s;
	    transition: opacity .3s,transform .4s;
	    transition: opacity .3s,transform .4s,-webkit-transform .4s;
	    padding: 15px 15px 15px 20px;
	    display: -webkit-box;
	    display: flex;
	    align-items: center;
	}
	.message-error{
	    background-color: #fee;
    	border-color: #fedddd;
	}
	.message-content{
		margin:0;
	    padding: 0;
	    font-size: 14px;
	    line-height: 1;
	}
	.message-error .message-content{
		color:#fa5555;
	}
   	.drop-enter-active, .drop-leave-active{
      transition: all .3s;
    }
    .drop-enter, .drop-leave-to{
    	transform: translate(0px,20px);
    	opacity:1;
    }
</style>
<transition name="drop">
	<div id="alert" class="message message-error" style="z-index:2000;" v-show="isShow">
		<p class="message-content">关键字不能为空哦！</p>
	</div>
</transition>
<script>	
	var alert = [];
	var nodeList = document.querySelectorAll(".message");
	var len = nodeList.length;
	var node = nodeList[len-1];
	console.log(node,nodeList.length)
	alert[len] = new Vue({
		el: node,
		data:{
			duration:2000,
			timer:null,
			isShow:false
		},		
		mounted(){
			console.log(this)
		},
		methods: {
			show(){
				var me = this;
				clearInterval(this.timer);
				this.isShow = true;
				this.timer = setInterval(function(){
					me.hide();
				},this.duration)
			},
			hide(){
				this.isShow = false;
			}
			
		}
	})
</script>