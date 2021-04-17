package test.my.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping("/boardlist")
	public ModelAndView getAllBoard() {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> boardlist = service.getAllBoard();
		mv.addObject("boardlist", boardlist);
		mv.setViewName("board/list");
		return mv;
	}
	
	
	// url - /boarddetail
	// 매개변수 seq=게시물번호
	// 리턴타입 ModelAndView
	// 구현 - 현재 선택 글번호 게시글 조회수 1 증가 sql실행 (update)
	// 		현재 선택 글번호 게시글 조회
	// 뷰 이름 /board/detail.jsp - 테이블태그 1개 게시물 모든 컬럼 출력
	@RequestMapping("/boarddetail")
	public ModelAndView getDetailBoard() {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> boarddetail = service.getAllBoard();
		mv.addObject("boarddetail", boarddetail);
		mv.setViewName("board/detail");
		return mv;
	}
}
