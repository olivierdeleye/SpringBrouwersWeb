<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%> 
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
<title>Menu</title>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<nav>
 <ul class='zonderbolletjes'>
 <security:authorize access='isAnonymous()'>
   <li><a href="<c:url value='/login'/>"><fmt:message key='aanmelden'/></a></li>
  </security:authorize>
  <security:authorize access='isAuthenticated()'>
    <security:authentication property='name' var='userName'/>
    <li><a href="<c:url value='/j_spring_security_logout'/>">
    <fmt:message key='afmelden'><fmt:param value='${userName}'/></fmt:message></a></li>
  </security:authorize>
  <security:authorize access="hasRole('user')">
    <li><a href="<c:url value='/brouwers'/>"><fmt:message key="alleBrouwers"/></a></li>
    <li><a href="<c:url value='/brouwers/brouwersopnaam'/>"><fmt:message key="brouwersOpNaam"/></a></li>
    <li><a href="<c:url value='/brouwers/brouwersopalfabet'/>"><fmt:message key="brouwersOpAlfabet"/></a></li>
  </security:authorize> 
  <security:authorize url="/brouwers/toevoegen">
   <li><a href="<c:url value='/brouwers/toevoegen'/>"><fmt:message key="brouwerToevoegen"/></a></li>
  </security:authorize>
 </ul>
</nav>
<fmt:message key='${groet}'/>  
 </body>
</html>