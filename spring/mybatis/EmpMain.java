package mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.net.httpserver.Authenticator.Result;

public class EmpMain {

public static void main(String[] args) throws Exception {
	SqlSessionFactoryBuilder builder
	= new SqlSessionFactoryBuilder();
	
	//db con 여러개 생성 - pool = DataSource 
	SqlSessionFactory factory = 
			builder.build(
	 Resources.getResourceAsReader
	 ("mybatis/db-config.xml")
	 );
	// servlet,jsp 환경= session브라우저
	// jdbc connection = mybatis session
	SqlSession session = factory.openSession(true);
	System.out.println
	(session.getConnection().getAutoCommit());//true, false
	
	//EmpServiceImpl : getEmpList()-EmpDAO :  getEmpList()
	
	EmpDAO dao = new EmpDAO();//mybatis sql 작업
	dao.setSession(session);
	
	EmpService service = new EmpServiceImpl();
	((EmpServiceImpl)service).setDao(dao);
	
	//test1 : 모든 레코드 조회
/*	List<EmpVO> list = service.getEmpList();
	for(EmpVO vo : list) {
		System.out.println
		(vo.getEmployee_id()+":"+vo.getFirst_name());
	}*/
	
	//test2 : 1개 레코드 조회(employee_id : pk)
/*	EmpVO vo = service.getEmpOne(100);
	System.out.println(vo);
*/	
	
	//TEST3 : first_name = 'William' : 여러명
	//first_name William 사원의 정보 출력
	//EmpService, EmpServiceImpl, EmpDAO, SQL-MAPPING.XML
/*	List<EmpVO> list = service.getEmpName("William");
	for( EmpVO vo2 : list) {
		System.out.println(vo2);//사번, 성, 이름 출력	
	}*/
	
	//test4 : <![CDATA [.....]] > 영역 sql 저장
/*	List<EmpVO> list = service.getEmpWhere(150);
	for( EmpVO vo2 : list) {
		System.out.println(vo2);	
	}	*/
	
	//test5 : EmpVO 개체 INSERT
/*	EmpVO vo = new EmpVO();
	vo.setEmployee_id(1001);//pk
	vo.setLast_name("홍");
	//vo.setFirst_name("길동");
	vo.setEmail("hongmybatis1@kitri.com");//unique
	vo.setJob_id("IT_PROG");//jobs 테이블 참조
	vo.setDepartment_id(50);//departments 테이블 참조
	
	service.insertEmp(vo);
	//session.commit();
	System.out.println("===insert 완료===");*/

	//test6 : EmpVO 개체 update
/*	EmpVO vo = new EmpVO();
	vo.setEmployee_id(1000);
	vo.setLast_name("이");
	vo.setDepartment_id(80);//departments 테이블 참조
	service.updateEmp(vo);
	System.out.println("===update 완료===");
	
	EmpVO updatevo = service.getEmpOne(vo.getEmployee_id());
	System.out.println(updatevo);// 50-80  홍-이 변경*/
	
	//test7 : 1000 사번 회사원 delete
	// 1. job_history 1000 사번 삭제
	// 2. employees 1000 사번 삭제
/*	service.deleteEmp(1000);
	System.out.println("===delete 완료===");	*/
	
	//select : 1 or n 
	//insert, delete, update : 제약조건 위배되지 않는 값 
	//                         조회 먼저 선행, 다른 테이블 자식 데이터 삭제 선행
    //  factory.opensession(true)
	// factory.opensession() + sql 실행 + session.commit()
	
	// employees 사원 목록 나열 : 한페이지에 10명
	/* 
	 * <select id="cnt" resultType="int"  
	 * select count(*) from employees 
	 */
	//test8 : 전체 갯수
/*	int totalEmp = service.getEmpCount();
	System.out.println(totalEmp); */

	//107 : 1페이지당 10개씩 출력 : 1-11
	
	// test9 : 페이징처리 만약 5페이지 선택
/*	int currentpage = Integer.parseInt(args[0]);
	int start = (currentpage-1)*10 + 1;//41
	int end = currentpage * 10;//50
    int rownums[] = new int[2];
    rownums[0] = start;
    rownums[1] = end;
    List<EmpVO> list = service.getEmpPage(rownums);
    for(EmpVO vo2:list) {
    	System.out.println(vo2);
    }*/
	
	//test10 : sequence 이용 insert
/*	EmpVO vo = new EmpVO();
	//vo.setEmployee_id(2000);
	vo.setLast_name("김");//not null
	vo.setJob_id("IT_PROG");//jobs테이블 참조
	vo.setDepartment_id(100);//departments테이블 참조
	vo.setEmail("kim@kitri.com");//unique
	service.insertEmpWithSeq(vo);
	System.out.println("===insert seq 완료===");*/
	
	//test11 : 배열 파라미터
/*	int[] dept = {50, 80};
	List<EmpVO> list = service.getEmpWithArray(dept);
	for(EmpVO vo2 : list) {
		System.out.println(vo2.getDepartment_id());
	}*/
	
	//test12 : 리스트 파라미터
//	ArrayList<Integer> deptlist = 
//			new ArrayList<Integer>();
//	deptlist.add(100);
//	deptlist.add(200);	
//	deptlist.add(10);	
	
	//test13: map 파라미터 
	//리스트나 배열 : {10, 20, 30}--> get(0)->10
	//맵 : {"dept","인사부"}, {"이메일","kiti.com"}--> get("dept")
/*	HashMap<String, String> map = 
			new HashMap<String, String>();
			map.put("deptid", "50");
			//map.put("emp_id", "303");
			map.put("email", "lee@a.com");
	service.updateEmpWithMap(map);	
	System.out.println("===update완료===");*/

	EmpVO resultmapvo = service.getEmpWithResultMap();
	System.out.println
	(resultmapvo.getLast_name() + ":" +
	resultmapvo.getPhone());
}
}




