package course.spring.aop;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//告警的annoation設定
@Aspect 
public class AlertAnnotation {
	
	@Before("execution(* course.spring.Soldier.destroyTarget(..))")
	public void beforeAttack() {
		System.out.println("Before Attack....");
	}
	
	@After("execution(* course.spring.Soldier.destroyTarget(..))")
	public void afterAttack() {
		System.out.println("After Attack....");
	}
}
