<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/parentUserRegister" method="POST">


登陆名称：<input type="text" name="userName" required><br>
密码：<input type="password" name="password" required><br>
<input type="submit"  value="提交"><br>

</form>
</body>
</html>