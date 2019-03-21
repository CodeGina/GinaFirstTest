function add_department() {
    var number = $("#add_department_number").val();
    var name = $("#add_department_name").val();
    var manager = $("#add_department_manager").val();
    var tel = $("#add_department_tel").val();
    if(number == "" || name == "" || manager =="" || tel == ""){
        alert("院系编号或院系名称或原系主任或院系主任电话不能为空！！！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/add_department.do",
        data: {
            department_number: number,
            department_name: name,
            department_manager: manager,
            department_tel: tel
        },
        dataType: "json",
        success: function (result) {
            if(result.status == 0){
                alert("添加院系信息成功！");
                window.location.reload();
            }else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("异常");
        }
    })
}

var dno;
function delete_department(obj) {
    var tds = $(obj).parent().parent().find("td");
    dno = tds.eq(0).text();
    if(confirm("确定要删除吗？")) {
        if (window.event.returnValue == true) {
            if (dno) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/delete_department.do",
                    data: {
                        department_number: dno
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

function edit_department() {
    var number = $("#department_number").val();
    var name = $("#department_name").val();
    var manager = $("#department_manager").val();
    var tel = $("#department_telephone").val();
    $.ajax({
        type: "post",
        url: "http://localhost:8080/edit_department.do",
        data: {
            department_number: number,
            department_name: name,
            department_manager: manager,
            department_tel: tel
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

var department_list = new Vue({
    el: "#department_list",
    data: {
        datas: []
    },
    created:  function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/department_list.do",
            dataType: "json",
            success: function (result) {
                if (result.status == 0) {
                    _this.datas = result.data;
                }else {
                    alert("出错啦！");
                }
            },
            error: function() {
                alert("异常");
            }
        })
    },
    methods: {
        edit(index){
            $.ajax({
                type: "post",
                url: "http://localhost:8080/department_list.do",
                dataType: "json",
                success: function (result) {
                    result2 = result.data[index];
                    if (result.status == 0){
                        $("#department_number").val(result2.dno);
                        $("#department_name").val(result2.dname);
                        $("#department_manager").val(result2.dmanager);
                        $("#department_telephone").val(result2.dtel);
                    }else {
                        alert("回显失败");
                    }
                },
                error: function () {
                    alert("异常");
                }
            })

        }
    }
})