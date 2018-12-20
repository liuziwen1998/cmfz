<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {

        $("#titleIPT").textbox();
        $("#imgPathIPT").filebox({
        buttonText: '选择文件',
        buttonAlign: 'left'
    });

        $("#statusIPT").textbox();
        $("#descriptionIPT").textbox();

        $("#pubDateIPT").datebox({
            formatter: function (date) {
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                return y + "-" + m + "-" + d;
            }

        });
        $("#add").linkbutton({
            iconCls: "icon-add",
            plain: true,
            onClick: function () {
                $("#addFrom").form("submit", {
                    url: "${pageContext.request.contextPath }/banner/add",
                    onSubmit: function () {
                        return $("#addFrom").form("validate");
                    },
                    success: function () {
                        $("#dialogadd").dialog("close");
                        $.messager.show({
                            title: "提示信息",
                            msg: "添加成功"
                        });
                        $("#dg").datagrid("load");
                    }
                });
            }
        });
    });
</script>
<form method="post" id="addFrom" enctype="multipart/form-data">
    标题：<input id="titleIPT" name="title"><br/>
    文件：<input id="imgPathIPT" name="img"><br/>
    状态：<input id="statusIPT" name="status"><br/>
    上传日期：<input id="pubDateIPT" name="pubDate"><br/>
    描述：<input id="descriptionIPT" name="description"><br/>
    <a id="add">提交</a>
</form>
