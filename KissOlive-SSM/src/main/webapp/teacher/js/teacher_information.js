var teacher_information = new Vue({
    el: '#teacher_information',
    data: {
        tno:$.cookie("tno"),
        tname: $.cookie("tname"),
        tsex: $.cookie("tsex"),
        tbirth: $.cookie("tbirth"),
        teducation: $.cookie("teducation"),
        tposition: $.cookie("tposition"),
        tintroduction: $.cookie("tintroduction")
    }
});