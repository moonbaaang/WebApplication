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
$(document).ready(function(){

});
</script>
</head>
<body>
 <!-- getOriginalFilename()을 el표현식으로 변경 -->
<h1>${vo.file1.originalFilename } 파일과
${vo.file2.originalFilename } 파일을 전송하셨습니다.
</h1>
</body>
</html>