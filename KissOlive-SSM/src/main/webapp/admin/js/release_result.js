var list = new Vue({
    el: "#list",
    data: {
        datas: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: 'http://localhost:8080/getCourseList.do',
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

function agree(obj) {
    var tds = $(obj).parent().parent().find('td');
    cno = tds.eq(1).text();
    if(cno){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/change_status.do",
            data: {
                course_number: cno,
                course_status: 4
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    //alert("开课！");
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
            url: "http://localhost:8080/getStartCourseList.do",
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
    cno = tds.eq(1).text();
    if(cno){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/change_status.do",
            data: {
                course_number: cno,
                course_status: 3
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
            url: "http://localhost:8080/getNotStartCourseList.do",
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