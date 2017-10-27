$(function() {
	loadCookie();
	loadSumAdd();
	//$("#quedingdc").click();
});

function loadCookie() {
	var str = document.cookie;
	var s = str.split("|");
	var id = "";
	var name = "";
	var price = "";
	var count = "";
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
		var ssss = "<tr><td></td>" + 
			"<td>"+unescape(id)+"</td>" 
		  + "<td>"+unescape(name)+"</td>" 
		  + "<td class='tdPrice'>"+price+"</td>" 
		  + "<td class='tdCount'>"+count+"</td>" 
		  + "<td></td>" 
		  + "<td>"+price+"分</td>" 
		  + "<td></td>" 
		  + "<td><input class='cancelSum' type='button' value='取消' /></td>" 
		  + "</tr>";
		$(".startorder").append(ssss);
	}
	$(".cancelSum").on("click",function(){
		$(this).parents("tr").remove();
		loadSumAdd();
	});
}
function loadSession(){
	var str = document.cookie;
	var s = str.split(";");
	for(var i=0;i<s.length-1;i++){
		var foodName = s[i].split("=");
		var val = unescape(foodName[1]).split("元");
		var ssss = "<tr><td></td>" + 
		"<td>"+"组合套餐"+"</td>" 
			  + "<td>"+unescape(foodName[1])+"</td>" 
			  + "<td>"+val[0]+"</td>" 
			  + "<td>"+1+"</td>" 
			  + "<td></td>" 
			  + "<td>"+val[0]+"分</td>" 
			  + "<td></td>" 
			  + "<td><input class='cancelSum' type='button' value='取消' /></td>" 
			  + "</tr>";
			$(".startorder").append(ssss);
	}
}

function loadSumAdd(){
	var sum = 0;
	var counts = 0;
	$(".startorder tr").not(".baoliu").each(function(){
		var price = Number($(this).children(".tdPrice").text());
		var count = Number($(this).children(".tdCount").text());
		sum += price * count;
		counts += count;
	});
	$("#allnums").text(sum);
	$("#span_tjine").text(counts);
}