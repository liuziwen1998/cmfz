<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">

    var toolbar = [{
        iconCls: 'icon-search',
        text: "专辑详情",
        handler: function () {

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
            url: '',
            idField: 'id',
            treeField: 'name',
            columns: [[
                {title: 'Task Name', field: 'name', width: 180},
                {field: 'persons', title: 'Persons', width: 60, align: 'right'},
                {field: 'begin', title: 'Begin Date', width: 80},
                {field: 'end', title: 'End Date', width: 80}
            ]]
        });


    })


</script>

<table id="album"></table>
