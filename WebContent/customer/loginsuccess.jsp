<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
		Response.Write("<script>alert('<%=session.getAttribute("id") %> 님 환영합니다.');</script>");
		Response.Write("<script>location.href='loginmain.html';</script>");
</body>
</html>