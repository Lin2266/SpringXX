package course.Apache.dbcp.ConectionPool;

import org.apache.tomcat.jdbc.pool.DataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet("/TestDataSourceFromScAtion")
public class TestDataSourceFromScAtion extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get connection pool
		//Object o = request.getServletContext().getAttribute("WeStartListener.DB");
		//DataSource ds = (DataSource)o;
		//pass connection pool to DAO, through service
		EmployeeService service = new EmployeeService();
		//call service
		List<Employee> emps = service.addThenFindAll(createEmp());
		//dispatch request
		request.setAttribute("emps",emps);
		request.setAttribute("subject","from Service Context");
		RequestDispatcher rd = request.getRequestDispatcher("/showEmps.jsp");
		rd.forward(request, response);
		
	}
	
	private Employee createEmp() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("test");
		emp.setLastName("test");
		emp.setBirthDate(new Date());
		emp.setSalary(10000.1f);
		return emp;
	}

	
}
