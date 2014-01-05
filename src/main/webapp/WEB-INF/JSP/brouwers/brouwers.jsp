<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<a href="<c:url value='/'/>">Menu</a>
<h1>Alle brouwers</h1>
 <table>
  <thead>
   <tr><th>Nummer</th><th>Naam</th><th>Straat</th><th>HuisNr</th><th>Postcode</th>
       <th>Gemeente</th><th>Omzet</th>
   </tr>
  </thead>
  <tbody>
   <c:forEach items='${brouwers}' var='brouwer'>
    <tr>
     <td>${brouwer.brouwerNr}</td><td>${brouwer.naam}</td><td>${brouwer.adres.straat}</td><td>${brouwer.adres.huisNr}</td>
     <td>${brouwer.adres.postcode}</td><td>${brouwer.adres.gemeente}</td><td><fmt:formatNumber value='${brouwer.omzet}' minFractionDigits='2'/></td>
    </tr>
   </c:forEach>
  </tbody>
 </table>
</body>
</html>