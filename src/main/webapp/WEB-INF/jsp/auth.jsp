<%@ page language="java" contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>        

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>权限审核</title>
</head>
<body>
<form>
教师申请表:<br><br><br><br>
1.姓名：tchj 身份证号码：123456  <a href="${pageContext.request.contextPath}/">详细信息</a> 
<input type="button" value="同意申请 " onclick="">
<input type="button" value="拒绝申请 " onclick="">
<br>
2.姓名：wzl 身份证号码：123456  <a href="${pageContext.request.contextPath}/">详细信息</a> 
<input type="button" value="同意申请 " onclick="">
<input type="button" value="拒绝申请 " onclick="">
<br>
共${totalPage} 页  &nbsp
跳转至第<input type="text">页  
<input type="button" value="跳转 " formaction="">&nbsp&nbsp
当前是第${page} 页<br>

<input type="button" value="首页 " onclick="">
<input type="button" value="上一页" onclick="">
<input type="button" value="下一页 " onclick="">
<input type="button" value="尾页 " onclick=""><br>

</form>
</body>
</html>