<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/playdata.css">
</head>
<body>

<header>
  <jsp:include page="../common/header.jsp"/>
</header>

<section>
  <nav>
    <ul>
    <li><a href="mypage/mypage.jsp">기본정보</a></li>
      <li><a href="../reservation?command=selectallreservation">예약내역 확인</a></li>
      <li><a href="mypage/paris.jsp">회원 정보 수정</a></li>
      <li><a href="mypage/seoul.jsp">예약변경</a></li>
</ul>
  </nav>
  
  <article>
    <table border="1">
	<thead>
		<tr>
			<th>예약번호</th><th>예약시간</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.All}" var="data">
		 <tr>
		 	<td>${data.reservationNumber}</td>
		 	<td>${data.resDate}</td>
		 </tr>
	 </c:forEach>

</table>
  </article>
</section>

<footer>
 	<ul>
<li><a href="loginmain.html">메인으로 이동</a></li>
</ul>
</footer>

</body>
</html>
