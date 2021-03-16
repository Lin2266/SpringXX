package course.spring.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"course/spring/lifeCycle/ApplicationContext.xml");
		SimpleBean bean = context.getBean(SimpleBean.class);
		bean.getMessage();
		//若取消這行，即未明確結束spring，destroy()跟myDestroy()方法不會被spring調用
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
