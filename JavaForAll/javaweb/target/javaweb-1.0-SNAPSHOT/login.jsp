<%--
  Created by IntelliJ IDEA.
  User: linsz
  Date: 2022/6/2017126
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="./css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv">
    <form action="/loginServlet" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <h3 style="font-family: red">${login_errMsg}${register_sucMsg}</h3>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>

        <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>

        <p>记住我：<input name="remember" value="1" checked type="checkbox"></p>

        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？点击注册</a>
        </div>
    </form>
</div>

</body>
</html>