<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        legend {
            color: red;
        }
    </style>
    <%
        String baseUrl = request.getScheme() + "://" +
                request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath() + "/";
    %>
    <title>spingmvc系列-文件上传</title>
    <base href="<%=baseUrl%>"/>
</head>
<body>
<fieldset>
    <legend>案例1</legend>
    <div>单文件上传</div>
    <div>
        <!--需要指定文件格式为 multipart/form-data-->
        <form method="post" action="hello/upload1" enctype="multipart/form-data">
            文件：<input type="file" name="file"/><br/>
            <input type="submit" value="submit">
        </form>
    </div>
</fieldset></body>

<fieldset>
    <legend>案例2</legend>
    <div>多文件上传</div>
    <div>
        <!--有一个统一前缀 chat04，所以 action 填充一定注意不能从 / 开始-->
        <form method="post" action="hello/upload2" enctype="multipart/form-data">
            文件1：<input type="file" name="file1"/><br/>
            文件2：<input type="file" name="file2"/><br/>
            <input type="submit" value="submit">
        </form>
    </div>
</fieldset>

<fieldset>
    <legend>案例3</legend>
    <div>使用 MultipartHttpServletRequest 处理多文件上传</div>
    <div>
        <form method="post" action="hello/upload3" enctype="multipart/form-data">
            姓名：<input name="name" value="汪光武"/><br/>
            年龄：<input name="age" value="23"/><br/>
            文件1：<input type="file" name="file1"/><br/>
            文件2：<input type="file" name="file2"/><br/>
            <input type="submit" value="submit"/>
        </form>
    </div>
</fieldset>

<fieldset>
    <legend>案例4</legend>
    <div>自定义对象接收文件上传参数</div>
    <div>
        <form method="post" action="hello/upload4" enctype="multipart/form-data">
            姓名：<input name="name" value="汪光武"/><br/>
            年龄：<input name="age" value="23"/><br/>
            头像图片：<input name="headImg" type="file"/><br/>
            多张身份证图片<br/>
            <input name="idCardImg" type="file"/><br/>
            <input name="idCardImg" type="file"/><br/>
            <input type="submit" value="submit">
        </form>
    </div>
</fieldset>
</html>
