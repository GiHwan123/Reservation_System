<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>
		Response.Write("<script>alert('id 혹은 패스워드가 일치하지 않습니다. 다시 확인해주세요.');</script>");
		Response.Write("<script>location.href='customer/login.html';</script>");
</body>
</html>