$(function(){
	$("#sub").click(function(){
			var title = $("#input1").val();
			var vipName = $("#input2").val();
			var content = $("#message").val();
			if(title!=null && title!="" && vipName!=null && vipName!="" && content!=null && content!="" ){
				$.ajax({
					type:"post",
					url:"ac.do",
					data:{"title":title,"vipName":vipName,"content":content},
					dataType:"json",
					success:function(data){
						if(data==1){
							alert("评论成功！");
						}else{
							alert("评论失败，请重试！");
							return false;
						}
					}
				});
			}else{
				alert("评论没填写完整，请补充！");
				return false;
			}
	});
});


