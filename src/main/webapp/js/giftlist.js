$(function() {
	page=parseInt("1");
	pageSize=parseInt("6");
	pages=parseInt("0");
	load();
	gitftop();
	//首页点击按钮
	$(".first_page").click(function() {
		if (page == 1) {
			alert("这就是首页");
			return false;
		} else {
			page = 1;
			zengpingye();
		}
	});
	//最后一页店家按钮
	$(".last_page").click(function() {
		if (page == pages) {
			alert("这就是尾页");
			return false;
		} else {
			page = pages;
			zengpingye();
		}
	});
	//上一页点击按钮
	$(".up_page").click(function() {
		if (page <= 1) {
			alert("已经是第一页");
			return false;
		} else {
			page--;
			zengpingye();
		}
	});
	//下一页点击按钮
	$(".next_page").click(function() {
		if (page >= pages) {
			alert("已经是最后一页");
		} else {
			page++;
			zengpingye();
		}
	});
	$(".select_pages").change(function() {
		page = parseInt(this.value);
		load();
	});
});
function load() {
	$(".body_u").empty();
	$(".page_list").empty();
	$(".select_pages").empty();
	$.ajax({
		async : false,
		type : "post",
		url : "giftlist.do",
		data : {"page":page,"pageSize":pageSize},
		dataTye : "json",
		success : function(data) {
			var list2=data['listgift'];
			$("#number").text(list2.length);
			pages=parseInt(data['pages']);
			$("#pages").text(pages);
			for(var i=1;i<=pages;i++){
				var sp="<button value='"+i+"' style='width:15px;'>"+i+"</button>"
				$(".page_list").append(sp);
				sp="<option value='"+i+"'>第"+i+"页</option>";
				$(".select_pages").append(sp);
			}
			$(".page_list button").click(function(){
				var pagenn=parseInt(this.value);
				if(page!=pagenn){
					page=pagenn;
					load();
				}
			});
			var list=data['listExchangegift'];
			var s = "";
			for (var i = 0; i < list.length; i++) {
				s += "<li class='hzquery'><div class='hzquery_left'>"
						+ "<div class='fang'><div class='picFit'>"
						+ "<a href='#' target=''>" + "<img src='" + list[i].src
						+ "' class='prodtitle' /></a>"
						+ "</div></div></div><div class='hzquery_right'>"
						+ "<ul class='right_top'><li>序号:<font>" + (i + 1)
						+ "</font></li>"
						+ "<li>赠品名称:<a href='' target='' class='prodtitle'>"
						+ list[i].name + "</a></li><li>兑换积分:<font>"
						+ list[i].exchangepoint + "</font></li><li>兑换数量:"
						+ "<font>" + list2[i].number + "</font>件</li><li>日期:"
						+ "<font>" + list2[i].exchangeDate
						+ "</font></li></ul>" + "</div></li>";
			}
			$(".body_u").append(s);
		}

	});
}
function gitftop(){
	$(".hz_paihang").empty();
	$.ajax({
		type:"post",
		url:"gifttop.do",
		data:{"number":4},
		dataType:"json",
		success:function(data){
			var sg="";
			for(var i=0;i<data.length;i++){ 
				//alert(data[i].src);
				sg +="<li class='hzi_paihang' value='"+
						data[i].src+"'>" +
						"<a href='#' target='_self' " +
						"class='hza_paihang'>"+data[i].name+"</a></li>";
				
			}
			$(".hz_paihang").append(sg);
			$(".hzi_paihang").click(function(){
				var giftsrc=$(this).attr("value");
				//alert(giftsrc);
				document.cookie="giftsrc="+escape(giftsrc);
				window.open("giftdh.html");
			});
		}
	});
}