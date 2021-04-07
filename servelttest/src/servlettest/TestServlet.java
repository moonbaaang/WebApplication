package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:9090/serveltTest/servlet/serveltTest.TestServlet
/* 1. 서블릿 클래스 정의
 * 2. 서블릿클래스 별칭 - 서블릿 이름으로 등록
 * 3. url 서블릿 이름 호출
 */

public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		PrintWriter out = response.getWriter();
		String msg ="Hello Servlet";
		out.println("<html><head><title>제목</title><body></head><body><h1>"+msg+"</h1></body></html>");
	}
}
