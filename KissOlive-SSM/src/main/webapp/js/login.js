function student_login() {
    var number = $("#student_number").val();
    var pwd = $("#student_password").val();
    if(number == "" || pwd == "") {
        alert("账号或者密码不能为空！！！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/login_student.do",
        data: {
            student_number: number,
            student_password: pwd
        },
        dataType: 'json',
        success: function(result) {
            if(result.status == 0) { //成功
                //alert(data.msg);
                $.cookie("sno",result.data.sno,{ expires: 7, path: '/' });
                $.cookie("sname",result.data.sname,{ expires: 7, path: '/' });
                $.cookie("ssex",result.data.ssex,{ expires: 7, path: '/' });
                $.cookie("sbirth",result.data.sbirth,{ expires: 7, path: '/' });
                $.cookie("sdno",result.data.sdno,{ expires: 7, path: '/' });
                $.cookie("dname",result.data.dname,{ expires: 7, path: '/' });
                window.location.href = "http://127.0.0.1:8080/student/student_main.html";
            } else {
                alert(result.msg);
            }
        },
        error: function() {
            alert("登录异常");
        }
    })
}

function teacher_login() {
    var number = $("#teacher_number").val();
    var pwd = $("#teacher_password").val();
    if(number == "" || pwd == "") {
        alert("账号或者密码不能为空！！！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/login_teacher.do",
        data: {
            teacher_number: number,
            teacher_password: pwd
        },
        dataType: 'json',
        success: function(result) {
            if(result.status == 0) { //成功
                $.cookie("tno",result.data.tno,{ expires: 7, path: '/' });
                $.cookie("tname",result.data.tname,{ expires: 7, path: '/' });
                $.cookie("tsex",result.data.tsex,{ expires: 7, path: '/' });
                $.cookie("tbirth",result.data.tbirth,{ expires: 7, path: '/' });
                $.cookie("teducation",result.data.teducation,{ expires: 7, path: '/' });
                $.cookie("tposition",result.data.tposition,{ expires: 7, path: '/' });
                $.cookie("tintroduction",result.data.tintroduction,{ expires: 7, path: '/' });
                window.location.href = "http://127.0.0.1:8080/teacher/teacher_main.html";
            } else {
                alert(result.msg);
            }
        },
        error: function() {
            alert("登录异常");
        }
    })
}