$(function(){
	 var a = checkByName("type");
	 if(a==""||a==null){
		 return false;
	 }
	loadfood();
	loadlist();
	loadNotice();
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
		loadlist();
		loadfood();
	});
	 
	
});
var e = 1;
var page = 1;
var pageSize = 3;
function loadfood(){
	var a = checkByName("type");
	$.ajax({
		type:"post",
		url:"foodCulture.do",
		data:{"page":page,"pageSize":pageSize,"type":a},
		dataType:"json",
		success:function(data){
			loadPages(data);
		}
		
	});
}

function loadPages(data){
	var a = data.allPage;
	var str = " ";
	
	$(".page").empty();
	for(var i =1;i<=a;i++){
		str+="<li class='pagesnow' value='"+i+"'>"+"<a href='#'>"+i+"</a>"+"</li>";
		
	}
	$(".page").append(str);
	if(data.allCount<pageSize){
		pageSize=data.allCount;
	}
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
		loadfood();
		loadlist();
	});
	$(".options").change(function(){
		
		page = $(".options option:selected").val();
		e = page;
		loadfood();
		loadlist();
	})
}
function loadlist(){
	var a = checkByName("type");
	
	$.ajax({
		type:"post",
		url:"foodCulture.do",
		data:{"page":page,"pageSize":pageSize,"type":a},
		dataType:"json",
		success:function(data){
			var list = data.list;
			$("#queryul li").remove();
			for(var i = 0 ; i<list.length;i++){
				var st = "<li class='title'>"+"<div class='title'>"
				+"<a href='detail.html?id="+list[i].id+"' target='_self'>"+list[i].title+"</a>"
				+"</div>"+"<div class='time'>"+new Date(list[i].publishtime).toLocaleString()+"</div>"+"</li>"
				$("#queryul").append(st);
			}
		}
	});
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

Date.prototype.toLocaleString = function(){
	var year = this.getFullYear();
	var month = this.getMonth()+1;
	month = month<9?"0"+month:month;
	var date = this.getDate();
	date = date<=9?"0"+date:date;
	return (year+"-"+month+"-"+date);
}
 function loadNotice(){
	
	 $.ajax({
		 type:"post",
		 url:"foodCulture.do",
		 data:{"page":page,"pageSize":pageSize,"type":a},
		 dataType:"json",
		 success:function(data){
			 var data = data.list1;
			 for(var i = 0;i<data.length;i++){
				 var str = "<li class='newslist' style='background: transparent url(imgs/no"+(i+1)+".gif) left no-repeat;padding-left:25px'>"+
					"<a href='detail.html?id="+data[i].id+"' target='_self' class='newslist'>"+data[i].title+"</a>"
					+"</li>";
				 $("#morenotice").append(str);
			 }
			 
		 }
	 });
 }
