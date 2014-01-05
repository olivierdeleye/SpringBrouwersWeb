<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers op naam</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<a href="<c:url value='/'/>">Menu</a>
<h1>Brouwers op naam</h1>
 <c:url var='url' value='/brouwers/brouwersopnaam'/>
 <form:form action='${url}' method='get' commandName='beginVanNaamForm'>
  <form:label path='naam'>Begin van de naam:</form:label><form:errors path='naam' cssClass='fout'/>
  <form:input path='naam' type='text' autofocus='autofocus' />
  <input type='submit' value='Zoeken'/> 
  <form:errors cssClass='fout' element='div'/>
 </form:form>
 <c:if test="${not empty brouwers}">
  <c:forEach var='brouwer' items='${brouwers}'>
  <ul>
   <li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
  </ul>
  </c:forEach>
 </c:if>
</body>
</html>