$(function() {

	var floag = true;

	$("#zhuce").click(function() {

		var pwd1 = $("#mpwd1").val();
		var pwd2 = $("#mpwd2").val();

		if ((pwd2 == pwd1) && (pwd1 != "") && floag) {
			$("#memberLogin").submit();
		}
	});

	$("#mpwd1").blur(function() {
		var pwd1 = $("#mpwd1").val();
		var pwd2 = $("#mpwd2").val();
		if (pwd1 == "") {
			$("#error").text("密码不能为空");
		} else if (pwd1.length < 4) {
			$("#error").text("密码太短");
		} else {
			$("#error").text("");
		}
	});

	$("#mpwd2").blur(function() {
		var pwd1 = $("#mpwd1").val();
		var pwd2 = $("#mpwd2").val();
		if (pwd1 != pwd2) {
			$("#error").text("两次密码不同");
		} else if (pwd1 == pwd2) {
			$("#error").text("");
		}
	});

	$("#mphone").blur(function() {
		var phone = $("#mphone").val();
		var phoneNum = /^1[3|4|5|7|8][0-9]{9}$/;
		var flag = phoneNum.test(phone);

		$.ajax({
			type : "post",
			url : "checkReg.do",
			data : {
				"phone" : phone
			},
			dataType : "json",
			success : function(data) {
				if (data) {
					$("#error2").text("该手机号码已被使用");
					floag = false;
				} else if (!flag || phone == "") {
					$("#error2").text("请按标准规则输入手机号码");
					floag = false;
				} else {
					$("#error2").text("");
					floag = true;
				}
			}

		});

	});

	$("#muser").blur(function() {
		var userName = $("#muser").val();
		if (userName == "") {
			$("#error3").text("用户名不能为空");
			floag = false;
		} else {
			$("#error3").text("");
			floag = true;
		}

	});
	
	$("#maddress").blur(function() {
		var maddress = $("#maddress").val();
		if (maddress == "") {
			$("#error4").text("地址不能为空");
			floag = false;
		} else {
			$("#error4").text("");
			floag = true;
		}

	});

});