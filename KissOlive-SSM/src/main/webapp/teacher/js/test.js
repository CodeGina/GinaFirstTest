$(document).ready(function(){
    var name = $.cookie("tname");
    console.log(name);
    $("#name").html(name);
})