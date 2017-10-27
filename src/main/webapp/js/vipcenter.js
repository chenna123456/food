var oldPwd;

$(function() {

	var flag = true;

	$("#sub").click(function() {

		var pwd1 = $("#pwd1Mjz").val();
		var pwd2 = $("#pwd2Mjz").val();

		if ((pwd2 == pwd1) && (pwd1 != "") && flag) {
			$("#guestbookform").submit();
		}
	});

	$.ajax({
		type : "post",
		url : "updataVipInfo.do",
		data : {},
		dataType : "json",
		success : function(data) {
			var vipInfo = data.vipInfo;

			var orderInfoByVipId = data.orderInfoByVipId;

			$("#VipID").val(vipInfo.id);

			$("#vipname").val(vipInfo.userName);

			$("#phoneMjz").val(vipInfo.phone);

			oldPwd = vipInfo.pwd;

			var diraddress = vipInfo.address.split(",");

			var address = diraddress[diraddress.length - 1];

			$("#addressMjz").val(address);

			for (var i = 0; i < orderInfoByVipId.length; i++) {
				$(".orderHistoryMjz").append(
						"<tr><td>" + orderInfoByVipId[i].orderNo + "</td><td>"
								+ orderInfoByVipId[i].publishTime + "</td><td>"
								+ orderInfoByVipId[i].paymentTime
								+ "</td><td>"+orderInfoByVipId[i].totalPrice+"</td>" +
								"<td><a href='ordersearch.do?os_orderno="
								+orderInfoByVipId[i].orderNo
								+"&os_phone="+vipInfo.phone+
								"'>查看详细</a></td></tr>");
			}
			
			

		}

	});

	$("#oldPwd1Mjz").blur(function() {
		var oldPwd1Mjz = $("#oldPwd1Mjz").val();

		if (oldPwd1Mjz != oldPwd) {
			$("#errorOldpwd").text("与原密码不符");
			flaog = false;
		} else {
			flaog = true;
			$("#errorOldpwd").text("");
		}

	});

	$("#phoneMjz").blur(function() {
		var phone = $("#phoneMjz").val();
		var phoneNum = /^1[3|4|5|7|8][0-9]{9}$/;
		var flag = phoneNum.test(phone);

		if (!flag || phone == "") {
			$("#error2").text("请按标准规则输入手机号码");
			flag = false;
		} else {
			$("#error2").text("");
			flag = true;
		}

	});

	$("#addressMjz").blur(function() {
		var maddress = $("#addressMjz").val();
		if (maddress == "") {
			$("#erroraddress").text("地址不能为空");
			flag = false;
		} else {
			$("#erroraddress").text("");
			flag = true;
		}

	});

	$("#pwd1Mjz").blur(function() {
		var pwd1 = $("#pwd1Mjz").val();
		var pwd2 = $("#pwd2Mjz").val();
		if (pwd1 == "") {
			$("#errorpwd1").text("密码不能为空");
		} else if (pwd1.length < 4) {
			$("#errorpwd1").text("密码太短");
		} else {
			$("#errorpwd1").text("");
		}
	});

	$("#pwd2Mjz").blur(function() {
		var pwd1 = $("#pwd1Mjz").val();
		var pwd2 = $("#pwd2Mjz").val();
		if (pwd1 != pwd2) {
			$("#errorpwd2").text("两次密码不同");
		} else if (pwd1 == pwd2) {
			$("#errorpwd2").text("");
		}
	});

});