package mybatis;

import java.util.HashMap;
import java.util.List;

// 예 : 게시판 : 기능별 메소드 선언
public interface EmpService {
	public List<EmpVO> getEmpList();
	public EmpVO getEmpOne(int id);
	public List<EmpVO> getEmpName(String name);
	public List<EmpVO> getEmpWhere(int id);
	public void insertEmp(EmpVO vo);
	public void updateEmp(EmpVO vo);	
	public void deleteEmp(int id);
	public int getEmpCount();
	public List<EmpVO> getEmpPage(int [] ar);
	public void insertEmpWithSeq(EmpVO vo);
	public List<EmpVO> getEmpWithArray(int[] dept); 
	public void updateEmpWithMap
	(HashMap<String, String> map);
	public EmpVO getEmpWithResultMap();
	
}
