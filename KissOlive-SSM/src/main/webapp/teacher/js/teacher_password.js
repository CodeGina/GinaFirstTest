$("#old_password").blur(function(){
    var old_pwd = $("#old_password").val();
    $.ajax({
        type: "post",
        url: "http://localhost:8080/login_teacher.do",
        data: {
            teacher_number: $.cookie("tno"),
            teacher_password: old_pwd
        },
        dataType: 'json',
        success: function(result) {
            if(result.status == 0) { //成功
                $("#tip1").html("<font color=\"green\" size=\"2\">Accept</font>");
            } else {
                console.log("密码错误");
                $("#tip1").html("<font color=\"red\" size=\"2\">Wrong</font>");
            }
        },
        error: function() {
            alert("异常");
        }
    })
});

$("#new_password").blur(function(){
    var num=$("#new_password").val().length;
    if(num<6){
        $("#tip2").html("<font color=\"red\" size=\"2\">密码长度在6-12</font>");
    }
    else if(num>12){
        $("#tip2").html("<font color=\"red\" size=\"2\">密码长度在6-12</font>");
    }
    else{
        $("#tip2").html("<font color=\"green\" size=\"2\">Accept</font>");
    }
});

$("#confirm_password").blur(function(){
    var new_pwd=$("#new_password").val();
    if($("#confirm_password").val()!=new_pwd){
        $("#tip3").html("<font color=\"red\" size=\"2\">两次密码不一致</font>");
    }
    else{
        $("#tip3").html("<font color=\"green\" size=\"2\">Accept</font>");
    }
});

function change_pwd() {
    var flag=true;
    var new_pwd=$("#new_password").val();
    var confirm_pwd=$("#confirm_password").val();
    var num1=$("#new_password").val().length;
    var num2=$("#confirm_password").val().length;

    if(num1!=num2||num1<6||num2<6||num1>12||num2>12||confirm_pwd!=new_pwd){
        flag=false;
    }
    else{
        flag=true;
    }
    if(flag){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/changeTeacherPassword.do",
            data: {
                teacher_number: $.cookie("tno"),
                teacher_password: new_pwd
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    alert("修改密码成功！");
                    window.location.reload();
                }
            },
            error: function() {
                alert("异常");
            }
        })
    }
    else{
        alert("Please follow the tips!");
    }
}