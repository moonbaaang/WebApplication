package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session2")
public class SessionServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청속에 세션포함 여부 판단하자
		//브라우저 열고 요청1 요청2 세션정보 확인
		//세션정보 서버측 저장 ,세션정보 사용가능 식별자 클라이언트 측 저장 (=세션 id는 쿠키 기술을 사용하여 저장JSESSIONID)
		String id = "none";
		String pw = "none";
		
		HttpSession session = request.getSession();
		
		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");

		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+id+":"+pw+"<br>");
		
	}

}
