function login() {
	var number = $("#admin_number").val();
	var pwd = $("#admin_password").val();
	if(number == "" || pwd == "") {
		alert("账号或者密码不能为空！！！");
		return false;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:8080/login_manager.do",
		data: {
            manager_number: number,
            manager_password: pwd
		},
		dataType: 'json',
		success: function(result) {
			if(result.status == 0) { //成功
			    alert(result.data.mno+"..."+result.data.mname+"..."+result.data.mpwd);
                $.cookie("mno",result.data.mno,{ expires: 7, path: '/' });
                $.cookie("mname",result.data.mname,{ expires: 7, path: '/' });
				window.location.href = "http://127.0.0.1:8080/admin/admin_main.html";
			} else {
				alert(result.msg);
			}
		},
		error: function() {
            alert("登录异常");
		}
	})
}