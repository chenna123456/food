$(function(){
	 var a = checkByName("type");
	 if(a!=""&&a!=null){
		 return false;
	 }
	loadMore();
	loadlists();
	
	$(".pbutton").click(function(){
		var v = this.value;
		
		var lastPage = $(".page li:last").val();
		
		if(v==2){
			if(page<=1){
				page = 1;
				e = page;
			}else{
				page--;
				e = page;
			}
		}else if(v==3){
			if(page>=lastPage){
				page = lastPage;
				e = page;
			}else{
				page++;
				e = page;
				
			}
		}else if(v==1){
			page = 1;
			e = page;
			
		}else if(v==4){
			page = lastPage;
			e = page;
			
		};
		loadlists();
		loadMore();
	});
	 
})
var pageSize = 10;
var page = 1;
function loadMore(){
	$.ajax({
		type:"post",
		url:"more.do",
		data:{"page":page,"pageSize":pageSize},
		dataType:"json",
		success:function(data){
			var a = data.allPage;
			var str = " ";
			
			$(".page").empty();
			for(var i =1;i<=a;i++){
				str+="<li class='pagesnow' value='"+i+"'>"+"<a href='#'>"+i+"</a>"+"</li>";
				
			}
			$(".page").append(str);
			var al = "共"+data.allCount+"条"+"  "+"每页"+pageSize+"条"+"  "+"页次:"+e+"/"+a;
			$("#pagesinfo").html(al);
			var s = " ";
			$(".options option").remove();
			for(var i = 1;i<=a;i++){
				s+="<option value='"+i+"'" ;
				if(i==page){
					s+="selected='true'";
				}
					s+=">第"+i+"页</option>";
			}
			$(".options").append(s);
			$(".pagesnow").click(function(){
				page = this.value;
				e = page;
				loadMore();
				loadlists();
			});
			$(".options").change(function(){
				page = $(".options option:selected").val();
				e = page;
				loadMore();
				loadlists();
			});
			
			
			
		}
	});
}

function loadlists(){
	$.ajax({
		type:"post",
		url:"more.do",
		data:{"page":page,"pageSize":pageSize},
		dataType:"json",
		success:function(data){
			var list = data.list;
			$("#queryul li").remove();
			for(var i = 0 ;i<list.length;i++){
				var st = "<li class='title'>"+"<div class='title'>"
				+"<a href='detail.html?id="+list[i].id+"' target='_self'>"+list[i].title+"</a>"
				+"</div>"+"<div class='time'>"+new Date(list[i].publishtime).toLocaleString()+"</div>"+"</li>"
				$("#queryul").append(st);
			}
		}
	});
}
Date.prototype.toLocaleString = function(){
	var year = this.getFullYear();
	var month = this.getMonth()+1;
	month = month<9?"0"+month:month;
	var date = this.getDate();
	date = date<=9?"0"+date:date;
	return (year+"-"+month+"-"+date);
}
function checkByName(name){
	var s = unescape(document.cookie);
	
	var arr = s.split(";");
	for(var i =0;i<arr.length;i++){
		var ar = arr[i];
		var d = ar.split("=");
		if(d[0].trim()==name){
			return d[1];
		}
		
	}
	return " ";
}

	
		
		






