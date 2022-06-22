<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/login">
        姓名：<input name="name" value="wangguangwu"/><br/>
        密码：<input name="password" value="666"/><br/>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
