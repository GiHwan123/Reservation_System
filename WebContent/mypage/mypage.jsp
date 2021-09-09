<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/playdata.css">
</head>
<body>

<header>
  <jsp:include page="../common/header.jsp"/>
</header>

<section>
  <nav>
    <jsp:include page="../common/nav.jsp" />
  </nav>
  
  <article>
   	 <h2>사용자 id : <%=session.getAttribute("id") %></h2><br>
  	<h2>사용자 password :  <%=session.getAttribute("pw") %></h2><br>
  </article>
</section>

<footer>
 	<jsp:include page="../common/footer.jsp" />
</footer>

</body>
</html>