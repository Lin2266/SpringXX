package course.spring.aop.lockable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ResourceLockAspect {
	@Pointcut("execution(* *.*.*.*.Resource.setContent(String)) && args(content)")
	public void setResourceContent(String content) {
		
	}
	/*
	 * 1.代理人:ResourceLockAspect。
	 * 2.被代理人:任何介面Resource的子類別，但不含介面Resource。
	 * 3.被介紹的委派人:必須實作介面Lockable，預設為類別LockableImpl。
	 * 
	 * @DeclareParents顧名思義為若滿足其value屬性值的類別，將自動宣告(Declare)父類別或介面(Parents)為
	 * 被標註的類別欄位型態，即介面Resource的子類別將被視同有實作介面Lockable
	 */
	@DeclareParents(value = "course.spring.aop.resource.Resource+",defaultImpl = LockableImpl.class)
	private Lockable lock;
	
	/*
	 * 必須使用AspectJ指定器「this()」搭配「execute()」，
	 * this(lockable)的()內字串必須同於beforeSetContent()方法的參數命名lockable。
	 * 同一參數的型態則必須和「@DeclareParents」標註的欄位型態一致為Lockable。
	 * 
	 * 代理人類別的Advise方法參數同時具有:
	 * 1.ProceedingJoinPoint	可決定「被代理人」物件的方法何時執行。
	 * 2.Lockable				可決定「被介紹的委派人」物件的方法何時執行。
	 * 
	 */
	@Around("setResourceContent(content) && this(lockable)")
	public void beforeSetContent(ProceedingJoinPoint joinPoint,Lockable lockable,String content) throws Throwable{
		System.out.println("@Aspect: check if resource is locked? " + lockable.isLocked());
		if(!lockable.isLocked()) {
			joinPoint.proceed();
			System.out.println("@Aspect: after set content: " + content);
		}else {
			System.out.println("@Aspect: The resource is locked and content setting is rejected!!");
		}
		System.out.println("------------------------------------------------------------------");
	}
		
}
