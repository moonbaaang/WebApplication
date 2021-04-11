package context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// p.287~289 
@WebServlet("/context3")
public class ContextServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//web.xml의 context-param 메뉴를 입력
		ServletContext context = request.getServletContext();
		String menu = context.getInitParameter("menu"); //web.xml의 menu를 불러오는것
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+menu+"</h3>");
	}

}
