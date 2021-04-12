package course.Apache.dbcp.ConectionPool;

import java.util.List;
import javax.sql.DataSource;

public class EmployeeService {
	private EmployeeDaoJdbcImpl dao;
	
	//called by TestDataSourceFromScAtion
	public EmployeeService() {
		this.dao = new EmployeeDaoJdbcImpl();
	}
	
	public List<Employee> addThenFindAll(Employee e){
		dao.add(e);
		List<Employee> emps = dao.getAllEmployees();
		return emps;
	}

}
