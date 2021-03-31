package course.spring.aop.xmlLockable;

import org.aspectj.lang.ProceedingJoinPoint;

public class ResourceLockAspect {

	public void beforeSetContent(ProceedingJoinPoint joinPoint,Lockable lockable,String content) throws Throwable{
		System.out.println("@Aspect: check if resource is locked? " + lockable.isLocked());
		if(!lockable.isLocked()) {
			joinPoint.proceed();//執行觸發方法Resource.setContent(String)
			System.out.println("@Aspect: after set content: " + content);
		}else {
			System.out.println("@Aspect: The resource is locked and content setting is rejected!!");
		}
		System.out.println("------------------------------------------------------------------");
	}
		
}
