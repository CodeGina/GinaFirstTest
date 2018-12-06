var msg = new Vue({
    el: "#msgList",
    data: {
        sno: $.cookie("sno"),
        datas: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getStudentMessage.do",
            data: {
                student_num: _this.sno
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
    }
});