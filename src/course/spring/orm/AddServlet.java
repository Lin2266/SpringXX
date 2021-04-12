package course.spring.orm;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


@WebServlet(name="AddServlet",urlPatterns= {"/AddServlet"})
public class AddServlet extends HttpServlet {
	//注入物件
	@PersistenceContext
	EntityManager em;
	//注入UserTransaction物件
	@Resource
	UserTransaction utx;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	try {
		assert em != null;
		
		Employee e = new Employee();
		e.setId(1);
		e.setFirstname("firstname");
		e.setLastname("lastname");
		e.setBirthdate(new Date());
		e.setSalary(1000);
		
		//使用交易
		
			utx.begin();
			em.persist(e);
			utx.commit();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
	}

	

}
