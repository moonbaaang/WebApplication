package mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {
	
	SqlSession session;//mybatis dbconnection 
		
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<EmpVO> getEmpList(){
		//sql 정의 -sql-mapping.xml -- 호출 실행 요청 
	    //emp.empall
		List<EmpVO> list=session.selectList("emp.empall");
		return list;
	}
	/*<select id="empone" resultType="emp" 
	parameterType="int">
		select * from employees where employee_id=#{id}
	</select>*/
	public EmpVO getEmpOne(int id){
		EmpVO vo = session.selectOne("emp.empone" , id);
		return vo;
	}

	public List<EmpVO> getEmpName(String name){
		//1 or 0 or n
		List<EmpVO> list = session.selectList("emp.empname" , name);
		return list;
	}	
	
	public List<EmpVO> getEmpWhere(int id){
		return session.selectList("emp.empwhere", id);
	}
	
	public void insertEmp(EmpVO vo) {
		session.insert("emp.insertemp", vo);
	}
	
	public void updateEmp(EmpVO vo) {
		session.update("emp.updateemp", vo);
	}
	
	//dao - 메소드 - mapping sql 1개 실행
	public void deleteHistroy(int id) {
		session.delete("emp.deletehistory", id);
	}

	public void deleteEmp(int id) {
		session.delete("emp.deleteemp", id);
	}
	
	public int getEmpCount() {
		return session.selectOne("emp.cntemp");
	}
	
	public List<EmpVO> getEmpPage(int[] ar){
		return session.selectList("emp.emppage", ar);
	}
	
	public void insertEmpWithSeq(EmpVO vo) {
		session.insert("emp.insertempwithseq", vo);
	}
	
	public List<EmpVO> getEmpWithArray(int[] dept){
		return 
		session.selectList("emp.empwitharray", dept);
	}
	
	public void updateEmpWithMap
	(HashMap<String, String> map) {
		session.update("emp.updateempwithmap", map);
	}
	
	public EmpVO getEmpWithResultMap() {
		return session.selectOne("emp.empwithresultmap");
	}
}






