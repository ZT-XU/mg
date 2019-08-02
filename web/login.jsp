<%--
  Created by IntelliJ IDEA.
  User: xzt
  Date: 2019/7/31
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox loginbox1">

        <form action="login.do" method="post">
            <ul><%
                Object obj = request.getAttribute("flag");
                if(obj != null)
                    out.write("<li><span>用户名或密码错误</span></li>");
                String str = request.getParameter("flag");
                if (str !=null &&str.equals("1"))
                    out.write("<li><span>密码修改成功，请重新登录</span></li>");
                else if (str !=null && str.equals("3"))
                    out.write("<li><span>注册成功！！！</span></li>");
            %>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser"/></li>
                <li><input name="pwd" type="password" placeholder="密码" class="loginpwd"/></li>
                <li class="yzm">
                    <span><input name="" type="text" value="验证码"
                                 onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"
                           onclick="javascript:window.location='main.jsp'"/><label><a href="user/register.jsp">注册</a></label><label><a
                        href="#">忘记密码？</a></label></li>
            </ul>
        </form>


    </div>

</div>


<div class="loginbm">版权所有 2019 <a href="https://jianshu.com/u/0fc1d53768b6">xzt</a> 仅供学习交流，勿用于任何商业用途</div>


</body>

</html>

