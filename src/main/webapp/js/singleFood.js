// JavaScript Document
$(function() {
	$(".dd2 a").addClass("dd");
	$(".mm_03").css({display:"none"});
	loadTenFood("单点餐品", 0, 10, 1, ".ds");
	loadTwntyFood("单点餐品", 10, 20, 1, ".ds1");
	loadThirtyFood("单点餐品", 20, 49, 1, ".ds2");
	loadFivetyFood("单点餐品", 50, 200, 1, ".ds3");
	loadFirstShopCar();
	$(".optionalFoodType").on("click", function() {
		var foodType = $(this).text();
		$(".optionalFoodType").removeClass("dd");
		$(this).addClass("dd");
		if( foodType != "单点餐品" ){
			$(".dc_mid").css({display:"none"});
			$(".smm_01").css({display:"none"});
			$(".smm_02").css({display:"block"});
			loadOtherTypeFood(foodType,1);
		}else{
			$(".dc_mid").css({display:"block"});
			$(".smm_01").css({display:"block"});
			$(".smm_02").css({display:"none"});
		}
		
	});
	var strr = "";
	$(".subAllShopCar").on("click",function(){
		$(".shopCarTable tr").not(".shopCarTableFoot").not(".sumFoodTr").each(function(){
			var id = escape($(this).children(".tdFoodName").attr("title"));
			var name = $(this).children(".tdFoodName").text();
			var price = $(this).children(".tdPrice").text();
			var count = $(this).children(".tdCount").find("input").val();
			
            strr += "id=" + id + ",name=" + escape(name) + ",price="+ price + ",count=" + count + "|";
		});
		if($(".shopCarTable").has(".sumFoodTr").length){
			$(".sumFoodTr").each(function(){
				var taocanName = escape("组合套餐");
				var name = escape($(this).children(".tdFoodName").text());
				var price = $(this).children(".tdPrice").text();
				var count = 1;
				var test = "id=" + taocanName + ",name=" + name + ",price="+ price + ",count=" + count + "|";
				strr += test;
			});
		}
		
		$.cookie({ 
			expires: 1 
			}
		);
		document.cookie = "";
		document.cookie = strr;
		document.location.href="OrederList.html";
	});
	$(".cancelAllShopCar").on("click",function(){
		$(".shopCarTable tr").not(".shopCarTableFoot").remove();
		$(".tdOther a").text(0);
		$(".tdSC a").text(0);
	});
});

