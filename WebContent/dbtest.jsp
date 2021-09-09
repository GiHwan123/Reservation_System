<%@page import="model.dao.ReservationDAO"%>
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
	ReservationDAO.addReservation(1l, "20210913");
%>   

</body>
</html>