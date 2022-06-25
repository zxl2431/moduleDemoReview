<%--
  Created by IntelliJ IDEA.
  User: zhangxianlin
  Date: 2022/6/25
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/IllegalServlet">
    请发表你的言论：<input type="text" name="message">
    <input type="submit" value="提交">
</form>
</body>
</html>