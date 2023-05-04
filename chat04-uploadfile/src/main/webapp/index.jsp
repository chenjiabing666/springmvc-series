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
    <form method="post" action="upload1.do" enctype="multipart/form-data">
        文件：<input type="file" name="file1"><br/>
        <input type="submit" value="提交">
    </form>
    </div>
</fieldset>


<fieldset>
    <legend>案例2</legend>
    <div>多文件上传</div>
    <div>
    <form method="post" action="upload2.do" enctype="multipart/form-data">
        文件1：<input type="file" name="file1"><br/>
        文件2：<input type="file" name="file2"><br/>
        <input type="submit" value="提交">
    </form>
    </div>
</fieldset>


<fieldset>
    <legend>案例3</legend>
    <div>使用MultipartHttpServletRequest处理多文件上传</div>
    <div>
        <form method="post" action="upload3.do" enctype="multipart/form-data">
            姓名：<input name="name" value="路人"/> <br/>
            年龄：<input name="age" value="30"/><br/>
            文件1：<input type="file" name="file1"><br/>
            文件2：<input type="file" name="file2"><br/>
            <input type="submit" value="提交">
        </form>
    </div>
</fieldset>

<fieldset>
    <legend>案例4</legend>
    <div>自定义对象接收文件上传参数</div>
    <div>
<form method="post" action="upload4.do" enctype="multipart/form-data">
    姓名：<input name="name" value="路人"/> <br/>
    年龄：<input name="age" value="30"/><br/>
    头像图片：<input name="headImg" type="file"/><br/>
    多张身份证图片<br/>
    <input name="idCardImg" type="file"/><br/>
    <input name="idCardImg" type="file"/><br/>
    <input type="submit" value="提交">
</form>
    </div>
</fieldset>
</body>
</html>
