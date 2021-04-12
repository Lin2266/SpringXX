package course.Apache.dbcp.ConectionPool;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;


@WebServlet(name="EmployeeServlet",urlPatterns="/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource = new DataSource();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		Employee emp = new Employee();
		emp.setId(Integer.valueOf(request.getParameter("id")));//接收數字參數
		emp.setFirstName(request.getParameter("FirsName"));
		emp.setLastName(request.getParameter("LastName"));
		emp.setBirthDate(new Date());
		emp.setSalary(Float.valueOf(request.getParameter("Salary")));
		request.setAttribute("emps",service.addThenFindAll(emp));
		RequestDispatcher rd = request.getRequestDispatcher("/showEmps.jsp");
		rd.forward(request, response);
	}




}
