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
//pageContext.setAttribute("share1", "1"); //현재jsp el 공유
request.setAttribute("share1", "10");
session.setAttribute("share1", "100");
application.setAttribute("share1", "1000");
%>

<h1>jsp 내장객체로 확인합니다.</h1>
<h3><%=pageContext.getAttribute("share1") %></h3>
<h3><%=request.getAttribute("share1") %></h3>
<h3><%=session.getAttribute("share1") %></h3>
<h3><%=application.getAttribute("share1") %></h3><br>
<hr>
<h1>el 내장객체로 확인합니다.</h1>
<h3>${pageScope.share1 }</h3>
<h3>${requestScope.share1 }</h3>
<h3>${sessionScope.share1 }</h3>
<h3>${applicationScope.share1 }</h3>

<%--<jsp:forward page="share2.jsp" /> --%>
</body>
</html>