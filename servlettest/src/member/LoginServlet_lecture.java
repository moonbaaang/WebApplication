package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*<form action="login">
  아이디입력 : <input type=text name=id><br>
 암호입력 : <input type=password name=pw><br> */

@WebServlet("/loginlec")
public class LoginServlet_lecture extends HttpServlet {
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		login(request, response);
	}
	
	protected void doPost
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		request.setCharacterEncoding("utf-8");
		login(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		//브라우저에서 한글 입력시 인코딩
		//get url?한글인코딩자동설정
		//post url + [데이터들]
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
		}
		//요청 정보 추출 id,pw 전송 - 입력
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] locations = request.getParameterValues("location");//모든 선택
		
		// 로그인 처리- id=user , pw=1234 정상 로그인되었습니다 응답
		String result = "";
		if(id.equals("user") && pw.equals("1234")) {
			result = "<h3 style=color:green >정상 로그인되었습니다</h3>";
		}
		else {
			result = "<h3 style=color:red >비정상 로그인되었습니다</h3>";
			result += "<h3><a href='loginform.html'> 로그인창으로 이동</a></h3>";
		}
	 //  서블릿이 응답 	결과 브라우저 출력 text/html - mime type 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);//클라이언트 브라우저
		System.out.println(result);// 서버 콘솔 
		
		o.println("<h3>선택한 장소는 다음과 같습니다</h3>");
		 for(String loc : locations) {
			 o.println(loc + "<br>");
		 }
		

		 
	}//login end

}//class end




