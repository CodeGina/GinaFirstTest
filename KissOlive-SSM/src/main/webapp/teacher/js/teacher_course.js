var list = new Vue({
    el: "#list",
    data: {
        datas:[]
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getStartCourseByTeacher.do",
            data: {
                teacher_number: $.cookie("tno")
            },
            dataType: "json",
            success:function (result) {
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

var student_list;
function look(obj) {
    var tds = $(obj).parent().parent().find('td');
    cno = tds.eq(0).text();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getStudentChooseCourse.do",
            data: {
                course_number: cno
            },
            dataType: "json",
            success: function (result) {
                if(result.status == 0){
                    student_list = new Vue({
                        el: "#student_list",
                        data:{
                            datas: []
                        },
                        created: function () {
                            this.datas = result.data;
                            console.log(this.datas);
                        }
                    });
                }else {
                    alert("回显失败！");
                }
            },
            error: function () {
                alert("异常");
            }
        })
}

//模态框隐藏时触发
$('#lookup').on('hidden.bs.modal', function () {
    window.location.reload();
})