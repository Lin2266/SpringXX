package course.spring.JDBCTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WithSpring {

	public static void main(String[] args) {
		String ctxClassPath = "course/spring/JDBCTemplate/ApplicationContext.xml";
		//載入時指定位於classpath上的xml設定檔
		ApplicationContext	clsContext = new ClassPathXmlApplicationContext(ctxClassPath);
		EmployeeDao dao1 = clsContext.getBean(EmployeeDao.class);
		System.out.println(dao1.getEmployeeById(2));

	}

}
