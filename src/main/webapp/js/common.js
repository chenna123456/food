$(function() {
	loaddays();
	
});

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
			var r=week;
			for(var j=0;j<day-7;j++){
				if(week==7){
					week=0;
					s += "<tr>";
				}
				if (day <= month_days){
					s += "<td class='riqi' abbr='"+day+"'><a href='javascript:void(0);'" + " class='puriqiclass'"
					+ " value='" + day + "'></a>" + (day++) + "</td>";
					if (day == month_days){
						j=-1;
					}
				}else{
				s+="<td class='riqi' abbr='"+j+"'><a href='javascript:void(0);'" + " class='puriqiclass'"
				+ " value='" + j + "'></a>" + j + "</td>";
				}
				if(week==6){
					s += "</tr>";
				}
				week++;
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