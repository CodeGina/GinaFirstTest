$(document).ready(function(){
    var name = $.cookie("mname");
    console.log(name);
    $("#name").html(name);
})