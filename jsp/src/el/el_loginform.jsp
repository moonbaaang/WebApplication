<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.message }

<h1>로그인 폼</h1>
<form action='el_loginprocess.jsp' method='get'>
아이디입력: <input type=text name=id><br>
암호입력: <input type=password name=pw><br>
로그인 가능 장소:
<input type=checkbox name='location' value='집'>집
<input type=checkbox name='location' value='학교'>학교
<input type=checkbox name='location' value='회사'>회사
<input type=checkbox name='location' value='기타'>기타

<input type=submit value='로그인버튼'><br>
</form>
</body>
</html>