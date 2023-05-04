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
    <title>spingmvc系列</title>
    <base href="<%=baseUrl%>"/>
</head>
<body>
<fieldset>
    <legend>案例1</legend>
    <div>接收参数（HttpServletRequest/HttpServletResponse/HttpSession）</div>
    <div>
        <form method="post" action="receiveparam/test1.do">
            姓名：<input name="name" value="路人"/> <br/>
            年龄：<input name="age" value="30"/><br/>
            <input type="submit" value="提交">
        </form>
    </div>
</fieldset>


<fieldset>
    <legend>案例2</legend>
    <div>接收请求中的参数(String name,Integer age)</div>
    <div>
        <form method="post" action="receiveparam/test2.do">
            姓名：<input name="name" value="路人"/> <br/>
            年龄：<input name="age" value="30"/><br/>
            <input type="submit" value="提交">
        </form>
    </div>
</fieldset>


<fieldset>
    <legend>案例3</legend>
    <div>参数名称和方法参数名称不一致，可以使用@RequestParam("参数名称")来获取请求中的参数</div>
    <div>
    <form method="post" action="receiveparam/test3.do">
        姓名：<input name="pname" value="路人"/> <br/>
        年龄：<input name="page" value="30"/><br/>
        <input type="submit" value="提交">
    </form>
    </div>
</fieldset>

<fieldset>
    <legend>案例4</legend>
    <div>当参数比较多的时候，可以使用1个对象来接收参数，表单中的参数和对象中的参数名称一一对应</div>
    <div>
    <form method="post" action="receiveparam/test4.do">
        姓名：<input name="name" value="路人"/> <br/>
        年龄：<input name="age" value="30"/><br/>
        <input type="submit" value="提交">
    </form>
    </div>
</fieldset>


<fieldset>
    <legend>案例5</legend>
    <div>也可以使用多个对象来接收参数</div>
    <div>
    <form method="post" action="receiveparam/test5.do">
        姓名：<input name="name" value="路人"/> <br/>
        年龄：<input name="age" value="30"/><br/>

        工作年限：<input name="workYears" value="10"/> <br/>
        年龄：<input name="workAddress" value="上海市"/><br/>
        <input type="submit" value="提交">
    </form>
    </div>
</fieldset>

<fieldset>
    <legend>案例6</legend>
    <div>复杂对象（对象中包含多个对象、集合等）</div>
    <div>
    <form method="post" action="receiveparam/test6.do">

        姓名：<input name="userInfo.name" value="路人"/> <br/>
        年龄：<input name="userInfo.age" value="30"/><br/>

        工作年限：<input name="workInfo.workYears" value="10"/> <br/>
        年龄：<input name="workInfo.workAddress" value="上海市"/><br/>

        第1份工作公司:<input name="experienceInfos[0].company" value="百度"/> <br/>
        第1份职位:<input name="experienceInfos[0].position" value="Java开发"/> <br/>

        第2份工作公司:<input name="experienceInfos[1].company" value="阿里"/> <br/>
        第2份职位:<input name="experienceInfos[1].position" value="Java资深开发"/> <br/>

        <input type="submit" value="提交">
    </form>
    </div>
</fieldset>

</body>
</html>
