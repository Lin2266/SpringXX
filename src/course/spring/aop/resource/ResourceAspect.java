package course.spring.aop.resource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ResourceAspect {
	//使用AspectJ指定器args()搭配execute()攔截方法參數。
	//args(content1)指定方法名稱，並配合setResourceContent()的方法參數名稱content1，execute()指定方法參數型態String
	@Pointcut("execution(* course.spring.aop.resource.Resource.setContent(String)) && args(content1)")
	public void setResourceContent(String content1) {
		
	}
	
	
	@Before("setResourceContent(content0)")
	public void beforeSetContent(String content0) {
		System.out.println("@Aspect: before set content: " + content0);
	}

}
