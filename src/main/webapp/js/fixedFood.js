$(function(){
	loadSumFoodNum();
	$(".foodPackage").on("click",function(){
		if($(this).text() == "固定套餐"){
			$(".mm_01").css({display:"none"});
			$(".mm_02").css({display:"block"});
			$(".mm_03").css({display:"none"});
			var str = "<div class='dccat'>" +
					"<a class='fixedFoodType'>经济套餐</a>&nbsp;|&nbsp;" +
					"<a class='fixedFoodType'>商务套餐</a>&nbsp;|&nbsp;" +
					"<a class='fixedFoodType'>精品盖饭</a>" +
					"</div><br><br><br>" +
					"<div class='fuck'></div>";
			loadfoodPackage("经济套餐");
			$(".mm_02").html(str);
			$(".fixedFoodType").on("click",function(){
				$(".fixedFoodType").removeClass("dd3");
				$(this).addClass("dd3");	
				var packageName = $(this).text();
				var x = 6;
				if(packageName == "经济套餐" ){
					x = 6;
				}
				if(packageName == "商务套餐" ){
					x = 7;
				}
				if(packageName == "精品盖饭" ){
					x = 8;
				}
				loadfoodPackage(packageName,x);
			});
		}else if($(this).text() == "自选套餐"){
			$(".mm_02").css({display:"none"});
			$(".mm_01").css({display:"block"});
			$(".mm_03").css({display:"none"});
		}else if($(this).text() == "组合套餐"){
			$(".mm_02").css({display:"none"});
			$(".mm_01").css({display:"none"});
			$(".mm_03").css({display:"block"});
			loadSumFood("荤菜",".ds5","huncai_",1);
			loadSumFood("素菜",".ds6","sucai_",2);
			loadSumFood("汤",".ds7","tang_",3);
		}
	});
	$(".sumFoodSelect").on("change",function(){
		loadSumFoodNum();
	});
	$(".sumfoodShop").on("click",function(){
		var str = loadCheckBox();
		var str1 = loadCheckBox1();
		var str2 = loadCheckBox2();
		var a = false;
		var b = false;
		var c = false;
		if(str.indexOf("您") != -1 ){
			alert(str);
			return "";
		}else{a = true;}
		if(str1.indexOf("您") != -1 ){
			alert(str1);
			return "";
		}else{b = true;}
		if(str2.indexOf("您") != -1 ){
			alert(str2);
			return "";
		}else{c = true;}
		if(b == true && a == true && c == true){
			var sss = str + str1 + str2;
			var val = $(".sumFoodSelect").val();
			var foodName = val+"元组合套餐" + "("+sss+")";
			loadShopCar2(foodName,val);
		}
	});
});


function loadfoodPackage(type,x){
	$.ajax({
		type : "post",
		url : "fixed.do",
		data : {
			"type2" : type
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
						+ "<p class='foodName"+x+list[i].id+"'>菜名:"
						+ list[i].foodName
						+ "</p>"
						+ "<p class='foodPrice"+x+list[i].id+"'>单价:"
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
						+ "<p class='foodCount"+x+list[i].id+"'>可定份数:"
						+ list[i].count
						+ "</p>"
						+ "<p>份数:"
						+ "<select class='select"+x+list[i].id+"'>"
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
			$(".fuck").html(str);
			$(".shopping").on("click",function(){
				var id = $(this).attr("id");
				var selectCount = $(".select"+x+id+"").val();
				var foodName = $(".foodName"+x+id+"").text();
				var foodPrice = $(".foodPrice"+x+id+"").text();
				var foodCount = $(".foodCount"+x+id+"").text();
				
				var count = foodCount.split(":");
				var count1 = Number(count[1]);
				var s = foodName.split(":");
				var foodName = s[1];
				
				if(selectCount > count1 ){
					alert("超出可选数量，请重新选择");
				}else{
					loadFixedFoodShopCar(foodName,id,foodPrice,selectCount,type);
				}
			});
		}
	});
}

