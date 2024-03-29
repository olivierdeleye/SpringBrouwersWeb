<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers op naam ${param.letter}</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<a href="<c:url value='/'/>">Menu</a>
<h1>Brouwers op alfabet ${empty param.letter ? "" : param.letter}</h1>
 <ul class="zonderbolletjes">
  <c:forEach items="${alfabet}" var="letter">
   <c:url value="/brouwers" var="letterURL">
    <c:param name="letter" value="${letter}"/>
   </c:url>
   <li><a href="${letterURL}">${letter}</a></li>
  </c:forEach>
 </ul>
 <c:if test="${not empty brouwers}">
 <ul>
  <c:forEach items="${brouwers}" var="brouwer">
   <li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
  </c:forEach>
 </ul>
</c:if>
</body>
</html>