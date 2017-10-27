/*
 * author:刘飞
 * time:20171024
 * 留言信息的展示
 * */

$(function(){
	loadGuestbook();
	loadPages();
	loadDropDownList();
});

var page = 1;
/*展示留言信息*/
function loadGuestbook(){
	$.ajax({
		type:"post",
		url:"guestbook.do",
		data:{"page":page},
		dataType:"json",
		success:function(data){
			var str = "";
			var list = data.list;
			$("#guestbookquery div").remove();
			$("#showpages #pagesinfo").remove();
			$(".pagesnow input").remove();
			for(var i=list.length-1; i>=0; i--){
				str += "<div class='guestbook'>"+
					"<div class='auinfo'>" +
							"<div class='aupic'>"+"<img src='"+list[i].vipUrl+"' border='0'/>"+"</div>"+
							"<div class='auname'>"+list[i].vipName+"</div>"+
							"<div class='lynum'>第"+list[i].id+"条留言 </div>"+
						"</div>"+
				"<div class='gbinfo'>" +
					"<div class='ttinfo'>"+
						"<div class='title'>标题："+list[i].title+"</div>"+
						"<div class='fjinfo'><img src='img/guestbook/homepage.gif' border='0'/><a href='#'>主页</a>&nbsp;&nbsp;<img src='img/guestbook/email.gif' border='0'>信箱&nbsp;&nbsp;<img src='img/guestbook/qq.gif' border='0'>&nbsp;QQ</div>"+
					"</div>"+
					"<div class='lyinfo'>"+
						"<div class='bdinfo2'>"+list[i].content+"</div>"+
					"</div>"+
					"<div class='hfinfo'>" +
						"<div class='hf' style='display:none;'>版主回复：</div>"+
						"<div class='hfanswer' style='display:none'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>"+
					"</div>"+
					"<div class='btinfo'>" +
						"<img src='img/guestbook/posttime.gif' border='0'/>&nbsp;&nbsp;"+new Date(list[i].publishtime).toLocaleString()+"&nbsp;&nbsp;&nbsp;&nbsp;<img src='img/guestbook/ip.gif' border='0'>&nbsp;&nbsp;117.34."+list[i].id+".62"+
					"</div>"+
				"</div>"+
				"</div>";
			}
			$("#guestbookquery").append(str);
			
			
			/*加载【留言信息表】左下角页码信息*/
			var str1 = "<div id='pagesinfo'>" +
							"共" +data.count+"条留言&nbsp;&nbsp;每页8条&nbsp;&nbsp;页次：1/"+data.pages+""+
						"</div>";
			$("#showpages").append(str1);
			
			
			/*加载【留言信息表】右下角数字页码信息*/
			var str1 = "";
			for(var j=1; j<=data.pages; j++){
				str1 += "<input  type='button' value='"+j+"'/>";
			}
			$(".pagesnow").append(str1);
			$(".pagesnow input").click(function(){
				page = this.value;
				loadGuestbook();
			});
			
		}
	});
}


/*加载页*/
function loadPages(){
	/*首页、尾页*/
	$("#pbutton1").click(function(){
		page = 1;
		loadGuestbook();
	});
	
	
	/*尾页*/
	$("#pbutton2").click(function(){
		var maxPage = $(".pagesnow input:last").val();
		page = maxPage;
		loadGuestbook();
	});
	
	
	/*上一页，下一页*/
	$(".pbutton .xx").click(function(){
		var ss = this.value;
		if(ss =="上一页"){
			if(page<=1){
				alert("已经是第一页了！");
				page = 1;
			}else{
				page--;
			}
		}else{
			var maxPage = $(".pagesnow input:last").val();
			if(page>=maxPage){
				alert("已经是最后一页了!");
				page = maxPage;
			}else{
				page++;
			}
		}
		loadGuestbook();
	});
}

//下拉列表页
function loadDropDownList(){
	$.ajax({
		type:"post",
		url:"guestbook.do",
		data:{"page":page},
		dataType:"json",
		success:function(data){
			for(var i=1; i<=data.pages; i++){
				var str = "<option value='"+i+"'>第"+i+"页</option>";
				$(".opt select").append(str);
			}
			$(".opt select").click(function(){
				page = this.value;
				loadGuestbook();
			});
		}
	});
}

//把毫秒值时间转化为普通时间显示
Date.prototype.toLocaleString = function() {
    var year=this.getFullYear();
    var month=this.getMonth() + 1;
    month=month<=9?"0"+month:month;
    var date=this.getDate();
    date=date<=9?"0"+date:date;

    var hours=this.getHours();
    hours=hours<=9?"0"+hours:hours;
    var minutes=this.getMinutes();
    minutes=minutes<=9?"0"+minutes:minutes;
    var seconds=this.getSeconds();
    seconds=seconds<=9?"0"+seconds:seconds; 

    return (year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+seconds);
};