function loadCheckBox(){
	var sum = 0;
	var val1 = 0;
	var str = "";
	var val = $(".sumFoodSelect").val();
	if(val == 8){
		val1 = 1;
	}else if( val == 10){
		val1 = 1;
	}else{
		val1 = 2;
	}
	$(".ds5 input").each(function(){
		if($(this).is(":checked")){
			/* 如果需要菜的id,从这里取 id为id[1]
			 * var idName = $(this).attr("class");
			var id = idName.split("_");*/
			str += $(this).next().text() + ",";
			sum += Number($(this).val());
			if(sum > val1){
				alert("该套餐只能选择"+val1+"个");
				$(this).attr("checked",false);
			}
		}
	});
	if(sum < val1){
		var cao = Number(val1 - sum);
		return "您还可以再选择"+cao+"个荤菜";
	}
	return str;
}
function loadCheckBox1(){
	var sum = 0;
	var val2 = 0;
	var str = "";
	var val = $(".sumFoodSelect").val();
	if(val == 8){
		val2 = 4;
	}else if( val == 10){
		val2 = 6;
	}else{
		val2 = 4;
	}
	$(".ds6 input").each(function(){
		if($(this).is(":checked")){
			/*var idName = $(this).attr("class");
			var id = idName.split("_");*/
			str += $(this).next().text() + ",";
			sum += Number($(this).val());
			if(sum > val2){
				alert("该套餐只能选择"+val2/2+"个");
				$(this).attr("checked",false);
			}
		}
	});
	if(sum < val2){
		var cao = Number((val2 - sum)/2);
		return "您还可以再选择" + cao + "个素菜";
	}
	return str;
}
function loadCheckBox2(){
	var sum = 0;
	var str = "";
	$(".ds7 input").each(function(){
		if($(this).is(":checked")){
			/*var idName = $(this).attr("class");
			var id = idName.split("_");*/
			str += $(this).next().text();
			sum += Number($(this).val());
			if(sum > 3){
				alert("该套餐只能选择1个");
				$(this).attr("checked",false);
			}
		}
	});
	if(sum == 0){
		return "您还可以再选择一个汤";
	}
	return str;
}
function loadSumFood(type,name,idName,val){
	$.ajax({
		type : "post",
		url : "sum.do",
		data : { "type2" : type},
		dataType : "json",
		success : function(data){
			var str = "";
			for(var i=0;i<data.length;i++){
				str += "<div class='sumfood'>" +
						"<input type='checkbox' class='"+idName+data[i].id+"' value='"+val+"' />"
						+"&nbsp;<span>"+data[i].foodName+"</span></div>";
			}
			$(name).html(str);
			$(".ds5").on("change",function(){
				loadCheckBox();
			});
			$(".ds6").on("change",function(){
				loadCheckBox1();
			});
			$(".ds7").on("change",function(){
				loadCheckBox2();
			});
		}
	});
}
function loadSumFoodNum(){
	var val = $(".sumFoodSelect").val();
	if(val == 8){
		$(".taoCPrice").text(8);		
		$(".taoCPoints").text(8);		
		$(".huncaiNum").text(1);		
		$(".sucaiNum").text(2);		
	}
	if(val == 10){
		$(".taoCPrice").text(10);		
		$(".taoCPoints").text(10);		
		$(".huncaiNum").text(1);		
		$(".sucaiNum").text(3);		
	}
	if(val == 12){
		$(".taoCPrice").text(12);		
		$(".taoCPoints").text(12);		
		$(".huncaiNum").text(2);		
		$(".sucaiNum").text(2);		
	}
}
function loadShopCar2(foodName,foodPrice){
	var str = "<tr class='sumFoodTr'>" +
	"<td class='tdFoodName'><span>"+foodName+"</span></td>" +
	"<td class='tdPrice'>"+foodPrice+"</td>" +
	"<td class='tdCount'><input value='"+1+"'/></td>" +
	"<td class='tdCancel'>" +
	"</td></tr>";
	$(".shopCar table").prepend(str);
	addAllCountMoney();
}
function loadFixedFoodShopCar(foodName,foodId,foodPrice,foodCount,type){
	var s1 = foodPrice.split(":");
	var s2 = s1[1].split("元/份");
	
	foodPrice = s2[0];
	var b = false;
	$.ajax({
		type : "post",
		url : "fixCount.do",
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
				"<td class='tdCancel'><input class='btn"+foodId+"' type='button' />" +
				"</td></tr>";
				$(".shopCar table").prepend(str);
			}
			addAllCountMoney();
			$(".tdCancel input").on("click",function(){
				var ss = $(this).attr("class");
				ss2 = ss.split("btn");
				$("."+ss+"").remove();
				addAllCountMoney();
			});
		}
	});
	//这里是ajax结束
}