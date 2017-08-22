<%--
  Created by IntelliJ IDEA.
  User: luoze
  Date: 2017/8/20
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
    request.getSession().setAttribute("basePath",basePath);
%>
<script type="text/javascript">
    function userinfo(id) {
        window.location.href="${basePath}user/user_userinfo.action?user.id="+id;
    }
</script>
<body>
<div style="border:1px solid red;height: 50px">
    欢迎登录！${user.name} <br>
    <a href="${basePath}user/user_editUI.action?user.id=${user.id}">编辑个人信息</a>
    <a href="${basePath}user/user_listUI.action">查看所有人</a>
    <a href="${basePath}user/user_mycared.action?user.id=${user.id}">我关注的</a>
    <a href="${basePath}user/user_careme.action?user.id=${user.id}">我的粉丝</a>
    <a href="${basePath}sys/login_logout.action">注销</a>
</div>
<s:iterator value="userList" status="st">
    <img src="../../upload/<s:property value='headImg'/>" style="width: 180px;height: 200px;" onclick="userinfo('<s:property value="id"/>');">
</s:iterator>


</body>
</html>
