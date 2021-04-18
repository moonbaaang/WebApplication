package spring_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	//employees  테이블 전체 조회
	@RequestMapping("/emplist")
	public ModelAndView  getEmpList(){
		//mybatis SqlSession--EmpDAO--EmpService하위-
		List<EmpVO> list = service.getAllEmp();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", list);
		//request.getAttirbute("emplist")  ${emplist}
		mv.setViewName("/mybatis/emplist");//WEB-INF/views/mybatis/emplist.jsp
		return mv;
		
	}
	//클라이언트 입력 id 파라미터 
	//  /empdetail url 
	//employees  테이블  - 1개 레코드 조회
	//model 로 생성
	// /mybatis/empdetail.jsp
	// empdetail.jsp 출력
	
	
	
	
	//추가 수정 삭제
	
}
