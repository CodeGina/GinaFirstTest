function add_term(){
    var number = $("#add_term_number").val();
    var desc = $("#add_term_desc").val();
    if(number == "" || desc == ""){
        alert("学期编号或学期描述不能为空！！！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/add_term.do",
        data: {
            term_number: number,
            term_desc: desc
        },
        dataType: "json",
        success: function (data) {
            if(data.status == 0){
                alert("添加学期信息成功！");
                window.location.reload();
            }else {
                alert(data.msg);
            }
        },
        error: function() {
            alert("异常");
        }
    })
}

var termno;
function delete_term(obj) {
    var tds = $(obj).parent().parent().find('td');
    termno = tds.eq(0).text();
    if (confirm("确定要删除吗？")) {
        if (window.event.returnValue == true) {
            if (termno) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/delete_term.do",
                    data: {
                        term_number: termno
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.status == 0) {
                            alert("删除成功！");
                            window.location.reload();
                        } else {
                            alert(data.msg);
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

function edit_term() {
    var number = $("#term_number").val();
    var desc = $("#term_desc").val();
    $.ajax({
        type: "post",
        url: "http://localhost:8080/edit_term.do",
        data: {
            term_number: number,
            term_desc: desc
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


var term_list = new Vue({
    el: "#term_list",
    data: {
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/term_list.do",
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
    methods:{
        edit(index) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/term_list.do",
            dataType: "json",
            success: function (result) {
                result2 = result.data[index];
                if(result.status == 0){
                    $("#term_number").val(result2.termno);
                    $("#term_desc").val(result2.termdesc);
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

