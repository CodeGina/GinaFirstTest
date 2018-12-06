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