package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardwrite")
public class BoardInsertServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		BoardDAO dao = new BoardDAO();
		
		//writer 가 member에 존재하는 id일 때 글쓰기 진행
		String result="";
		boolean memberResult = dao.getMember(writer);
		if(memberResult) {
			BoardDTO dto = new BoardDTO();
			
			dto.setTitle(title);
			dto.setContents(contents);
			dto.setWriter(writer);
			dto.setPassword(Integer.parseInt(password));			
	
			result += "<h1>글쓰기완료</h1>";
			result +="<a href='boardlist?page=1'>리스트로 이동</a>";
		}
		else {
			result = "<h1>회원가입이 필요합니다.</h1>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
