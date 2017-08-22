<%--
  Created by IntelliJ IDEA.
  User: luoze
  Date: 2017/8/19
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        div{
            width:800px;
            height:400px;
            margin: 0 auto;
           border:1px solid red;
        }
        form{
            width:100px;
            margin: 150px auto;
        }
    </style>

    <script type="text/javascript">
        function checkAccountAndPassword(){

            document.getElementById("loginform").submit();
        }
        function Toregister() {
            window.location.href="/sys/login_toregister.action";
        }
    </script>
</head>
<body>
<div>
    <form id="loginform" action="login_login.action" namespace="/sys" method="post" onsubmit="return checkAccountAndPassword();">
        用户名：  <input type="text" name="user.account"><br>
        密码：    <input type="password" name="user.password">
        <br>
        <input type="button" value="注册" onclick="Toregister();">
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
