package mybatis;

import java.util.HashMap;
import java.util.List;

public class EmpServiceImpl implements EmpService {

	EmpDAO dao;
		
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmpVO> getEmpList() {
		//EmpDAO getEmpList 메소드 일임
		List<EmpVO> list = dao.getEmpList();
		return list;
	}

	@Override
	public EmpVO getEmpOne(int id) {
		return dao.getEmpOne(id);
	}

	@Override
	public List<EmpVO> getEmpName(String name) {
		return dao.getEmpName(name);
	}

	@Override
	public List<EmpVO> getEmpWhere(int id) {
		return dao.getEmpWhere(id);// "<="
	}

	@Override
	public void insertEmp(EmpVO vo) {
		// main(입력-출력) - service(1개 기능 처리 메소드)
		//DAO (1개 SQL 처리 메소드) - (jdbc or mybatis) - db
		//중복 사번 검사
		//EmpVO resultvo = dao.getEmpOne(vo.getEmployee_id());
		dao.insertEmp(vo);
	}

	@Override
	public void updateEmp(EmpVO vo) {
		dao.updateEmp(vo);
		//vo.employee_id, vo.last_name, vo.department_id
	}

	@Override
	public void deleteEmp(int id) {
		dao.deleteHistroy(id);
		dao.deleteEmp(id);
	}

	@Override
	public int getEmpCount() {
		return dao.getEmpCount();
	}

	@Override
	public List<EmpVO> getEmpPage(int[] ar) {
		return dao.getEmpPage(ar);
	}

	@Override
	public void insertEmpWithSeq(EmpVO vo) {
		dao.insertEmpWithSeq(vo);
	}

	@Override
	public List<EmpVO> getEmpWithArray(int[] dept) {
		return dao.getEmpWithArray(dept);
	}

	@Override
	public void updateEmpWithMap(HashMap<String, String> map) {
		dao.updateEmpWithMap(map);
		
	}

	@Override
	public EmpVO getEmpWithResultMap() {
		return dao.getEmpWithResultMap();
	}
	

}




