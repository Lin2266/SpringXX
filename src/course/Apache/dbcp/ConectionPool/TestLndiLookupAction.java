package course.Apache.dbcp.ConectionPool;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestLndiLookupAction
 */
@WebServlet("/TestLndiLookupAction")
public class TestLndiLookupAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		request.setAttribute("emps",service.addThenFindAll(createEmp()));
		request.setAttribute("subject","My JNDI Lookup");
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
