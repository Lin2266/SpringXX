package course.spring.aop.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ResourceAspectConfig {
	@Bean
	public Resource createResource() {
		return new ResourceImpl();
	}
	
	@Bean
	public ResourceAspect createResourceAspect() {
		return new ResourceAspect();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ResourceAspectConfig.class);
		Resource resource = context.getBean(Resource.class);
		resource.setContent("Hi, Jim!!");
	}
}
