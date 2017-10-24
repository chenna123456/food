$(function() {
	type1 = "";
	page = parseInt("1");
	pages = 0;
	minPoint = 0;
	pageSize = 4;
	maxPoint = 1000;
	load();
	gitftop();
	// 检索店家提交按钮
	$("#imgField").click(function() {
		type1 = $("#zengpinfenlei").val();
		page = parseInt("1");
		pageSize = $(".myshownums").val();
		var minPoints = $("#cent_in_min").val();
		if (minPoints != null && minPoints != "") {
			minPoint = minPoints;
		}
		var maxPoints = $("#cent_in_max").val();
		if (maxPoints != null && maxPoints != "") {
			maxPoint = maxPoinsts;
		}
		zengpingye();
	});
	// 首页点击按钮
	$(".first_page").click(function() {
		if (page == 1) {
			alert("这就是首页");
			return false;
		} else {
			page = 1;
			zengpingye();
		}
	});
	// 最后一页店家按钮
	$(".last_page").click(function() {
		if (page == pages) {
			alert("这就是尾页");
			return false;
		} else {
			page = pages;
			zengpingye();
		}
	});
	// 上一页点击按钮
	$(".up_page").click(function() {
		if (page <= 1) {
			alert("已经是第一页");
			return false;
		} else {
			page--;
			zengpingye();
		}
	});
	// 下一页点击按钮
	$(".next_page").click(function() {
		if (page >= pages) {
			alert("已经是最后一页");
		} else {
			page++;
			zengpingye();
		}
	});
	$(".select_pages").change(function() {
		page = this.value;
		zengpingye();
	});
});
function load() {
	$.ajax({
		type : "post",
		url : "zengpintype.do",
		data : {},
		dataType : "json",
		success : function(data) {
			var s = "";
			for (var i = 0; i < data.length; i++) {
				s += "<option value='" + data[i].type + "'>" + ""
						+ data[i].type + "</option>";
			}
			$("#zengpinfenlei").append(s);
		}
	});
	// 积分输入框聚焦事件
	$("#cent_in_min").focus(function() {
		var s = $("#cent_in_min").val();
		if (s == "请输入积分值范围") {
			$("#cent_in_min").val("");
		}
	});
	// 积分输入框，失去焦点事件
	$("#cent_in_min").blur(function() {
		var s = $("#cent_in_min").val();
		if (s == "") {
			$("#cent_in_min").val("请输入积分值范围");
		}
	});
	$("#cent_in_max").focus(function() {
		var s = $("#cent_in_max").val();
		if (s == "请输入积分值范围") {
			$("#cent_in_max").val("");
			;
		}
	});
	$("#cent_in_max").blur(function() {
		var s = $("#cent_in_max").val();
		if (s == "") {
			$("#cent_in_max").val("请输入积分值范围");
		}
	});
	zengpingye();
}
// 赠品页获得数据
function zengpingye() {
	$(".body_u").empty();
	$(".page_list").empty();
	$(".select_pages").empty();
	/* alert(type1); */
	/* alert(page); */
	/*
	 * alert(pageSize); alert(minPoint); alert(maxPoint);
	 */
	$.ajax({
		type : "post",
		url : "zengpin.do",
		data : {
			"type" : type1,
			"pageNo" : page,
			"pageSize" : pageSize,
			"minPoint" : minPoint,
			"maxPoint" : maxPoint
		},
		dataType : "json",
		success : function(data) {
			var number = data['number'];
			$("#number").text(number);
			pages = parseInt(data['pages']);
			$("#pages").text(pages);
			var pl = "";
			// 得到页码列表
			for (var i = 1; i <= pages; i++) {
				pl += "&nbsp;&nbsp;<button value='" + i + "'>&nbsp;" + i
						+ "&nbsp;</button>&nbsp;&nbsp;";
			}
			$(".page_list").append(pl);
			// 页码号码上的点击事件
			$(".page_list button").click(function() {
				pagenn = parseInt(this.value);
				if (page != pagenn) {
					page = pagenn;
					zengpingye();
				}
			});

			var sp = "";
			// 获得页码下拉列表
			for (var i = 1; i <= pages; i++) {
				sp += "<option value='" + i + "'";
				// 设置页码下拉框为当前页
				if (i == page) {
					sp += " selected='true'";
				}
				sp += ">第" + i + "页</option>";
			}
			$(".select_pages").append(sp);
			var s = "";
			var list = data['list'];
			// 得到商品的对应结果
			for (var i = 0; i < list.length; i++) {
				s += "<li class='hzquery' >" + "<div class='hzquery_left'>"
						+ "<div class='fang'>" + "<div class='picFit' >"
						+ "<a href='#' target=''>" + "<img  src='"
						+ list[i].src
						+ "' class='prodtitle'  /></a>"
						+ "</div></div></div>"
						+ "<div class='hzquery_right'>"
						+ "<ul class='right_top'>"
						+ "<li>赠品名称:<button class='prodtitle2' "
						+ " value='"
						+ list[i].src
						+ "'>"
						+ "<a href='#' target='' "
						+ " >"
						+ list[i].name
						+ "</a></button></li>"
						+ "<li>所需积分:<font>"
						+ list[i].exchangepoint
						+ "</font>分</li>"
						+ "<li>可换件数:<font>"
						+ list[i].count
						+ "</font>件</li></ul>"
						+ "<div class='right_bottom'>"
						+"<button class='prodtitle2' "
						+ " value='"
						+ list[i].src
						+ "'>"
						+ "<img class='bottom_img' src='img/jfdh.gif' /></button>"
						+ "</div></div></li>";

			}
			$(".body_u").append(s);
			$(".prodtitle").click(function() {
				var giftsrc = this.src;
				alert(giftsrc);
				document.cookie = "giftsrc=" + escape(giftsrc);
				window.open("giftdh.html");
			});
			$(".prodtitle2").click(function() {
				var giftsrc = this.value;
				alert(giftsrc);
				document.cookie="giftsrc="+escape(giftsrc);
				window.open("giftdh.html");
			});

		}
	});
}

function gitftop() {
	$(".hz_paihang").empty();
	$.ajax({
		type : "post",
		url : "gifttop.do",
		data : {
			"number" : 4
		},
		dataType : "json",
		success : function(data) {
			var sg = "";
			for (var i = 0; i < data.length; i++) {
				// alert(data[i].src);
				sg += "<li class='hzi_paihang' value='" + data[i].src + "'>"
						+ "<a href='#' target='_self' "
						+ "class='hza_paihang'>" + data[i].name + "</a></li>";

			}
			$(".hz_paihang").append(sg);
			$(".hzi_paihang").click(function() {
				var giftsrc = $(this).attr("value");
				// alert(giftsrc);
				document.cookie = "giftsrc=" + escape(giftsrc);
				window.open("giftdh.html");
			});
		}
	});
}