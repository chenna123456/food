$(function(){
	var url = decodeURI(location.search);
	if(url.indexOf("?")!=-1){
		var str = url.substr(1);
		var strs = str.split("=");
		object = strs[1];
		
	}
	loaddetail();
	loadNotice();
	loadupdate();
	updatestatus();
	updateopp();
	
	
});

function loaddetail(){
	$.ajax({
		async:false,
		type:"post",
		url:"detail.do",
		data:{"id":object},
		success:function(data){
			var str = data.title;
			$(".newstitle").html(str);
			$("#nav span").html(str);
			$("#memo .span1").html(str);
			var s ="作者:"+data.writer+"&nbsp;&nbsp;发布于:"+new Date(data.publishtime).toLocaleString();
			$(".info").html(s);
			var st = data.content;
			$("#con").html(st);
			var so = (data.browsingamount)+1;
			$(".source .spans").append(so);
			var sup = data.supportNum;
			$("#zhichinum").html(sup);
			$("#fanduinum").html(data.opposeNum);
			
		}
	});
}

function loadupdate(){
	var browsing = $(".source .spans").text();
	$.ajax({
		typw:"post",
		url:"updateBrowsing.do",
		data:{"id":object,"browsing":browsing},
		dataType:"json",
	});
}
function checkByName(name){
	var s = unescape(document.cookie);
	var arr = s.split(";");
	for(var i = 0;i<arr.length;i++){
		var ar = arr[i];
		var a = ar.split("=");
		if(a[0].trim()==name){
			return a[1];
		}
	}
}
function loadNotice(){
	 $.ajax({
		 type:"post",
		 url:"notice.do",
		 data:{},
		 dataType:"json",
		 success:function(data){
			 for(var i = 0;i<data.length;i++){
				 var str = "<li class='newslist' style='background: transparent url(imgs/no"+(i+1)+".gif) left no-repeat;padding-left:25px'>"+
					"<a href='detail.html?id="+data[i].id+"' target='_self' class='newslist'>"+data[i].title+"</a>"
					+"</li>";
				 $("#morenotice").append(str);
			 }
			 
		 }
	 });
}
Date.prototype.toLocaleString = function(){
	var year = this.getFullYear();
	var month = this.getMonth()+1;
	month = month<=9?"0"+month:month;
	var date = this.getDate();
	date = date<=9?"0"+date:date;
	var hours = this.getHours();
	hours = hours<=9?"0"+hours:hours;
	var minutes = this.getMinutes();
	minutes = minutes<=9?"0"+minutes:minutes;
	var seconds = this.getSeconds();
	seconds = seconds<=9?"0"+seconds:seconds;
	return (year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+seconds);
}

function updatestatus(){
	$("#zhichi").click(function(){
		sup = $("#zhichinum").text();
		$.ajax({
			type:"post",
			url:"status.do",
			data:{"aid":object,"sup":sup},
			dataType:"json",
			success:function(data){
				var sups = data.supportNum;
				$("#zhichinum").html(sups);
			}
			
		});
	});
	
}
function updateopp(){
	$("#fandui").click(function(){
		opp = $("#fanduinum").text();
		$.ajax({
			type:"post",
			url:"oppsta.do",
			data:{"aid":object,"opp":opp},
			dataType:"json",
			success:function(data){
				$("#fanduinum").html(data.opposeNum);
			}
		});
	});
}


