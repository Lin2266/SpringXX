package course.spring.aop.show;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AudienceAround {
	/*
	 * 使用@Around建立Around advice(通知):
	 * 「Around」是一個功能相當強大的advice種類，因為它可以將目標物件的方法完整包含在內，好比將
	 * 「Befor」及「After」等2種合而為一。
	 * 
	 * 因某些因素，如權限或參數有誤，故意不讓目標物件的方法執行，類似使用web的Filter的request和response間
	 * 進行權限檢查，未通過則不呼叫FilterChain.doFilter()方法。
	 * 指定目標物件的方法的重複執行次數。
	 */
	@Pointcut("execution(* course.spring.aop.show.Show.play(..))")
	public void playShow() {
		
	}
	
	@Around("playShow()") //包圍
	public void aroundShow(ProceedingJoinPoint jp) {//繼續加入積分
		AudiencePointcut audiencePointcut = new AudiencePointcut();
		try {
			audiencePointcut.beQuiet();			//@Before			
			audiencePointcut.leave();			//@After
			jp.proceed(); 						//繼續，此方法放這時，觸發的方法就會在這執行				
			audiencePointcut.applause();		//@AfterReturning
		} catch (Throwable e) {
			//ShowImpl.java的throw new Exception註解拿掉就會執行到這裡
			audiencePointcut.leave();			//@After
			audiencePointcut.demandRefund();	//@AfterThrowing
		}
	}
}
