var list = new Vue({
    el: "#list",
    data: {
        datas: []
    },
    created: function () {
        var _this = this;
        $.ajax({
            type: "post",
            url: "http://localhost:8080/getCourseSituation.do",
            data: {
                ctno: $.cookie("tno")
            },
            dataType: "json",
            success:function (result) {
                if(result.status == 0){
                    _this.datas = result.data;
                    // console.log(_this.datas[0].cstatus);
                    for(var i = 0; i < _this.datas.length;i++){
                        if(_this.datas[i].cstatus == 0)
                            _this.datas[i].cstatus = "等待审核";
                        else if(_this.datas[i].cstatus == 1)
                            _this.datas[i].cstatus = "通过审核";
                        else if(_this.datas[i].cstatus == 2)
                            _this.datas[i].cstatus = "不通过审核";
                        else if(_this.datas[i].cstatus == 3)
                            _this.datas[i].cstatus = "无法开课";
                        else if(_this.datas[i].cstatus == 4)
                            _this.datas[i].cstatus = "正常开课";
                    }
                }else{
                    alert("出错啦！");
                }
            },
            error: function () {
                alert("异常");
            }
        })
    },
    ready: function () {
        if(this.datas.cstatus == 2)
            Vue.set(data,'status','等待审核');
    }
})