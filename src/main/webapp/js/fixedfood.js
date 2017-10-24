// JavaScript Document
$(function() {
	loadTenFood("单点餐品", 0, 10, 1, ".ds");
	loadTenFood("单点餐品", 10, 20, 1, ".ds1");
	loadTenFood("单点餐品", 20, 50, 1, ".ds2");
	loadTenFood("单点餐品", 50, 200, 1, ".ds3");
	$(".fixedfood").on("click", function() {
		$(".c").empty();
	});
	$(".optionalFoodType").on("click", function() {
		alert($(this).text());
	});
});

function loadTenFood(type, min, max, page, name) {
	$(name).empty();
	$
			.ajax({
				type : "post",
				url : "optionalfood.do",
				data : {
					"type" : type,
					"minPrice" : min,
					"maxPrice" : max,
					"page" : page
				},
				dataType : "json",
				success : function(data) {
					var str = "";
					var list = data.tenFood;
					for (var i = 0; i < list.length; i++) {
						str += "<li class='foodLi'>" + "<div class='tenImg'>"
								+ "<span class='pro'>"
								+ list[i].describe
								+ "</span>"
								+ "	<img src='"
								+ list[i].src
								+ "' class='tenImg' />"
								+ "</div>"
								+ "<div class='tenDescribe'>"
								+ "<p>菜名:"
								+ list[i].foodName
								+ "</p>"
								+ "<p>单价:"
								+ list[i].price
								+ "</p>"
								+ "<p>积分:"
								+ list[i].point
								+ "</p>"
								+ "<p>主料:"
								+ list[i].ingredients
								+ "</p>"
								+ "<p>口味:"
								+ list[i].flavor
								+ "</p>"
								+ "<p>可定份数:"
								+ list[i].count
								+ "</p>"
								+ "<p>份数:"
								+ "<select>"
								+ "<option>1</option>"
								+ "<option>2</option>"
								+ "<option>3</option>"
								+ "<option>4</option>"
								+ "<option>5</option>"
								+ "<option>6</option>"
								+ "</select>"
								+ "</p>"
								+ "<a href='http://www.baidu.com'><img class='shopImg' src='img/gw.gif' /></a>"
								+ "</div>" + "</li>";
					}
					str += "<p class='LR_p'><a class='changePage' title='上一页'>"
							+ "<img class='LR_icon' src='icon/left_icon.jpg' /></a>"
							+ "<a class='changePage' title='下一页'>"
							+ "<img class='LR_icon' src='icon/right_icon.jpg' /></a></p>";

					$(name).html(str);
					$(".changePage").on("click", function() {
						if ($(this).attr("title") == "下一页") {
							var nextPage = page + 1;
							if (nextPage > data.pages) {
								page = nextPage;
								return "";
							} else {
								loadTenFood(type, min, max, nextPage, name);
							}
						} else {
							var upPage = page - 1;
							/*
							 * if(page<=1){ page = 1; return ""; }else{
							 */
							loadTenFood(type, min, max, upPage, name);
							/* } */
						}
					});
				}

			});
}
