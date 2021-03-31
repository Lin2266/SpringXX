package course.spring.aop.xmlShow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("course\\spring\\aop\\xmlShow\\showAudience.xml");
		Show show = context.getBean(Show.class);
		try {
			show.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
