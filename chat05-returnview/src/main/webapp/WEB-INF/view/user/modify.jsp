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
    <h1>修改用户信息</h1>
    <h3><a href="${pageContext.request.contextPath}/user/list.do">返回用户列表</a></h3>
    <form action="${pageContext.request.contextPath}/user/save.do" method="post">
        <input type="hidden" name="id" value="${user.id}">
        姓名：<input type="text" name="name" value="${user.name}"><br/>
        年龄：<input type="number" name="age" value="${user.age}"><br/>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
