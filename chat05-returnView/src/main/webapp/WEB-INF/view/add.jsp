<%--
  Created by IntelliJ IDEA.
  User: wangguangwu
  Date: 2022/6/21
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .content {
            width: 60%;
            margin: auto;
        }
    </style>
    <title>spingmvc系列-返回jsp页面</title>
</head>
<body>
<div class="content">
    <h1>新增用户信息</h1>
    <h3><a href="${pageContext.request.contextPath}/user/list">返回用户列表</a></h3>
    <form action="${pageContext.request.contextPath}/user/save" method="post">
        用户ID：<input type="number" name="id"><br/>
        姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="name"><br/>
        年&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="number" name="age"><br/>
        <input type="submit" value="submit">
    </form>
</div>
</body>
</html>
