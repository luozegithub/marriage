<%--
  Created by IntelliJ IDEA.
  User: luoze
  Date: 2017/8/20
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <%
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
        request.getSession().setAttribute("basePath",basePath);
    %>
    <script type="text/javascript" src="../../js/jquery/jquery-1.10.2.min.js"/>

    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>

    <script type="text/javascript">
       function care() {
          var id=document.getElementById("user_id").value;
          var value=document.getElementById("care").value;
          alert(value);
          if(value=="关注"){
              $.ajax({
                  url:"${basePath}user/user_care.action",
                  data: {"care.cared_id": id},
                  type: "post",
                  async: false,//非异步
                  success: function(msg){
                      if (msg=="true"){
                          alert("关注成功!")
                          document.getElementById("care").value="取消关注";
                      }
                  }
              });
          }else{
              $.ajax({
                  url:"${basePath}user/user_caredelete.action",
                  data: {"care.cared_id": id},
                  type: "post",
                  async: false,//非异步
                  success: function(){
                          alert("取消关注成功!")
                          document.getElementById("care").value="关注";

                  }
              });
       }
       }
       function check() {
           var id=document.getElementById("user_id").value;
           $.ajax({
               url:"${basePath}user/user_check.action",
               data: {"care.cared_id": id},
               type: "post",
               success: function(msg){
                   if (msg!="true"){
                       document.getElementById("care").value="取消关注";
                   }
           }
           });
       }
    </script>
</head>
<body onload="check();">

姓名：<s:property value="user.name"/> <br>
图片：<img src="../../upload/<s:property value='user.headImg'/>" style="width: 180px;height: 200px;">
<br>
职业：<s:property value="user.dept"/> <br>
账号名称：<s:property value="user.account"/> <br>
性别：<s:property value="user.gender?'男':'女'"/> <br>
联系方式：<s:property value="user.mobile"/> <br>
生日：
<s:textfield id="birthday" name="user.birthday" readonly="true" border="0">
    <s:param name="value"><s:date name="user.birthday" format="yyyy-MM-dd"/></s:param>
</s:textfield>
<br>
备注：<s:property value="user.memo"/>
<input type="hidden" value="<s:property value='user.id'/>" id="user_id">
<br>
<input id="care" type="button" value="关注" onclick="care();">
<input type="button" value="返回" onclick="javascript:history.go(-1);">



</body>
</html>
