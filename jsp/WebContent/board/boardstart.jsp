<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td{border:2px solid green}
table{margin:2}
</style>
</head>
<body>

<%
ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
%>

<table>
<%
	for(int i=0 ; i<list.size() ; i++){ //tr태그
%>
<tr>
	<td><%=list.get(i).getSeq() %></td>
	<td><%=list.get(i).getTitle() %></td>
	<td><%=list.get(i).getWriter() %></td>
	<td><%=list.get(i).getViewcount() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>