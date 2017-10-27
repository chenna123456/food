$(function() {
	page = 1;
	wlist();
	loaddays();
	
});

function wlist() {
	$(".everonefood").empty();
	// alert(page);
	$.ajax({
				async : false,
				type : "post",
				url : "weekfood.do",
				data : {
					"page" : page
				},
				dataType : "json",
				success : function(data) {
					//alert(page);
					var list = data.list;
					
					var str = "";
					for (var i = 0; i < list.length; i++) {
						 
						str += "<div class='ys'>" + "<div class='timeinfo'>"
								+ list[i].pulicdate+ "</div>"
								+ "<div class='plish'><img src='" + list[i].src
								+ "' class='plishimg'/>"
								+ "<div class='foodtittle'>" + list[i].foodname
								+ "</div></div></div>";

					}

					$(".everonefood").append(str);
					str1 = "<div class='cp'><input type='button' value='上一页' />"
					$(".everonefood").append(str1);
					var str2 = "";
					for (var i = 1; i <= 3; i++) {
						str2 += "<input type='button' value='" + i + "'>";
					}
					str2 += "...<input type='button' value='"
							+ data.cpage
							+ "' ><input type='button' value='下一页'  >"
							+ "<input type='number'  min='1' class='inp'/><input type='button' value='跳转' class='jump'/>"
							+ "</div>";
					$(".cp").append(str2);
					$(".cp input").not(".inp").click(function() {
						var val = this.value
						if (val == "上一页") {

							if (page <= 1) {
								alert("没有上一页了");
								page = 1;
							} else {
								page--;
							}
						} else if (val == "下一页") {

							if (page >= data.cpage) {
								alert("没有下一页了");
								page = data.cpage;
							} else {
								page++;
							}
						} else if (val == "跳转") {
							page = $(".inp").val();
							if (page > data.cpage) {
								alert("超过最大页面已为您跳转到最后一页");
								page = data.cpage;
							} else if (page < 1) {
								alert("超过最小页面已为您跳转到第一页");
								page = 1;
							}
						} else {

							page = this.value;
						}
						wlist();

					});
				}
			});
	/*
	 * $(".jump").click(function(){ page = $(".inp").val(); alert(page);
	 * if(page>data.cpage){ alert("超过最大页面已为您跳转到最后一页"); page=cpage; } wlist();
	 * });
	 */
}
function loaddays() {
	$.ajax({
		type : "post",
		url : "loaddays.do",
		data : {},
		dataType : "json",
		success : function(data) {
			var month_days = data['month_days'];
			var year = data['year'];
			var month = data['month'];
			var day = data['day'];
			var d = day;
			var week = data['week'];
			var s = "<tr><td rowspan='6' align='center'"
					+ " valign='top'><span style='"
					+ "background: #f99d20; color: #ffffff;'>" + +day + "/"
					+ month + "</span></td>" + "<td>日&nbsp;</td>"
					+ "<td>&nbsp;一&nbsp;</td>" + "<td>&nbsp;二&nbsp;</td>"
					+ "<td>&nbsp;三&nbsp;</td>" + "<td>&nbsp;四&nbsp;</td>"
					+ "<td>&nbsp;五&nbsp;</td>" + "<td>&nbsp;六</td>"
					+ "</tr><tr>";
			// 打印空格
			for (var j = 0; j < week; j++) {
				s += "<td ></td>";
			}

			// 打印本月剩余日期
			while (day <= month_days) {
				if ((day - week + 1) % 7 == 6) {
					s += "</tr>";
				}
				if ((day - week + 1) % 7 == 6 && (day - week + 1) < 28) {
					s += "<tr>";
				}
				s += "<td class='riqi' abbr='"+day+"'><a href='javascript:void(0);'" + " class='puriqiclass'"
						+ " value='" + day + "'></a>" + (day++) + "</td>";
			}

			for (var j = 0; j < 7 - week; j++) {
				s += "<td></td>";
			}
			s += "</tr><tr>"
			for (var j = 0; j < week; j++) {
				s += "<td ></td>";
			}
			for (var i = 1; i <= 28 - (month_days - d + week);) {
				for (var j = 0; j < 7 - week; j++) {
					s += "<td class='riqi' abbr='"+i+"'><a href='javascript:void(0);'"
							+ " class='puriqiclass'" + " value='" + i
							+ "'></a>" + (i++) + "</td>";
				}
				s += "</tr><tr>"
				for (var j = 0; j < week; j++) {
					s += "<td class='riqi' abbr='"+i+"'><a href='javascript:void(0);'"
							+ " class='puriqiclass'" + " value='" + i
							+ "'></a>"+(i++)+"</td>";
				}
			}
			for (var j = 0; j < 7 - week; j++) {
				s += "<td></td>";
			}
			s += "</tr>";
			$("#riqi").empty();
			$("#riqi").append(s);
			$(".riqi").click(function(){
				var day = this.abbr;
				var month1="";
				var  day1="";
				if(month<10){
					month1="0"+month;
				}else{month1=month; }
				if(day<10){
					day1="0"+day;
				}else{day1=day;}
				var day2=year+"-"+month1+"-"+day1;
			//	alert(day2);
				$(".everonefood").empty();
				$.ajax({
				//	async : false,
					type : "post",
					url : "byday.do",
					data : {
						"day" : day2
					},
					dataType : "json",
					success : function(data) {
						
						var li = data.li;
						
						var str = "";
						
						for (var i = 0;i<li.length;i++) {
							str += "<div class='ys'>" + "<div class='timeinfo'>"
									+ li[i].pulicdate + "</div>"
									+ "<div class='plish'><img src='" + li[i].src
									+ "' class='plishimg'/>"
									+ "<div class='foodtittle'>" + li[i].foodname
									+ "</div></div></div>";

						}

						$(".everonefood").append(str);
					}
					   });
				
				
				
				
				
				
				
				
				
				
			});

		}
	});
	
}
