$(function(){
	loadculture();
	loadhealth();
	loadpeople();
	loadthin();
	loadNotice();
	$("a button").click(function(){
		var type = this.value;
		document.cookie = "type="+escape(type);
		window.open("more.html");
		
	});
	
});
var page = 1;
var type = "饮食文化";
var ids = "culture";
var pageSize = 5;
function loadculture(){
	$.ajax({
		async:false,
		type:"post",
		url:"foodCulture.do",
		data:{"page":page,"type":type,"pageSize":pageSize},
		dataType:"json",
		success:function(data){
			var list = data.list;
			for(var i = 0;i<list.length;i++){
				var str = "<li class='newslist_time'>"+"<div class='time'>"+new Date(list[i].publishtime).toLocaleString()+"</div>"+
				"<a href='detail.html?id="+list[i].id+"' target='_self' class='newslist_time'>"+list[i].title+"</a>"+"</li>";
				
				$("#"+ids+"").append(str);
			}
		}

	});

};
function loadhealth(){
	type = "饮食健康";
	ids = "health";
	loadculture();
};
function loadpeople(){
	type = "饮食男女";
	ids = "people";
	loadculture();
};
function loadthin(){
	type="饮食瘦身";
	ids = "thin";
	loadculture();
}
Date.prototype.toLocaleString = function(){
	var month = this.getMonth()+1;
	month = month<9?"0"+month:month;
	var date = this.getDate();
	date = date<9?"0"+date:date;
	return(month+"-"+date);
}
function loadNotice(){
	 
	 $.ajax({
		 type:"post",
		 url:"foodCulture.do",
		 data:{"page":page,"type":type,"pageSize":pageSize},
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




