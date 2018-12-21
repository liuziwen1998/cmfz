<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">

    var toolbar = [{
        iconCls: 'icon-search',
        text: "专辑详情",
        handler: function () {
            var row = $("#album").treegrid("getSelected")
            if (row == null) {
                alert("请先选中行！！！")
            } else {
                if (row.size == null) {
                    $("#album_dialog").dialog("open")
                    /*填充内容*/
                    $("#album_ff").form("load", row);
                    $("#img").prop("src", "http://localhost:9999/" + row.newname);
                } else {
                    alert("请先选专辑！！！")
                }
            }
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-add',
        handler: function () {


        }
    }, '-', {
        text: "添加章节",
        iconCls: 'icon-add',
        handler: function () {


        }
    }, '-', {
        text: "下载音频",
        iconCls: 'icon-save',
        handler: function () {


        }
    }]

    $(function () {
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAll',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 150},
                {field: 'duration', title: '时长', width: 90},
                {field: 'size', title: '大小', width: 50}

            ]],
            fitColumns: true,
            fit: true,
            toolbar: toolbar,
            pagination: true,
            pageSize: 5,
            pageList: [3, 4, 5]
        });


    })


</script>


<table id="album"></table>
<div id="album_dialog" class="easyui-dialog" title="专辑详情" style="width:480px;height:380px;"
     data-options="iconCls:'icon-filter',resizable:true,modal:true,closed:true">
    <form id="album_ff" method="post">
        <br/>
        <div>
            <label for="name">名&nbsp;&nbsp;称:</label>
            <input class="easyui-validatebox" id="name" type="text" name="title"/>
            <label for="name">作&nbsp;&nbsp;者:</label>
            <input class="easyui-validatebox" id="author" type="text" name="author"/>
        </div>
        <br/>
        <div>
            <label for="zhangjieshu">集&nbsp;&nbsp;数:</label>
            <input class="easyui-validatebox" type="text" id="zhangjieshu" name="count"/>
            <label for="boyinyuan">播音员:</label>
            <input class="easyui-validatebox" type="text" id="boyinyuan" name="broadcast"/>
        </div>
        <br/>
        <div>
            <label for="jianjie">简&nbsp;&nbsp;介:</label>
            <input class="easyui-textbox" type="text" id="jianjie" name="brief" style="height:100px;width: 400px"
                   multiline="true"/>
        </div>
        <br/>
        <div>
            <label for="score">评&nbsp;&nbsp;分:</label>
            <input class="easyui-validatebox" type="text" id="score" name="score"/>
        </div>
        <br/>
        <div>
            <label for="img">封&nbsp;&nbsp;面:</label>
            <img id="img" src="" width="60px" height="80px">
        </div>
    </form>
</div>