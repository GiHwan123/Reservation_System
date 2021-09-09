<%@page import="model.dao.ResrvationDAO"%>
<%@page import="model.dto.Reservation"%>
<%@page import="model.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ResrvationDAO.addReservation(1l, "20210913");
%>   

</body>
</html>