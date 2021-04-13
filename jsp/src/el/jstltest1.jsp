<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
${ i=10 }
<%=pageContext.getAttribute("i") %>

<%=pageContext.setAttribute("ii", 100) %>
%{ii }
--%>

<% String i= "jsp"; %>
<c:set var="name" value="<%=i %>" />

<h1>${name }</h1>
<h1><c:out value="<%=i %>" /></h1>
<c:remove var="name"/>
<h1>${empty name }</h1>
</body>
</html>