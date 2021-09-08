<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% 	
	String url = application.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입완료 화면</title>
</head>
<body>
		Response.Write("<script>alert('<%=request.getAttribute("successMsg")%>');</script>");
		Response.Write("<script>location.href='main.html';</script>");
</body>
</html>