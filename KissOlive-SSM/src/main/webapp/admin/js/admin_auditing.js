var list = new Vue({
    el: "#list",
    data: {
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getClassApplication.do",
            dataType: "json",
            success: function (ressult) {
                if(ressult.status == 0){
                    _this.datas = ressult.data;
                }else{
                    alert("出错啦！");
                }
            },
            error: function () {
                alert("异常");
            }
        })
    }
})

var cno
function agree(obj) {
    var tds = $(obj).parent().parent().find('td');
    cno = tds.eq(0).text();
    if(cno){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/change_status.do",
            data: {
                course_number: cno,
                course_status: 1
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    //alert("通过审核！");
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
}

var agree_frame = new Vue({
    el: "#agree_frame",
    data: {
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getAuditingCourseList.do",
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
    }
})

function disagree(obj) {
    var tds = $(obj).parent().parent().find('td');
    cno = tds.eq(0).text();
    if(cno){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/change_status.do",
            data: {
                course_number: cno,
                course_status: 2
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    //alert("不通过审核！");
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
}

var disagree_frame = new Vue({
    el: "#disagree_frame",
    data: {
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getNotAuditingCourseList.do",
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
    }
})


