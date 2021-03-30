package course.spring.aop.show;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudiencePointcut {
	//避免表示式重複定義，藉由這個方法定義@Pointcut表示式，讓表示式可以在其它方法重複使用
	@Pointcut("execution(* course.spring.aop.show.Show.play(..))")
	public void playShow() {
		
	}
	
	@Before("playShow()") //之前執行
	public void beQuiet() { //安靜
		System.out.println("AudiencePointcut:Silencing cell phones."); //靜音手機
	}
	
	//表示只在方法「正常結束(return)」才攔截
	@AfterReturning("playShow()") //退貨後
	public void applause() { //掌聲
		System.out.println("AudiencePointcut:Good show!!");
	}
	
	//表示只在方法「未正常結束(exception)」才攔截
	@AfterThrowing("playShow()") //投擲後
	public void demandRefund() {
		System.out.println("AudiencePointcut:Demanding a refund!!"); //要求退款
	}
	
	//攔截時間點在方法執行「後」，而且不論方法正常結束與否
	@After("playShow()") //之後
	public void leave() { //離開
		System.out.println("AudiencePointcut:The show ends.");
	}
}