function loadTenFood(type, min, max, page, name) {
	$(name).empty();
	
			$.ajax({
				async:false,
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
								+ "<p class='foodName1"+list[i].id+"'>菜名:"
								+ list[i].foodName
								+ "</p>"
								+ "<p class='foodPrice1"+list[i].id+"'>单价:"
								+ list[i].price + "元/份"
								+ "</p>"
								+ "<p>积分:" 
								+ list[i].point + "分/份"
								+ "</p>"
								+ "<p>主料:"
								+ list[i].ingredients
								+ "</p>"
								+ "<p>口味:"
								+ list[i].flavor
								+ "</p>"
								+ "<p class='foodCount1"+list[i].id+"'>可定份数:"
								+ list[i].count
								+ "</p>"
								+ "<p>份数:"
								+ "<select class='select1"+list[i].id+"'>"
								+ "<option>1</option>"
								+ "<option>2</option>"
								+ "<option>3</option>"
								+ "<option>4</option>"
								+ "<option>5</option>"
								+ "<option>6</option>"
								+ "</select>"
								+ "</p>"
								+ "<a class='shopping' id='"+list[i].id+"'>" +
										"<img class='shopImg' src='img/gw.gif' /></a>"
								+ "</div>" + "</li>";
					}
					str += "<a class='changePage' title='上一页'>"
							+ "<img class='LR_icon' src='icon/left_icon.jpg' /></a>"
							+ "<a class='changePage' title='下一页'>"
							+ "<img class='LR_icon' src='icon/right_icon.jpg' /></a>";

					$(name).html(str);
					$(".changePage").on("mouseover",function(){

					});
					$(".changePage").click(function() {
						if ($(this).attr("title") == "下一页") {
							var nextPage = page + 1;
							if (nextPage > data.pages) {
								page = data.pages;
								return "";
							} else {
								loadTenFood(type, min, max, nextPage, name);
							}
						} else {
							var upPage = page - 1;

							if (page <= 1) {
								page = 1;
							} else {
								loadTenFood(type, min, max, upPage, name);
							}
						}
					});
					$(".shopping").on("click",function(){
						var id = $(this).attr("id");
						var selectCount = Number($(".select1"+id+"").val());
						var foodName = $(".foodName1"+id+"").text();
						var foodPrice = $(".foodPrice1"+id+"").text();
						var foodCount = $(".foodCount1"+id+"").text();
						
						var count = foodCount.split(":");
						var count1 = Number(count[1]);
						var s = foodName.split(":");
						var foodName = s[1];
						var x = 1;
						
						if(selectCount > count1 ){
							alert("超出可选数量，请重新选择");
						}else{
							loadShopCar(foodName,id,foodPrice,selectCount,"单点餐品");
						}
					});
				}

			});
}
function loadTwntyFood(type, min, max, page, name) {
	$(name).empty();
	
			$.ajax({
				async:false,
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
						+ "<p class='foodName2"+list[i].id+"'>菜名:"
						+ list[i].foodName
						+ "</p>"
						+ "<p class='foodPrice2"+list[i].id+"'>单价:"
						+ list[i].price + "元/份"
						+ "</p>"
						+ "<p>积分:" 
						+ list[i].point + "分/份"
						+ "</p>"
						+ "<p>主料:"
						+ list[i].ingredients
						+ "</p>"
						+ "<p>口味:"
						+ list[i].flavor
						+ "</p>"
						+ "<p class='foodCount2"+list[i].id+"'>可定份数:"
						+ list[i].count
						+ "</p>"
						+ "<p>份数:"
						+ "<select class='select2"+list[i].id+"'>"
						+ "<option>1</option>"
						+ "<option>2</option>"
						+ "<option>3</option>"
						+ "<option>4</option>"
						+ "<option>5</option>"
						+ "<option>6</option>"
						+ "</select>"
						+ "</p>"
						+ "<a class='shopping' id='"+list[i].id+"'>" +
								"<img class='shopImg' src='img/gw.gif' /></a>"
						+ "</div>" + "</li>";
					}
					str += "<p class='LR_p'><a class='changePage1' title='上一页'>"
							+ "<img class='LR_icon' src='icon/left_icon.jpg' /></a>"
							+ "<a class='changePage1' title='下一页'>"
							+ "<img class='LR_icon' src='icon/right_icon.jpg' /></a></p>";

					$(name).html(str);
					$(".changePage1").click(function() {
						if ($(this).attr("title") == "下一页") {
							var nextPage = page + 1;
							if (nextPage > data.pages) {
								page = data.pages;
								return "";
							} else {
								loadTenFood(type, min, max, nextPage, name);
							}
						} else {
							var upPage = page - 1;

							if (page <= 1) {
								page = 1;
							} else {
								loadTenFood(type, min, max, upPage, name);
							}
						}
					});
					$(".shopping").on("click",function(){
						var id = $(this).attr("id");
						var selectCount = Number($(".select2"+id+"").val());
						var foodName = $(".foodName2"+id+"").text();
						var foodPrice = $(".foodPrice2"+id+"").text();
						var foodCount = $(".foodCount2"+id+"").text();
						
						var count = foodCount.split(":");
						var count1 = Number(count[1]);
						var s = foodName.split(":");
						var foodName = s[1];
						var x = 2;
						
						if(selectCount > count1 ){
							alert("超出可选数量，请重新选择");
						}else{
							loadShopCar(foodName,id,foodPrice,selectCount,"单点餐品");
						}
					});
				}

			});
}
function loadThirtyFood(type, min, max, page, name) {
	$(name).empty();
	
			$.ajax({
				async:false,
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
						+ "<p class='foodName3"+list[i].id+"'>菜名:"
						+ list[i].foodName
						+ "</p>"
						+ "<p class='foodPrice3"+list[i].id+"'>单价:"
						+ list[i].price + "元/份"
						+ "</p>"
						+ "<p>积分:" 
						+ list[i].point + "分/份"
						+ "</p>"
						+ "<p>主料:"
						+ list[i].ingredients
						+ "</p>"
						+ "<p>口味:"
						+ list[i].flavor
						+ "</p>"
						+ "<p class='foodCount3"+list[i].id+"'>可定份数:"
						+ list[i].count
						+ "</p>"
						+ "<p>份数:"
						+ "<select class='select3"+list[i].id+"'>"
						+ "<option>1</option>"
						+ "<option>2</option>"
						+ "<option>3</option>"
						+ "<option>4</option>"
						+ "<option>5</option>"
						+ "<option>6</option>"
						+ "</select>"
						+ "</p>"
						+ "<a class='shopping' id='"+list[i].id+"'>" +
								"<img class='shopImg' src='img/gw.gif' /></a>"
						+ "</div>" + "</li>";
					}
					str += "<p class='LR_p'><a class='changePage2' title='上一页'>"
							+ "<img class='LR_icon' src='icon/left_icon.jpg' /></a>"
							+ "<a class='changePage2' title='下一页'>"
							+ "<img class='LR_icon' src='icon/right_icon.jpg' /></a></p>";

					$(name).html(str);
					$(".changePage2").click(function() {
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

							if (page <= 1) {
								page = 1;
							} else {

								loadTenFood(type, min, max, upPage, name);
							}
						}
					});
					$(".shopping").on("click",function(){
						var id = $(this).attr("id");
						var selectCount = $(".select3"+id+"").val();
						var foodName = $(".foodName3"+id+"").text();
						var foodPrice = $(".foodPrice3"+id+"").text();
						var foodCount = $(".foodCount3"+id+"").text();
						
						var count = foodCount.split(":");
						var count1 = Number(count[1]);
						var s = foodName.split(":");
						var foodName = s[1];
						var x = 3;
						
						if(selectCount > count1 ){
							alert("超出可选数量，请重新选择");
						}else{
							loadShopCar(foodName,id,foodPrice,selectCount,"单点餐品");
						}
					});
				}

			});
}
function loadFivetyFood(type, min, max, page, name) {
	$(name).empty();
	
			$.ajax({
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
						+ "<p class='foodName4"+list[i].id+"'>菜名:"
						+ list[i].foodName
						+ "</p>"
						+ "<p class='foodPrice4"+list[i].id+"'>单价:"
						+ list[i].price + "元/份"
						+ "</p>"
						+ "<p>积分:" 
						+ list[i].point + "分/份"
						+ "</p>"
						+ "<p>主料:"
						+ list[i].ingredients
						+ "</p>"
						+ "<p>口味:"
						+ list[i].flavor
						+ "</p>"
						+ "<p class='foodCount4"+list[i].id+"'>可定份数:"
						+ list[i].count
						+ "</p>"
						+ "<p>份数:"
						+ "<select class='select4"+list[i].id+"'>"
						+ "<option>1</option>"
						+ "<option>2</option>"
						+ "<option>3</option>"
						+ "<option>4</option>"
						+ "<option>5</option>"
						+ "<option>6</option>"
						+ "</select>"
						+ "</p>"
						+ "<a class='shopping' id='"+list[i].id+"'>" +
								"<img class='shopImg' src='img/gw.gif' /></a>"
						+ "</div>" + "</li>";
					}
					str += "<p class='LR_p'><a class='changePage3' title='上一页'>"
							+ "<img class='LR_icon' src='icon/left_icon.jpg' /></a>"
							+ "<a class='changePage3' title='下一页'>"
							+ "<img class='LR_icon' src='icon/right_icon.jpg' /></a></p>";

					$(name).html(str);
					$(".changePage3").click(function() {
						if ($(this).attr("title") == "下一页") {
							var nextPage = page + 1;
							if (nextPage > data.pages) {
								page = data.pages;
								return "";
							} else {
								loadTenFood(type, min, max, nextPage, name);
							}
						} else {
							var upPage = page - 1;

							if (page <= 1) {
								page = 1;
							} else {

								loadTenFood(type, min, max, upPage, name);
							}
						}
					});
					$(".shopping").on("click",function(){
						var id = $(this).attr("id");
						var selectCount = $(".select4"+id+"").val();
						var foodName = $(".foodName4"+id+"").text();
						var foodPrice = $(".foodPrice4"+id+"").text();
						var foodCount = $(".foodCount4"+id+"").text();
						
						var count = foodCount.split(":");
						var count1 = Number(count[1]);
						var s = foodName.split(":");
						var foodName = s[1];
						var x = 4;
						
						if(selectCount > count1 ){
							alert("超出可选数量，请重新选择");
						}else{
							loadShopCar(foodName,id,foodPrice,selectCount,"单点餐品");
						}
					});
				}

			});
}
function loadOtherTypeFood(type,page){
	$.ajax({
		type : "post",
		url : "other.do",
		data : {
			"type" : type,
			"page" : page
		},
		dataType : "json",
		success : function(data) {
			var str = "";
			var list = data;
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
				+ "<p class='foodName5"+list[i].id+"'>菜名:"
				+ list[i].foodName
				+ "</p>"
				+ "<p class='foodPrice5"+list[i].id+"'>单价:"
				+ list[i].price + "元/份"
				+ "</p>"
				+ "<p>积分:" 
				+ list[i].point + "分/份"
				+ "</p>"
				+ "<p>主料:"
				+ list[i].ingredients
				+ "</p>"
				+ "<p>口味:"
				+ list[i].flavor
				+ "</p>"
				+ "<p class='foodCount5"+list[i].id+"'>可定份数:"
				+ list[i].count
				+ "</p>"
				+ "<p>份数:"
				+ "<select class='select5"+list[i].id+"'>"
				+ "<option>1</option>"
				+ "<option>2</option>"
				+ "<option>3</option>"
				+ "<option>4</option>"
				+ "<option>5</option>"
				+ "<option>6</option>"
				+ "</select>"
				+ "</p>"
				+ "<a class='shopping' id='"+list[i].id+"'>" +
						"<img class='shopImg' src='img/gw.gif' /></a>"
				+ "</div>" + "</li>";
			}
			/*str += "<a class='changePage' title='上一页'>"
					+ "<img class='LR_icon' src='icon/left_icon.jpg' /></a>"
					+ "<a class='changePage' title='下一页'>"
					+ "<img class='LR_icon' src='icon/right_icon.jpg' /></a>";*/

			$(".smm_02").html(str);
			$(".changePage").click(function() {
				if ($(this).attr("title") == "下一页") {
					var nextPage = page + 1;
					if (nextPage > data.pages) {
						page = data.pages;
						return "";
					} else {
						loadTenFood(type, min, max, nextPage, name);
					}
				} else {
					var upPage = page - 1;

					if (page <= 1) {
						page = 1;
					} else {
						loadTenFood(type, min, max, upPage, name);
					}
				}
			});
			$(".shopping").on("click",function(){
				var id = $(this).attr("id");
				var selectCount = $(".select5"+id+"").val();
				var foodName = $(".foodName5"+id+"").text();
				var foodPrice = $(".foodPrice5"+id+"").text();
				var foodCount = $(".foodCount5"+id+"").text();
				
				var count = foodCount.split(":");
				var count1 = Number(count[1]);
				var s = foodName.split(":");
				var foodName = s[1];
				var x = 5;
				
				if(selectCount > count1 ){
					alert("超出可选数量，请重新选择");
				}else{
					loadShopCar(foodName,id,foodPrice,selectCount,type);
				}
			});
		}

	});
}
function loadShopCar(foodName,foodId,foodPrice,foodCount,type){
	var s1 = foodPrice.split(":");
	var s2 = s1[1].split("元/份");
	
	foodPrice = s2[0];
	var b = false;
	$.ajax({
		type : "post",
		url : "findCount.do",
		data : {"id" : foodId},
		dataType : "json",
		success : function(data){
			var findCount = data;
			//遍历这个表格是否含有当前要添加的菜品，有则增加count，并且判断count是否超出库存
			$(".shopCarTable tr").not(".shopCarTableFoot").each(function(){
				var str = $(this).children(".tdFoodName").text();
				if(str == foodName){
					var cc = $(this).children(".tdCount").find("input").val();//获取购物车中当前菜的数量
					cc = Number(cc) + Number(foodCount);

					if( cc > Number(findCount)){
						alert("超出可选数量，请重新选择");
						b = true;
					}else{
						$(this).children(".tdCount").find("input").val(cc);
						addAllCountMoney();
						b = true;
					}
				}
			});
			
			if(b == false){
				
				var str = "<tr class='btn"+foodId+"'>" +
				"<td class='tdFoodName' title='"+type+"'><span>"+foodName+"</span></td>" +
				"<td class='tdPrice'>"+foodPrice+"</td>" +
				"<td class='tdCount'><input type='number' min='0' max='"+findCount+"' onblur='addAllCountMoney()' class='tdCount1"+foodId+"' value='"+foodCount+"'/></td>" +
				"<td class='tdCancel'><img src='icon/quxiao.jpg' class='btn"+foodId+"' />" +
				"</td></tr>";
				$(".shopCar table").prepend(str);
			}
			addAllCountMoney();
			$(".tdCancel img").on("click",function(){
				var ss = $(this).attr("class");
				ss2 = ss.split("btn");
				$("."+ss+"").remove();
				addAllCountMoney();
			});
		}
	});
	//这里是ajax结束
}

