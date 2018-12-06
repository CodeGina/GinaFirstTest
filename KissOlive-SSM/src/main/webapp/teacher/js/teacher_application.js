function send() {
    var class_name = $("#class_name").val();
    var typeArr = document.getElementsByName("type");
    var type = "";
    for(var i = 0; i < typeArr.length; i++) {
        if(typeArr[i].checked){
            type = typeArr[i].value;
        }
    }
    var term = $('#term option:selected') .val();
    var desc = $("#desc").val();
    var tno = $.cookie("tno");
    if(class_name == "" || type == "" || term == "" || desc == ""){
        alert("不能为空！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/ClassApplication.do",
        data: {
            course_name: class_name,
            type: type,
            term: term,
            desc: desc,
            teacher_number: tno
        },
        dataType: "json",
        success: function (result) {
            if(result.status == 0){
                alert("发送成功！");
                $("form")[0].reset();
            }else {
                alert("出错啦！");
            }
         },
        error: function () {
            alert("异常");
        }
    })
}

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
            url: "http://localhost:8080/term_list.do",
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