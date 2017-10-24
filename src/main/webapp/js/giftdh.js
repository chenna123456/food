$(function(){
	giftsrc=loadsrc("giftsrc");
	findgift();
	$(".addtocart").click(function(){
		var num=$("#buynums").val();
		alert(num);
		$.ajax({
			type:"post",
			url:"addgift.do",
			data:{"giftsrc":giftsrc,"num":num},
			dataType:"json",
			success:function(){
				alert("添加成功");
				window.location.href="jfdh.html";
			}
		});
	});
});
function loadsrc(name){
	var s=unescape(document.cookie);
		var arr=s.split(";");
		for(var i=0;i<arr.length;i++){
			var c=arr[i];
			var d=c.split("=");
			if(d[0].trim()==name){
				var dd=d[1].split("/");
				return dd[dd.length-2]+"/"+dd[dd.length-1];
			}
		}
		return null;
}

function findgift(){
	$.ajax({
		async:false,
		type:"post",
		url:"giftBySrc.do",
		data:{"giftsrc":giftsrc},
		dataType:"json",
		success:function(data){
			document.getElementById("hzpic").src=data['src'];
			document.getElementById("buynums").max=data['count'];
			$("#prodtitle").text(data['name']);
			$("#giftname").text(data['name']);
			$("#specifications").text("规格："+data['specifications']);
			$("#model").text("型号："+data['model']);
			$("#describe").text("商品简介："+data['describe']);
			$(".bodyzone").text(data['describe']);
			$("#exchangepoint").text("所需积分："+data['exchangepoint']);
			$("#exchangetimes").text("兑换次数："+data['exchangetimes']);
		}
	});
}