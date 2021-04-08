package forward;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;


@WebServlet("/board1")
public class BoardServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int pagenum = Integer.parseInt(request.getParameter("page"));
			BoardDAO dao = new BoardDAO();
			ArrayList<BoardDTO> list = dao.getBoardList(pagenum, 5);
			
			// 출력 1 table태그 - forward.BoardServlet2.java (board2 url)
			// board2 서블릿 호출. list전달 
			// 전달받은 list를 table태그로 출려가
			
			
			// 출력 2 ul ol li 태그 forward.BoardServlet2.java (board3 url)
			
	}

}
