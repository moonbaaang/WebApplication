package context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ContextServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = request.getServletContext();
		System.out.println("context1>>"+context );
		
		if(context.getAttribute("cnt")==null) {
			Integer count = new Integer(10);
			// 현재 서블릿과 동일 컨텍스트 존재 모든 서블릿 공유
			context.setAttribute("cnt", count);
			out.println("<h3> cnt속성을 공유했습니다. </h3>");
		}
		else {
			out.println("<h3> cnt속성을 공유했습니다. </h3>");
			out.println("<h3>"+context.getAttribute("cnt")+"</h3>");
			context.setAttribute("cnt", (Integer)context.getAttribute("cnt")+10);
		}
	
	}

}
