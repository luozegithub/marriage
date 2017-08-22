<%--
  Created by IntelliJ IDEA.
  User: luoze
  Date: 2017/8/19
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    #divall{
        width:800px;
        height:600px;
        margin: 0 auto;
        border:1px solid red;
    }
    form{

        margin: 20px auto;
    }
</style>


<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
    request.getSession().setAttribute("basePath",basePath);
%>
<script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
<body>
<div id="divall">
    <form id="registerform" action="login_register.action" namespace="/login" method="post"  enctype="multipart/form-data" onsubmit="return checkAccountAndPassword();">
        <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户</div></div>
                <div class="tableH2">新增用户</div>
                <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
                    <tr>
                        <td class="tdBg" width="200px">姓名：</td>
                        <td><input type="text" name="user.name"/></td>
                    </tr>
                    <tr>
                        <td class="tdBg" width="200px">职业：</td>
                        <td><input type="text" name="user.dept"></td>
                    </tr>
                    <tr>
                        <td class="tdBg" width="200px">帐号：</td>
                        <td><input type="text" name="user.account"/></td>
                    </tr>
                    <tr>
                        <td class="tdBg" width="200px">密码：</td>
                        <td><input type="password" name="user.password"/></td>
                    </tr>

                    <tr>
                        <td class="tdBg" width="200px">头像：</td>
                        <td>
                            <input type="file" name="headImg"/>
                        </td>
                    </tr>
                    <tr>

                        <td class="tdBg" width="200px">性别：</td>
                        <td>

                            <input type="radio" name="user.gender" value='true'>男
                            <input type="radio" name="user.gender" value='false'>女
                        </td>
                    </tr>

                    <tr>
                        <td class="tdBg" width="200px">电子邮箱：</td>
                        <td><input type="text" name="user.email"/></td>
                    </tr>
                    <tr>
                        <td class="tdBg" width="200px">手机号：</td>
                        <td><input type="text" name="user.mobile"/></td>
                    </tr>
                    <tr>
                        <td class="tdBg" width="200px">生日：</td>
                        <td><input type="text" id="birthday" name="user.birthday" readonly="true" onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" /></td>
                    </tr>
                    <tr>
                        <td class="tdBg" width="200px">备注：</td>
                        <td><textarea name="user.memo" rows="7" cols="30"></textarea>
                        </td>
                    </tr>
                </table>
                <div>
                    <input type="submit"  value="保存"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button"  onclick="javascript:history.go(-1)"  value="返回" />
                </div>
            </div></div></div>
    </form>
</div>
</body>
</html>
