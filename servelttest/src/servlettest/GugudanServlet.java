package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gugu")
public class GugudanServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		
		String dan = request.getParameter("dan");
		int outputdan = 0;
		//3> 입력값 없음 기본 2단만 출력
		if(dan == null || dan.equals("")) {
			outputdan  = 2;
		}
		else {
			int dan2 = Integer.parseInt(dan);
			if(dan2 >= 2 && dan2 <=9) {
				outputdan  = dan2;
			}
			else {
				outputdan = 10;
			}
		}
		String format = "";
		
		format = "<h1>구구단 </h1>";
		format += "<form action='gugu' method='post'>";
		format += " 단 : <input type=text name='dan'>  <input type=submit value='구구단출력'>";
		format += "</form>";
		
		if(outputdan != 10) {
			format += "<table border=3>";
			for(int i = 1; i <= 9; i++) {
				format += "<tr><td>" + outputdan + " * " + i + " = " + (outputdan*i) + "</td></tr>";
			}			
			format +=  "</table>";
		}
		else {
			//9행 8열 테이블
			format = "<table border=3>";
			for(int i = 1; i <= 9; i++) {//9행
				format += "<tr>";
				for(int j = 2; j <= 9; j++) {//8열
					format += "<td>" + j + " * " + i + " = " + (j*i) + "</td>";
				}
				format += "</tr>";
			}
			format +=  "</table>";
		}
		format += "<a href='gugudan.html'> 구구단 입력 </a>";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(format);
		
		//1> 사용자입력단만 (2-9단 사이면)출력-테이블
		//2>1, 0, -1, 20(2-9단 사이가 아니면) : 2-9단까지 모든 출력 테이블 

	}

}




