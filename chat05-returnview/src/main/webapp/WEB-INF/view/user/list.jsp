<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>用户列表</h1>
    <h3><a href="${pageContext.request.contextPath}/user/add.do">新增用户</a></h3>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th width="50">id</th>
            <th width="100">name</th>
            <th width="50">age</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr align="center">
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td align="left">
                    <a href="${pageContext.request.contextPath}/user/del/${user.id}.do">删除[请求地址：${pageContext.request.contextPath}/user/del/${user.id}.do]</a>
                    <br><br>
                    <a href="${pageContext.request.contextPath}/user/modify/${user.id}.do">修改[请求地址：${pageContext.request.contextPath}/user/modify/${user.id}.do]</a>
                    <br/><br>
                    <a href="${pageContext.request.contextPath}/user/del1/${user.id}.do">删除[请求地址：${pageContext.request.contextPath}/user/del1/${user.id}.do]</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
