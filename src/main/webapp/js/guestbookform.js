/*
 * author:刘飞
 * time:20171025
 * form表单的验证与提交
 * */
$(function(){
	changeHeadPic();
	fresh();
	
	//表单提交
	$("#sub").click(function(){
		//获取前端数据，带上这些数据给servlet发送请求
		var title = $("#input1").val();
		var name = $("#input2").val();
		var content =$("#message").val();
		var imgp = $("#headpic img").attr("src"); //获取头像路径
		var email = $("#email1").val();
		var qq = $("#qq1").val();
		var homePage = $("#homePage1").val();
		var moodUrl = $("input:radio:checked").val();  //获取【心情】路径
		var vc1 = $("#img2").val();  //获取前端客户输入的验证码

		//获取前端用户输入的验证码
		$.ajax({
			type:"post",
			url:"checkVC.do",
			data:{"vc1":vc1},
			dataType:"json",
			success:function(data){
				if(data==0){
					alert("验证码错误，请重试！");
				}
			}
		});
		if(title!=null && title!="" && name!=null && name!="" && content!=null && content!="" && imgp!=null && imgp!=""){
			$.ajax({
				type:"post",
				url:"addGuestbook.do",
				data:{"title":title,"name":name,"content":content,"imgp":imgp,
					"email":email,"qq":qq,"homePage":homePage,"moodUrl":moodUrl},
				dataType:"json",
				success:function(data){
					if(data>0){
						alert("留言成功！");
					}else{
						alert("留言失败，请重试！");
					}
				}
			});
		}else{
			alert("请填写留言信息！");
			return false;  //当弹出弹窗后，页面不刷新
		}
	});
	
	
});




//动态刷新验证码
function fresh(){
	$(".img1").attr("src","vc.do?"+Math.random());
}



//头像切换
function changeHeadPic(){
	$("#headpicsel").change(function(){
		$("#headpic img").remove();
		var hpic = this.value;
		if(hpic != ""){
			var str = "<img src='img/guestbook/"+hpic+".gif'/>";
			$("#headpic").append(str);
		}
	});
}
