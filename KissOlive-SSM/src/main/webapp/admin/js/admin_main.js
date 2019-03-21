function log_off(){
    if(confirm("确定要退出吗？")){
        if(window.event.returnValue == true) {
    		$.cookie("mno","",{ expires: -1, path: '/' });
    		$.cookie("mname","",{ expires: -1, path: '/' });
            window.location.href = "http://127.0.0.1:8080/managerlogin";
        }
    }
}

//导航区域项目点击增加标签页处理
//仅演示功能
$(function() {
	var calcHeight = function() {
		var h = $(window).height();
		$('#mainFrameTabs').height();
	};

	$('a', $('#term')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#term");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#department')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#department");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#teacher')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#teacher");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#student')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#student");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#start')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#start");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#auditing')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#auditing");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#course_selection')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#course_selection");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#score')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#score");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});

    $('a', $('#chang_password')).on('click', function(e) {
        e.stopPropagation();
        var li = $("#chang_password");
        var menuId = $(li).attr('mid');
        var url = $(li).attr('funurl');
        var title = $(this).text();
        $('#mainFrameTabs').bTabsAdd(menuId, title, url);
    });

	//插件的初始化
	//$('#mainFrameTabs').bTabs({
	//	//登录界面URL，用于登录超时后的跳转
	//	'loginUrl': 'http://xxx.com/login',
	//	//用于初始化主框架的宽度高度等，另外会在窗口尺寸发生改变的时候，也自动进行调整
	//	'resize': function() {
	//		//这里只是个样例，具体的情况需要计算
	//		$('#mainFrameTabs').height(100);
	//	}
	//});

	$('#mainFrameTabs').bTabs({
		resize: calcHeight
	});

    //关闭全部tab
    $(".allTabsCloseBtn").click(
        function(){
            //询问是否关闭全部
            if (confirm("是否要关闭所有选项卡 ?")){
                window.location.href='admin_main.html';
            }
        });

});