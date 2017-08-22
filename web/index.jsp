<%--
  Created by IntelliJ IDEA.
  User: luo ze
  Date: 2016/11/15
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path=request.getContextPath();
  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
  response.sendRedirect(basePath+"sys/login_toLoginUI.action");

%>

