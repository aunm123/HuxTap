<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
        //全选、全反选
        function doSelectAll(){
            // jquery 1.6 前
            //$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
            //prop jquery 1.6+建议使用
            $("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));
        }
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        用户名：<s:textfield name="user.name" cssClass="s_text" id="userName"  cssStyle="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>
                        <input name="userExcel" type="file"/>
                        <input type="button" value="导入" class="s_button" onclick="doImportExcel()"/>


                    </li>
                </div>


                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                        </tr>

                        <tr bgcolor="f8f8f8">
                            <td align="center"><input type="checkbox" name="selectedRow" value=""/></td>
                            <td align="center">xxx</td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center"></td>
                            <td align="center">
                                <a href="javascript:doEdit(id)">编辑</a>
                                <a href="javascript:doDelete(id)">删除</a>
                            </td>
                        </tr>

                    </table>
                </div>
            </div>
            <div class="c_pate" style="margin-top: 5px;">
                <table width="100%" class="pageDown" border="0" cellspacing="0"
                       cellpadding="0">
                    <tr>
                        <td align="right">
                            总共1条记录，当前第 1 页，共 1 页
                            <a href="#">上一页</a>  <a href="#">下一页</a>
                            到 <input type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
                                     max="" value="1" />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</form>


</body>
</html>