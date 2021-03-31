package course.spring.aop.xmlResource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import course.spring.aop.resource.Resource;

public class ResourceMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("course\\spring\\aop\\xmlResource\\resource.xml");
		Resource resource = context.getBean(Resource.class);
		resource.setContent("Hi, Jim!!");

	}

}
