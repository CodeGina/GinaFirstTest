function log_off(){
    if(confirm("确定要退出吗？")){
        if(window.event.returnValue == true) {
            $.cookie("sno","",{ expires: -1, path: '/' });
            $.cookie("sname","",{ expires: -1, path: '/' });
            $.cookie("ssex","",{ expires: -1, path: '/' });
            $.cookie("sbirth","",{ expires: -1, path: '/' });
            $.cookie("sdno","",{ expires: -1, path: '/' });
            $.cookie("dname","",{ expires: -1, path: '/' });
            window.location.href = "http://127.0.0.1:8080/login";
        }
    }
}

//导航区域项目点击增加标签页处理
$(function() {
	var calcHeight = function() {
		$('#mainFrameTabs').height(1500);

	};

	$('a', $('#information')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#information");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#message')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#message");
		var menuId = $(li).attr('mid');
		var url = $(li).attr('funurl');
		var title = $(this).text();
		$('#mainFrameTabs').bTabsAdd(menuId, title, url);
	});
	
	$('a', $('#elective')).on('click', function(e) {
		e.stopPropagation();
		var li = $("#elective");
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

    $('a', $('#change_password')).on('click', function(e) {
        e.stopPropagation();
        var li = $("#change_password");
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