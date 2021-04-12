<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% String name=request.getParameter("img"); %>
<body>
<img src="<%=name%>" width=300 height=300 >
<%=name %>
</body>
</html>