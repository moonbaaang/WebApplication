<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> share2 el 내장객체로 확인합니다.</h1>
<h3>${empty pageScope.share1 }</h3>
<h3>${requestScope.share2 }</h3>
<h3>${sessionScope.share3 }</h3>
<h3>${applicationScope.share4 }</h3>


</body>
</html>