<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
        request.getSession().setAttribute("basePath",basePath);
    %>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
    <%@taglib prefix="s" uri="/struts-tags" %>
</head>
<body>
<form id="form" name="form" action="${basePath }user/user_edit.action" method="post" enctype="multipart/form-data">

    <div >编辑用户</div>
    <table id="baseInfo" width="100%" align="center"  border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td  width="200px">职业：</td>
            <td><s:textfield name="user.dept"/> </td>
        </tr>
        <tr>
            <td  width="200px">头像：</td>
            <td>
                <s:if test="%{user.headImg != null && user.headImg != ''}">
                    <img src="${basePath }upload/<s:property value='user.headImg'/>" width="100" height="100"/>
                    <s:hidden name="user.headImg"/>
                </s:if>
                <input type="file" name="headImg"/>
            </td>
        </tr>
        <tr>
            <td  width="200px">用户名：</td>
            <td><s:textfield name="user.name"/> </td>
        </tr>
        <tr>
            <td  width="200px">帐号：</td>
            <td><s:textfield name="user.account"/></td>
        </tr>
        <tr>
            <td  width="200px">密码：</td>
            <td><s:textfield name="user.password"/></td>
        </tr>
        <tr>
            <td  width="200px">性别：</td>
            <td><s:radio list="#{'true':'男','false':'女'}" name="user.gender"/></td>
        </tr>
        <tr>
            <td  width="200px">角色：</td>
            <td></td>
        </tr>
        <tr>
            <td  width="200px">电子邮箱：</td>
            <td><s:textfield name="user.email"/></td>
        </tr>
        <tr>
            <td  width="200px">手机号：</td>
            <td><s:textfield name="user.mobile"/></td>
        </tr>        
        <tr>
            <td  width="200px">生日：</td>
            <td>
            <s:textfield id="birthday" name="user.birthday" readonly="true" 
            onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" >
            	<s:param name="value"><s:date name="user.birthday" format="yyyy-MM-dd"/></s:param>
            </s:textfield>
            </td>
        </tr>
        <tr>
            <td  width="200px">备注：</td>
            <td><s:textarea name="user.memo" cols="75" rows="3"/></td>
        </tr>
    </table>
    <s:hidden name="user.id"/>
    <div >
        <input type="submit"  value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)"  value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>