function addAllCountMoney(){
	var money = 0;
	var count2 = 0;
	//通过子代选择器遍历这个表格的每一列，求和，
	$(".shopCarTable tr").not(".shopCarTableFoot").each(function(){
		if(Number($(this).children(".tdCount").find("input").val()) > Number($(this).children(".tdCount").find("input").attr("max"))){
			$(this).children(".tdCount").find("input").val(Number($(this).children(".tdCount").find("input").attr("max")));
		}
		if($(this).children(".tdCount").find("input").val() < 0){
			$(this).children(".tdCount").find("input").val(0);
		}
		money += Number($(this).children(".tdPrice").text() * $(this).children(".tdCount").find("input").val());
		count2 += Number($(this).children(".tdCount").find("input").val());
	});
	$(".tdOther a").html(money);
	$(".tdSC a").html(count2);
}

function loadFirstShopCar(){
	var str = document.cookie;
	var s = str.split("|");
	var id = "";
	var name = "";
	var price = "";
	var count = "";
	if(str != null || str != ""){
		for (var i = 0; i < s.length-1; i++) {
			var ss = s[i].split(",");
			for (var j = 0; j < ss.length; j++) {
				var sss = ss[j].split("=");
				if (sss[0] == "id") {
					id = sss[1];
				}
				if (sss[0] == "name") {
					name = sss[1];
				}
				if (sss[0] == "price") {
					price = sss[1];
				}
				if (sss[0] =="count") {
					count = sss[1];
				}
			}
			price = "单价:" + price + "元/份";
			loadShopCar(unescape(name),1,price,count,unescape(id));
		}
	}else{
		return "";
	}
}