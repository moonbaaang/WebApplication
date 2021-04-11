package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDTO;


@WebServlet("/session5")
public class SessionServlet5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		
		HttpSession session = request.getSession();

		if(session.getAttribute("member")!=null) {
			//삭제 방법
			//session.removeAttribute("member"); //속성단위로 없앤다
			session.invalidate(); // 세션 자체를 날린다.
			// 브라우저를 종료 시 자동 삭제한다.
			// Servers\...web.xml
			// > 프로젝트 단위 - servlettest\webcontent\web-inf\web.xml 
			// 세션 브라우저 종료 이전 30분동안 액션이 없다면 자동 삭제
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+dto+"<br>");
		
	}

}
