function publish() {
    var title = $("#title").val();
    var content = $("#content").val();
    console.log(content);
    if(title == "" || content == ""){
        alert("标题或内容不能为空！");
        return false;
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/sentElectiveNotice.do",
        data: {
            title: title,
            content: content
        },
        dataType: "json",
        success: function (result) {
            if(result.status == 0){
                alert("发布通知成功！");
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