$(function() {

	var goodstotal = 0;

	$.ajax({
		type : "post",
		url : "orderdetail.do",
		data : {},
		dataType : "json",
		success : function(data) {
			// alert(data.orderInfo.orderNo)

			$("#orderNumMJZ").text("订单号:" + data.orderInfo.orderNo);

			$("#vipName").text(data.orderInfo.vipName);

			$("#vipPhone").text(data.orderInfo.phone);

			var orderTime = new Date(data.orderInfo.publishTime);

			orderTimesdf= orderTime.toLocaleString();

			$("#orderTime").text(orderTimesdf);

			$("#addressMjz").text(data.orderInfo.address);
						
			var paymentTime = new Date(data.orderInfo.paymentTime);

			paymentTimesdf= paymentTime.toLocaleString();
			
			$("#paymentTimeMjz").text(paymentTimesdf);

			for (var i = 0; i < data.orderList.length; i++) {

				var detail = data.orderList[i];

				var content = "<tr bgcolor='#FFFFFF'>"
						+ "<td height='20' align='center' bgcolor='#FFFFFF'>"
						+ detail.foodName + "</td>"
						+ "<td width='80' align='center' bgcolor='#FFFFFF'>"
						+ detail.price + "</td>"
						+ "<td width='50' align='center' bgcolor='#FFFFFF'>"
						+ detail.number + "</td>"
						+ "<td width='80' align='center' bgcolor='#FFFFFF'>"
						+ detail.subtatol + "</td>"
						+ "<td width='50' align='center' bgcolor='#FFFFFF'>"
						+ data.orderInfo.state + "</td>" + "</tr>";

				$("#orderDetailMjz").append(content);

				goodstotal = goodstotal + detail.subtatol;

			}
			
			var total=goodstotal+6;


			$("#goodsPriceMJZ").text(goodstotal);
			
			$("#orderTimeMJZ").text(orderTimesdf);
			
			$("#tatalPriceMJZ").text(total);
			
			$("#stateMJZ").text(paymentTimesdf);

		}
	});

	Date.prototype.toLocaleString = function() {
		
		
		return this.getFullYear() + "/" + (this.getMonth() + 1) + "/"
				+ this.getDate() + "/ " + this.getHours() + ":"
				+ this.getMinutes() + ":" + this.getSeconds();
		
		
	};

});