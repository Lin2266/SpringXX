package course.spring.aop.xmlShow;

/*
 * AOP(Aspect-Oriented-Programming)面向切面編程:
   在不同的商業邏輯流程中，會有一些固定或雷同的程式碼不斷出現，它們和商業邏輯無關，但影響程式的執行，稱為「橫切關注」，
   通常是一些「輔助功能」，如交易(transaction)、日誌記錄(logging)、權限控管(security)等。
   
   Aspect元件就是代理人，bean元件就是被代理人，必須一起實作相同的interface。
*/
// showAudience.xml設定
public class Audience { //聽眾
	//藉由在表演(Show)的過程中，聽眾(Audience)可能在表演前、後進行的動作，來呈現AOP使用的方法。
	//先後順序:Before - play() - AfterReturning(正常)或AfterThrowing(不正常) - After
	
	//攔截時間成在方法play執行「前」	
	public void beQuiet() { //安靜
		System.out.println("Audience:Silencing cell phones."); //靜音手機
	}
	
	//表示只在方法「正常結束(return)」才攔截
	public void applause() { //掌聲
		System.out.println("Audience:Good show!!");
	}
	
	//表示只在方法「未正常結束(exception)」才攔截
	public void demandRefund() {
		System.out.println("Audience:Demanding a refund!!"); //要求退款
	}
	
	//攔截時間點在方法play執行「後」，而且不論方法正常結束與否
	public void leave() { //離開
		System.out.println("Audience:The show ends.");
	}
}
