<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
		Response.Write("<script>alert('<%=session.getAttribute("id") %> 로그아웃');</script>");
		<%session.invalidate(); %>
		Response.Write("<script>location.href='../main.html';</script>");
</body>
</html>