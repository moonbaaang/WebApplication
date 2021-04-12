<%@page import="sun.security.mscapi.CKeyPairGenerator.RSA"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
id, pw, location 파라미터를 폼으로부터 post 방식으로 전송을 받는다.
id = jsp , pw = jsp 이면 정상적으로 로그인, 정상로그인이 되었으면 location 정보를 출력
id = jsp , pw = jsp 이면 정상적으로 로그인, 비정상로그인이 되었으면 loginform.jsp 리턴
_jspService 메소드 구현
jsp 내장 객체 제공 - 자동생성
request
response
session buffer application config exception
-->

<% 
	if(request.getMethod().equals("POST")){
		request.setCharacterEncoding("utf-8");			
	}
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id.equals("jsp") && pw.equals("jsp")){

	out.println("<h1>정상 로그인 되었습니다.</h1>");

	String [] locs = request.getParameterValues("location");
	for(String loc : locs){

	
		out.println("<h3>"+loc+"</h3>");		
		}
	}
	else{

	out.println("<a href='loginform.jsp'>로그인 폼으로 이동</a>");
	
	RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
	rd.forward(request, response);
	}
	
	//response.addCookie(new Cookie("c1","jsp"));
	//response.sendRedirect("http://daum.net");
%>
</body>
</html>