var student_information = new Vue({
    el: '#student_information',
    data: {
        sno:$.cookie("sno"),
        sname: $.cookie("sname"),
        ssex: $.cookie("ssex"),
        sbirth: $.cookie("sbirth"),
        sdno: $.cookie("sdno"),
        dname: $.cookie("dname")
    }
});