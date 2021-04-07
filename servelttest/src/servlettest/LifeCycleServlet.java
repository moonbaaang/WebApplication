package servlettest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	
	
	@Override
	public void destroy() { //출력되지않음
		// TODO Auto-generated method stub
		System.out.println("destory 메소드 호출"); //tomcat서버 재컴파일 - 변경이전 서블릿 메모리 삭제 - 변경이후 메모리 할당 - init 다시 실행
	}

	@Override
	public void init() throws ServletException { //최초 한번 출력
		System.out.println("init 메소드 호출-수정ㄴㄴㅁㄴㅇㄴ"); //tomcat 서버 재컴파일 - 변경결과 브라우저 반환
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet메소드 호출");
	} //메인이 없지만 doGet메소드가 실행한다., 새로고침 시 실행

}
