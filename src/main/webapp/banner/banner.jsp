<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#dialogadd").dialog("open");
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }


            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                /*var ids=[];
                var rows=$("#dg").datagrid("getSelections");
                if(rows.length==0){
                    $.messager.alert("警告","您未选中！");
                    $("#dg").datagrid("unselectAll");
                    return false;
                }
                rows.forEach(function(row,i){
                    ids.push(row.id);
                    var index=$("#dg").datagrid("getRowIndex",row);
                    $("#dg").datagrid("deleteRow",index);
            });
                $.ajax({
                    type:"POST",
                    url:"/banner/delete",
                    data:"ids="+ids,
                    dataType:"text",
                    success:function(result){
                        $("#dg").datagrid("reload");
                    }
                });*/
                var row1 = $("#dg").edatagrid("getSelected");
                var index1 = null;
                if (row1 != null) {
                    //编辑指定行
                    index1 = $("#dg").edatagrid("getRowIndex", row1);
                    $("#dg").edatagrid("destroyRow", index1);
                } else {
                    alert("请先选中行")
                }

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath }/banner/delete",
                    data: "id=" + row1.id,
                    dataType: "text",
                    success: function (result) {
                        $("#dg").datagrid("reload");
                    }
                });

            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow")

            }
        }]

        $("#dialogadd").dialog({
            closed : true,
            title : '添加信息',
            width : 200,
            height : 350,
            resizable : true,
            collapsible : true,
            maximizable : true,
            href : "${pageContext.request.contextPath }/banner/add.jsp",
            modal : true,
            cache : false

        });


        $("#dg").edatagrid({
            url: "${pageContext.request.contextPath}/banner/page",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            saveUrl:"${pageContext.request.contextPath}/banner/update",
            /*destroyUrl:"/banner/delete",*/
            columns: [[
                {field: 'title', title: '名字', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required:true}


                    }
                },
                {field: 'imgPath', title: '路径', width: 100},
                {field: 'pubDate', title: '时间', width: 100},
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [3, 4, 5],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        })
    })


</script>

<table id="dg"></table>
<div id="dialogadd"></div>