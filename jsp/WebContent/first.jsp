<%@ page contentType="text/html; charset=UTF-8"
import="java.util.Date"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<h1>jsp 파일입니다</h1>
<h3>실행시각은 
<% 
	Date now = new Date();
	out.println(now);
%>
입니다.</h3>
</body>
</html>