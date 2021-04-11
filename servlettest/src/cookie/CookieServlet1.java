package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class CookieServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//id - jdbc, pw - program
		Cookie c1 = new Cookie("id", "jdbc"); // 쿠키문자열 - 영문자 숫자
		// ("id", java.net.URLEncoder.encode("한글", "utf-8"); 이러한 식으로 한글 전송 가능
		Cookie c2 = new Cookie("pw", "jdbc"); // 실제로 암호는 쿠키로 전송하면 안된다.
		// 브라우저 종료 이후 얼마 동안 지속할지 설정(초단위)
		c1.setMaxAge(60*60*24);
		c2.setMaxAge(60*60*24);
		//c1.setMaxAge(-1); 브라우저 종료시
	
		//클라이언트 전송
		response.addCookie(c1);
		response.addCookie(c2);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(c1.getName()+"="+c1.getValue());
		o.println(c2.getName()+"="+c2.getValue());
		o.println("위와같은 쿠키를 클라이언트로 전송했습니다.");
	}


}
