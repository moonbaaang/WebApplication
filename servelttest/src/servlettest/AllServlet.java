package servlettest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jmx.snmp.Enumerated;

@WebServlet("/all")
public class AllServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getMethod().equals("POST")){
			//post일때만
		} else if(req.getMethod().equals("GET")) {
			//get일때만
		}
		// get + post 공동 처리
	}
/*
	private void method() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식일때만
		method();
	}

	protected void doPost
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//post방식일때만
		method();
	}
*/
	
} //class end
