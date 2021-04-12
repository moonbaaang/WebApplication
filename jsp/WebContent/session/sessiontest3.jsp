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
String session_id = (String)session.getAttribute("session_id"); 
out.println("내 이름 = "+session_id);
out.println("내 전화번호");
%>
</body>
</html>