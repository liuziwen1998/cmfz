<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {

        $("#AlbumtitleIPT").textbox();
        $("#coverImgIPT").filebox({
            buttonText: '选择文件',
            buttonAlign: 'left'
        });

        $("#authorIPT").textbox();
        $("#countIPT").textbox();
        $("#broadcastIPT").textbox();
        $("#scoreIPT").textbox();
        $("#briefIPT").textbox();
        $("#pubDateIPT").datebox({
            formatter: function (date) {
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                return y + "-" + m + "-" + d;
            }

        });
        $("#addAlbum").linkbutton({
            iconCls: "icon-add",
            plain: true,
            onClick: function () {
                $("#addAlbumFrom").form("submit", {
                    url: "${pageContext.request.contextPath }/album/add",
                    onSubmit: function () {
                        return $("#addAlbumFrom").form("validate");
                    },
                    success: function () {
                        $("#dialogalubmadd").dialog("close");
                        $.messager.show({
                            title: "提示信息",
                            msg: "添加成功"
                        });
                        $("#dg").datagrid("reload");
                    }
                });
            }
        });
    });
</script>
<form method="post" id="addAlbumFrom" enctype="multipart/form-data">
    标题：<input id="AlbumtitleIPT" name="title"><br/>
    作者：<input id="authorIPT" name="author"><br/>
    集数：<input id="countIPT" name="count"><br/>
    播音员：<input id="broadcastIPT" name="broadcast"><br/>
    评分：<input id="scoreIPT" name="score"><br/>
    简介： <input id="briefIPT" name="brief"><br/>
    封面：<input id="coverImgIPT" name="img"><br/>
    创建日期：<input id="pubDateIPT" name="pubDate"><br/>
    <a id="addAlbum">提交</a>
</form>
