<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="dto" class="board.BoardDTO" scope="session"/> <!-- 반드시 이와같은 형식으로 만들어야한다. -->
<!-- 
if(request.getAttribute("dto"))==null) 
BoardDTO dto = new BoardDTO();
request.setAttribute("dto",dto);
} else{
dto = request.getAttribute("dto");
}
-->


<%-- 
<jsp:setProperty property="title" name="dto"
value="<%=request.getParameter(\"title\") %>"/>
<jsp:setProperty property="contents" name="dto"
value="<%=request.getParameter(\"contents\") %>"/>
<jsp:setProperty property="writer" name="dto"
value="<%=request.getParameter(\"writer\") %>"/>
<jsp:setProperty property="password" name="dto"
value="<%=Integer.parseInt(request.getParameter(\"password\")) %>"/>
--%>

<jsp:setProperty property="title" name="dto"/>
<jsp:setProperty property="contents" name="dto"/>
<jsp:setProperty property="writer" name="dto"/>
<jsp:setProperty property="password" name="dto"/>


<!-- 번호값 확인 : <jsp:getProperty property="seq" name="dto"/><br> <!-- get전용 property (getSeq와 같다) --> -->

제목 확인1 : <jsp:getProperty property="title" name="dto"/><br> 
내용 확인1 : <jsp:getProperty property="contents" name="dto"/> <br>
작성자 확인1 : <jsp:getProperty property="writer" name="dto"/> <br>
암호 확인1 : <jsp:getProperty property="password" name="dto"/> <br>

<!--<jsp:forward page="beantest2.jsp"/> scope="request" 일때 필요한 것 -->
</body>
</html>


<!-- <%=dto.getSeq() %>  -->
<!-- out.println(dto.getSeq()); -->