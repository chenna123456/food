$(function() {
	page = 1;
	pageSize = 4;
	// 先把所有的隐藏
	$("#tousu").hide();
	$("#job").hide();
	$("#tousu").hide();
	loadNavigation();
	loadjob();
	$(".titlemenu_ll").click(function() {
		$("#tousu").hide();
		$("#job").hide();
		$("#pagecontent").show();
		var i = $(this).attr("value");
		$("#aress").text(list[i - 1].title);
		var ss = "";
		$("#pagecontent").html(list[i - 1].text);
	});
	$(".titlemenu_yc").click(function() {
		$("#aress").text("诚聘英才");
		$("#tousu").hide();
		$("#pagecontent").hide();
		$("#job").show()
	});
	$(".titlemenu_ts").click(function() {
		$("#aress").text("投诉建议");
		$("#pagecontent").hide();
		$("#job").hide();
		$("#tousu").show();
	});
	$(".submit").click(function(){
		addcomplaint();
	});
});

function loadNavigation() {
	$(".titlemenu_ll").remove();
	$(".tousu").hide();
	// $("#pagecontent").text(123);
	$
			.ajax({
				async : false,
				type : "post",
				url : "loadNavigation.do",
				data : {},
				dataType : "json",
				success : function(data) {
					list = data;
					$("#pagecontent").html(list[0].text);
					var s = "";
					for (var i = 0; i < list.length; i++) {
						s += "<a href='#' target='_self' "
								+ "class='titlemenu_ll' value='" + list[i].id
								+ "'>" + list[i].title + "</a> ";
					}
					s += "<a href='#' target='_self' class='titlemenu_yc' >诚聘英才</a>"
							+ "<a href='#' target='_self' class='titlemenu_ts'>投诉建议</a>";
					$(".titlemenu_b2").append(s);
				}
			});
}

function loadjob() {
	$(".queryul").empty();
	$.ajax({
		asnyc : false,
		type : "post",
		url : "selectalljob.do",
		data : {
			"page" : page,
			"pageSize" : pageSize
		},
		dataType : "json",
		success : function(data) {
			var data1 = data['list'];
			var s = "";
			for (var i = 0; i < data1.length; i++) {
				s += "<li><div class='bt'><a href='#' target='_self'>"
						+ data1[i].name + "</a></div>" + "<div class='au'>"
						+ data1[i].number + "</div><div " + "class='bk'>"
						+ data1[i].address + "</div>"
						+ "<div class='cl'><a href='#' " + "target='_self'>"
						+ data1[i].monery + "</a></div>"
				"</li>";
			}
			$(".queryul").append(s);
			s = "<div id='pagesinfo'>" + "共<sapn id='total'>" + data['total']
					+ "</span>个职位&nbsp;&nbsp;" + "每页<span id='pageSize'>"
					+ data['pageSize'] + "</span>"
					+ "个 &nbsp; &nbsp; &nbsp;页次：" + data['page'] + "/"
					+ data['pages'] + "</div>"
					+ "<div id='pages'><ul><li class='pbutton' id='first'><a"
					+ " href='#'>首页</a></li><li class='pbutton' id='up_page'>"
					+ "上一页</li>";
			for (var i = 0; i < data['pages']; i++) {
				s += "<li class='pagesnow'>" + (i + 1) + "</li>";
			}
			s += "<li class='pbutton' id=''last>" + "下一页</li>"
					+ "<li class='opt'><select>";
			for (var i = 0; i < data['pages']; i++) {
				s += "<option value='" + i + "'>第" + (i + 1) + "页</option>";
			}
			s += "</select></li><li "
					+ "class='pbutton'><a href='#'>尾页</a></li></ul></div>";
			$("#showpages").append(s);
		}
	});
}

function addcomplaint() {
	var title = $("#title_ts").val();
	alert("title" + title);
	var jianyi = $(".textarea").val();
	var realname = $("#realname").val();
	var gender = $("#sex").val();
	var address = $("#address").val();
	var code = $("#code").val();
	if (title == null || title == "" || jianyi == null || jianyi == ""
			|| realname == null || realname == "" || gender == null
			|| gender == "" || address == null || address == "" || code == null
			|| code == "") {
		alert("信息禁止为空！");
		return false;
	}
	$.ajax({
		type : "post",
		url : "addtousu.do",
		data : {
			"title" : title,
			"content" : jianyi,
			"realname" : realname,
			"gender" : gender,
			"address" : address,
			"code" : code
		},
		dataType : "json",
		success : function(i) {
			if (i == -1) {
				alert("反馈内容有误");
			} else {
				alert("感谢你的反馈，我们会尽快处理");
				$("#tousu").hide();
				$("#job").hide();
				$("#pagecontent").show();
			}
		}
	});

}