package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session1")
public class SessionServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청속에 세션포함 여부 판단하자
		//브라우저 열고 요청1 요청2 세션정보 확인
		//세션정보 서버측 저장 ,세션정보 사용가능 식별자 클라이언트 측 저장 (=세션 id는 쿠키 기술을 사용하여 저장JSESSIONID)
		String id = "none", pw = "none";
		
		HttpSession session = request.getSession();
		/*클라이언트 요청속에 세션 포함되어있으면 서버 요청한 적 있다.
		 * 세션 객체 생성이 필요없으니 기존 생성 세션 사용
		 * 아니면 서버 요청한적 없다.
		 * 세션객체 생성 
		 * */
		
		
		if(session.isNew()) {//클라이언트 요청속에 세션이 없다.= 서버측에 남긴 정보가 없다 = 최초요청)
//			session.setAttribute("id", "jdbc");
//			session.setAttribute("pw", "jdbc");
		
		}
		else {
			id = (String)session.getAttribute("id");
			pw = (String)session.getAttribute("pw");
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인="+id+":"+pw+"<br>");
		
	}

}


/*  1. 브라우저 열고 http://.../session1 실행
	2. 세션 2개 정보 저장
	3. /session2 실행
	4. 세션에 저장된 2개 정보 추출
	5. http://.../session1 실행
	6. 세션에 저장된 2개 정보 추출
	7. 브라우저를 닫음
	8. 브라우저를 열고 session2를 실행
	9. 세션 저장정보 없다. null
	

*/