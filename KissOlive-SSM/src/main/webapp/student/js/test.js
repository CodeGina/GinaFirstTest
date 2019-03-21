$(document).ready(function(){
    var name = $.cookie("sname");
    console.log(name);
    $("#name").html(name);
})