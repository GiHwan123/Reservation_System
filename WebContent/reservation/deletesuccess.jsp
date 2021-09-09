<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 실패</title>
</head>
<body>
		Response.Write("<script>alert('<%=session.getAttribute("id") %> 님  <%= request.getParameter("CheckIn")%> 날짜의 예약이 취소되었습니다.')</script>");
		Response.Write("<script>location.href='loginmain.html';</script>");
</body>
</html>