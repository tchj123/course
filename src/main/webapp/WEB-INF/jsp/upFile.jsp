<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
<input type="text" name="ha"><br>
<input type="file" name="file">
<input type="submit" value="提交">
</form>
</body>
</html>