<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function() {

});
</script>
</head>
<body>
<h1>  제 홈페이지의 첫화면입니다. </h1>
<a href="<%=request.getContextPath() %>/crud/list"> 게시물리스트보러가기</a><br>
<a href="<%=request.getContextPath() %>/crud/add"> 게시물작성하러가기</a><br>
<a href="<%=request.getContextPath() %>/crud/update"> 게시물수정하러가기</a><br>
<a href="<%=request.getContextPath() %>/crud/delete"> 게시물삭제하러가기</a><br>
</body>
</html>