var list = new Vue({
    el: "#list",
    data: {
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getMyGrade.do",
            dataType: "json",
            data: {
                sno : $.cookie("sno")
            },
            success: function (result) {
                if(result.status == 0){
                    _this.datas = result.data;
                    console.log(JSON.stringify(result.data));
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