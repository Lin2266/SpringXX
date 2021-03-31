package course.spring.aop.xmlShow;

import org.aspectj.lang.ProceedingJoinPoint;

public class AudienceAround {
	/*
	 * xml設定:
	 * 「Around」是一個功能相當強大的advice種類，因為它可以將目標物件的方法完整包含在內，好比將
	 * 「Befor」及「After」等2種合而為一。
	 * 
	 * 因某些因素，如權限或參數有誤，故意不讓目標物件的方法執行，類似使用web的Filter的request和response間
	 * 進行權限檢查，未通過則不呼叫FilterChain.doFilter()方法。
	 * 指定目標物件的方法的重複執行次數。
	 */

	public void aroundShow(ProceedingJoinPoint jp) {//繼續加入積分
		Audience audience = new Audience();
		try {
			audience.beQuiet();			//@Before			
			audience.leave();			//@After
			jp.proceed(); 				//繼續，此方法放這時，觸發的方法就會在這執行				
			audience.applause();		//@AfterReturning
		} catch (Throwable e) {
			//ShowImpl.java的throw new Exception註解拿掉就會執行到這裡
			audience.leave();			//@After
			audience.demandRefund();	//@AfterThrowing
		}
	}
}
