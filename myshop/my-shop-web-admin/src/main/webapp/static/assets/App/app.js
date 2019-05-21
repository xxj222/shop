var App = function(){

    var _checkMaster ;
    var _checkbox ;
    var _idArray;


    var defaultDropzoneOptions = {
        url: "", // 文件提交地址
        method: "post",  // 也可用put
        paramName: "dropzFile", // 默认为file
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传1个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
        init: function () {
            this.on("addedfile", function (file) {
                // 上传文件时触发的事件
            });
            this.on("success", function (file, data) {
                // 上传成功触发的事件
            });
            this.on("error", function (file, data) {
                // 上传失败触发的事件
            });
            this.on("removedfile", function (file) {
                // 删除文件时触发的方法
            });
        }
    };


    /**
     * 初始化checkbox
     */
    var handlerInitCheckbox = function(){
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
        //选择主控制器
        _checkMaster =  $('input[type="checkbox"].minimal.check_master');
        //选择单个checkbox
        _checkbox =  $('input[type="checkbox"].minimal');
    };
    /**
     * 选择所有的选择框
     */
    var handlerCheckboxAll =  function(){
        _checkMaster.on("ifClicked",function(e){
            console.log(e.target.checked);
            //全选
            if(!e.target.checked){
                _checkbox.iCheck("check");
            }
            //取消全选
            else{
                _checkbox.iCheck("uncheck");
            }

        })

    }


    var handlerDeleteMulti = function(url){

        _idArray = new Array();
        _checkbox.each(function(){
            var _id =  ($(this).attr("id"));

            if(_id != "undefine" && _id != null && $(this).is(":checked"))
                _idArray.push(_id)
        })

        if(_idArray.length === 0){
            $("#modal-message").html("请选择至少一项数据进行删除");
        }
        else{
            $("#modal-message").html("确定要删除数据么？");
        }
        $("#modal-default").modal("show");

        $("#btnModalOk").bind("click",function(){
            del();
        });

        //私有函数的私有方法
        function del(){
            $("#modal-default").modal("hide");
            if(_idArray.length === 0){

                //   删除可以做的工作
            }
            else{
             setTimeout(function(){
                 $.ajax({
                     "url":url,
                     "type":"POST",
                     "data":{"ids":_idArray.toString()},
                     "dataType":"JSON",
                     "success":function(data){
                         $("#btnModalOk").unbind("click");
                         //删除成功
                         if(data.status === 200){
                             $("#btnModalOk").bind("click",function () {
                                 window.location.reload();
                             })
                         }
                         //删除失败
                         //   删除还存在问题。删除后会有蒙版效果出现
                         else{

                             $("#btnModalOk").bind("click",function () {
                                 $("#modal-default").modal("hide");
                             })

                         }
                         $("#modal-message").html(data.message);
                         $("#modal-default").modal("show");
                     }

                 });
             },500)
            }
        }

    };


    var handlerInitDatabales=function(url,columns){
       var _table =  $('#dataTable').dataTable({
            "paging":true,
            "info":true,
            "lengthChange": false,
            "ordering":false,
            "processing": true,
            "searching":false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function( settings ) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }
        });
        return _table;
    }

    var handlerShowDetail=function(url){
        $.ajax({
            url:url,
            type:"get",
            dataType:"html",
            success:function(data){
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");

            }
        })
    }


    var handlerInitTreeData = function(url,autParam,callback){

        var setting = {
            view: {
                // 禁止多选
                selectedMulti: false
            },
            async: {
                enable: true,
                url:url,
                autoParam:autParam
            }
        };
        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click", function () {
            // 获取 zTree 控件
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            // 获取已选中的节点
            var nodes = zTree.getSelectedNodes();
            if (nodes.length == 0) {
                alert("请先选择一个父节点");
            }

            else {
                callback(nodes)
            }
        });



    }

    var handlerInitDropzone = function(opts){
        console.log("666666");
        //关闭dropzone的自动发现功能
        Dropzone.autoDiscover = false;

        //jquery 继承
        $.extend(defaultDropzoneOptions,opts);
        console.log(defaultDropzoneOptions.id);
        new Dropzone(defaultDropzoneOptions.id,defaultDropzoneOptions);

    }



    return {
        init:function(){
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        deleteMulti :function(url){
            handlerDeleteMulti(url);
        },
        initDatatables:function(url,columns){
          return  handlerInitDatabales(url,columns);
        },
        initShowDetail:function(url){
            handlerShowDetail(url)
        },
        initTreeData:function(url,autParam,callback){
            handlerInitTreeData(url,autParam,callback)
        },
        initDropzone:function(opts){
            console.log(66666);
            handlerInitDropzone(opts);
        }


    }

}();





(function($) {
    App.init();
})(jQuery);