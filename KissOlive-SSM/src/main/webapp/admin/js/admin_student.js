function add_student() {
    var number = $("#add_student_number").val();
    var name = $("#add_student_name").val();
    var sexArr = document.getElementsByName("student_sex");
    var sex = "";
    for(var i = 0; i < sexArr.length; i++) {
        if(sexArr[i].checked){
            sex = sexArr[i].value;
        }
    }
    var birthday = $("#add_student_birthday").val();
    var dno = $('#add_student_department option:selected') .val();
    if(number == "" || name == "" || sex == "" || birthday == "" || dno == ""){
        alert("不能为空！！！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/add_student.do",
        data: {
            student_number: number,
            student_name: name,
            student_sex: sex,
            student_birthday: birthday,
            student_departmentNumber: dno
        },
        dataType: "json",
        success: function (result) {
            if(result.status == 0){
                alert("添加学生信息成功！");
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

function edit_student() {
    var number = $("#student_number").val();
    var name = $("#student_name").val();
    var sexArr = document.getElementsByName("edit_student_sex");
    var sex = "";
    for(var i = 0; i < sexArr.length; i++) {
        if(sexArr[i].checked){
            sex = sexArr[i].value;
        }
    }
    var birthday = $("#student_birthday").val();
    //var dno = $('#edit_student_department option:selected') .val();
    var dno = $("#edit_student_department  option:selected").val();
    $.ajax({
        type: "post",
        url: "http://localhost:8080/student_edit.do",
        data: {
            student_number: number,
            student_name: name,
            student_sex: sex,
            student_birthday: birthday,
            student_departmentNumber: dno
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

var sno;
function delete_student(obj) {
    var tds = $(obj).parent().parent().find('td');
    sno = tds.eq(0).text();
    if(confirm("确定要删除吗？")) {
        if (window.event.returnValue == true) {
            if (sno) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/delete_student.do",
                    data: {
                        student_number: sno
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

var student_list = new Vue({
    el: "#student_list",
    data: {
        datas: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/student_list.do",
            dataType: "json",
            success: function (result) {
                if(result.status == 0)
                    _this.datas = result.data;
                else
                    alert("出错了！");
            },
            error: function () {
                alert("异常");
            }
        })
    },
    methods: {
        edit(index) {
            $.ajax({
                type: "post",
                url: "http://localhost:8080/student_list.do",
                dataType: "json",
                success: function (result) {
                    result2 = result.data[index];
                    if (result.status == 0) {
                        $("#student_number").val(result2.sno);
                        $("#student_name").val(result2.sname);
                        $("input[name='edit_student_sex'][value="+result2.ssex+"]").attr("checked",true);
                        //$("input[name=edit_student_sex][value=" + result2.ssex + "]").attr("checked", true);
                        //$("#student_birthday").val(result2.sbirth);
                        $("#student_birthday").val(result2.sbirth);
                        selected = $('#edit_student_department').val(result2.sdno);
                        //console.log($("#edit_option").attr("value",result2.dname));
                    } else {
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

var option_list = new Vue({
    el: "#option_list",
    data: {
        selected: "",
        options: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/department_list.do",
            dataType: "json",
            success: function (result) {
                if(result.status == 0)
                    _this.options = result.data;
                else
                    alert("出错了！");
            },
            error: function () {
                alert("异常");
            }
        })
    }
})

var edit_option_list = new Vue({
    el: "#edit_option_list",
    data: {
        selected: "",
        options: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/department_list.do",
            dataType: "json",
            success: function (result) {
                if(result.status == 0)
                    _this.options = result.data;
                else
                    alert("出错了！");
            },
            error: function () {
                alert("异常");
            }
        })
    }
})

