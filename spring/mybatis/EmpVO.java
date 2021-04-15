package mybatis;

public class EmpVO {//jdbc
	//employees 테이블 컬럼명 = 변수명 동일 : 데이터 저장
	// salary컬럼 = salary 변수 선언x
	int employee_id;
	String first_name;
	String last_name;// <-sql first_name합쳐서 fullname
	String job_id;
	String email;
	int department_id;
	String hire_date;
	String phone; //phone_number
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	@Override
	public String toString() {
		return employee_id + ":" + last_name + ","
		+ first_name + ":" + email + ":" 
		+ department_id + ":" + hire_date 
		+ ":" + job_id;
	}
	
	
}
