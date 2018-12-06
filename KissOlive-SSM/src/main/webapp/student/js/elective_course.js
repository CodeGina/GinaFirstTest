var list = new Vue({
    el: "#list",
    data: {
        datas: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/courseNotSelected.do",
            data: {
                student_number: $.cookie("sno")
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    _this.datas = result.data;
                }else{
                    alert("出错啦！");
                }
            },
            error: function () {
                alert("异常");
            }
        })
    },
    methods: {
        look(index){
            $.ajax({
                type: "post",
                url: "http://localhost:8080/courseNotSelected.do",
                data: {
                    student_number: $.cookie("sno")
                },
                dataType: "json",
                success: function (result) {
                    result2 = result.data[index];
                    if (result.status == 0) {
                        $("#course_desc").text(result2.cdesc);
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

// 选课
var cno;
function select(obj){
    var tds = $(obj).parent().parent().find('td');
    cno = tds.eq(1).text();
    var termno = tds.eq(0).text();
    var cresnum = tds.eq(5).text()
    if(cno){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/selectClass.do",
            data: {
                student_number: $.cookie("sno"),
                course_number: cno,
                term_number: termno
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    $.ajax({
                        type: "post",
                        url: "http://localhost:8080/reduceResnum.do",
                        data: {
                            course_number: cno,
                            cresnum: cresnum
                        },
                        dataType: "json",
                        success: function (result) {
                            if(result.status == 0){
                                alert("选课成功！");
                            }else {
                                alert("出错啦！");
                            }
                        },
                        error: function () {
                            //alert("reduceResnum.do异常");
                        }
                    });
                    window.location.reload();
                }else {
                    alert(result.msg);
                }
            },
            error: function () {
                alert("selectClass.do异常");
            }
    })
    }
}

// 已选课程
var selected = new Vue({
    el: "#selected",
    data: {
        datas: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/courseIsSelected.do",
            data: {
                student_number: $.cookie("sno")
            },
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
        see(index){
            $.ajax({
                type: "post",
                url: "http://localhost:8080/courseIsSelected.do",
                data: {
                    student_number: $.cookie("sno")
                },
                dataType: "json",
                success: function (result) {
                    result2 = result.data[index];
                    if (result.status == 0) {
                        $("#selected_course_desc").text(result2.cdesc);
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

//退选
var sno;
function withdrawalCourse(obj) {
    var tds = $(obj).parent().parent().find('td');
    sno = tds.eq(0).text();
    if(confirm("确定要退选吗？")) {
        if (window.event.returnValue == true) {
            if (sno) {
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/addResnum.do",
                    data: {
                        sct_number: sno,
                        cresnum: $(obj).parent().parent().find('td').eq(6).text()
                    },
                    dataType: "json",
                    success: function (result) {
                        if(result.status == 0){
                            $.ajax({
                                type: "post",
                                url: "http://localhost:8080/withdrawalCourse.do",
                                data: {
                                    scort_number: sno
                                },
                                dataType: "json",
                                success: function (result) {
                                    if (result.status == 0) {
                                        window.location.reload();
                                    } else {
                                        alert(result.msg);
                                    }
                                },
                                error: function () {
                                    alert("异常");
                                }
                            })
                        }else {
                            alert("出错啦！");
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

