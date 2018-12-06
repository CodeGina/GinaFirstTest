function add_teacher() {
    var number = $("#add_teacher_number").val();
    var name = $("#add_teacher_name").val();
    var sexArr = document.getElementsByName("teacher_sex");
    var sex = "";
    for(var i = 0; i < sexArr.length; i++) {
        if(sexArr[i].checked){
            sex = sexArr[i].value;
        }
    }
    //console.log(sex);
    var birthday = $("#add_teacher_birthday").val();
    //console.log(birthday);
    var education = $("#add_teacher_education").val();
    var position = $("#add_teacher_position").val();
    var introduction = $("#add_teacher_introduction").val();
    if(number == "" || name == "" || sex == "" || birthday == "" || education == "" || position == "" || introduction == ""){
        alert("不能为空！！！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/add_teacher.do",
        data: {
            teacher_number: number,
            teacher_name: name,
            teacher_sex: sex,
            teacher_birthday: birthday,
            teacher_education: education,
            teacher_position: position,
            teacher_introduction: introduction
        },
        dataType: "json",
        success: function (result) {
            if(result.status == 0){
                alert("添加教师信息成功！");
                window.location.reload();
            }else {
                alert(result.msg);
            }
        },
        error: function() {
            alert("异常");
        }
    })
}

var tno;
function delete_teacher(obj) {
    var tds = $(obj).parent().parent().find('td');
    tno = tds.eq(0).text();
    if(confirm("确定要删除吗？")){
        if(window.event.returnValue == true) {
            if (tno) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/delete_teacher.do",
                    data: {
                        teacher_number: tno
                    },
                    dataType: "json",
                    success: function (result) {
                        if (result.status == 0) {
                            alert("删除成功！");
                            window.location.reload();
                        } else {
                            alert(result.msg);
                        }
                    },
                    error: function () {
                        alert("异常");
                    }
                })
            }
        }
    }
}

function edit_teacher() {
    var number = $("#teacher_number").val();
    var name = $("#teacher_name").val();
    var sexArr = document.getElementsByName("edit_teacher_sex");
    var sex = "";
    for(var i = 0; i < sexArr.length; i++) {
        if(sexArr[i].checked){
            sex = sexArr[i].value;
        }
    }
    var birthday = $("#teacher_birthday").val();
    var education = $("#teacher_education").val();
    var position = $("#teacher_position").val();
    var introduction = $("#teacher_introduction").val();
    $.ajax({
        type: "post",
        url: "http://localhost:8080/edit_teacher.do",
        data: {
            teacher_number: number,
            teacher_name: name,
            teacher_sex: sex,
            teacher_birthday: birthday,
            teacher_education: education,
            teacher_position: position,
            teacher_introduction: introduction
        },
        dataType: "json",
        success: function (result) {
            if(result.status == 0){
                alert("修改成功！");
                window.location.reload();
            }else {
                alert("修改失败！");
            }
        },
        error: function () {
            alert("异常");
        }
    })
}

var taecher_list = new Vue({
    el: "#teacher_list",
    data: {
        param: "",
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/teacher_list.do",
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    _this.datas = result.data;
                }else {
                    alert("出错啦！");
                }
            },
            error: function () {
                alert("异常");
            }
        })
    },
    methods: {
        edit(index) {
            var _this = this;
            $.ajax({
                type: "post",
                url: "http://localhost:8080/teacher_list.do",
                dataType: "json",
                success: function (result) {
                    result2 = result.data[index];
                    console.log(result2);
                    if(result.status == 0){
                        $("#teacher_number").val(result2.tno);
                        $("#teacher_name").val(result2.tname);
                        $("input[name='edit_teacher_sex'][value="+result2.tsex+"]").attr("checked",true);
                        //$("input[type=radio][name='edit_teacher_sex'][value='"+result2.tsex+"']").attr("checked",'checked');
                        //console.log(JSON.stringify(result));
                        //console.log(JSON.stringify(_this.param));
                        //$("input[name='edit_teacher_sex'][value='"+result2.tsex+"']").attr("checked",true);
                        $("#teacher_birthday").val(result2.tbirth);
                        $("#teacher_education").val(result2.teducation);
                        $("#teacher_position").val(result2.tposition);
                        $("#teacher_introduction").val(result2.tintroduction);
                    }else {
                        alert("回显失败！");
                    }
                },
                error: function () {
                    alert("异常");
                }
            })
        }
    }
})