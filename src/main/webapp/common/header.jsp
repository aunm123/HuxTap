<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>

<%--<script type="text/javascript" src="${basePath}js/jquery/jquery-1.10.2.min.js"></script>--%>
<link href="${basePath}css/skin1.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    var vResult = false;
    function doverify() {
        var account = $("#account").val();
        if (account!=""){
            $.ajax({
                url:"${basePath}user_verifyAccount.do",
                data:{"user.account":account},
                type:"post",
                success:function (msg) {
                    if("true"!=msg){
                        alert("账户已存在，请使用其他账号！");
                        $("#account").focus();
                        vResult = false;
                    }else {
                        vResult = true;
                    }
                }
            })
        }
    }
    function onAddSumbit() {
        doverify();
        return vResult;
    }
</script>
