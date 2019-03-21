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
function entryGrade(obj) {
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
                        $('#totalcount').val(this.datas.length);
                        $('#kechenghao').val(cno);
                        //console.log(this.datas[1].sno);
                    },
                    methods: {
                        infoId: function (index) {
                            return "info" + index
                        }
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
$('#score').on('hidden.bs.modal', function () {
    window.location.reload();
})

function submiton(obj) {
    var totalcount = $('#totalcount').val();
    var cno = parseInt($('#kechenghao').val());
    var items = [];
    for (var i = 0; i < totalcount; i++) {
        var param = {
            "sno":$(("#info"+i)).find(".sno").html(),
            "sname":$(("#info"+i)).find(".sname").html(),
            "grade":parseInt($(("#info"+i)).find(".form-control").val()),
            "cno":cno
        }
        items.push(param);
    }
    $.ajax({
        type: "post",
        url: "http://localhost:8080/entryGrade.do",
        data: JSON.stringify(items),
        dataType: "json",
        contentType: 'application/json',
        success: function (result) {
            if(result.status == 0){
                alert("评分成功！");
            }else {
                alert("回显失败！");
            }
        },
        error: function () {
            alert("异常");
        }
    })
}