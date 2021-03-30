package course.spring.aop.show;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//使用@Aspect 讓類別Audience成為Aspect物件
@Aspect
public class Audience { //聽眾
	//藉由在表演(Show)的過程中，聽眾(Audience)可能在表演前、後進行的動作，來呈現AOP使用的方法。
	//先後順序:Before - play() - AfterReturning(正常)或AfterThrowing(不正常) - After
	
	//攔截時間成在方法play執行「前」
	//使用PointCut(切入點)表示execution(* course.spring.aop.show.Show.play(..)指定要攔截的方法
	@Before("execution(* course.spring.aop.show.Show.play(..))") //之前執行
	public void beQuiet() { //安靜
		System.out.println("Silencing cell phones."); //靜音手機
	}
	
	//表示只在方法「正常結束(return)」才攔截
	@AfterReturning("execution(* course.spring.aop.show.Show.play(..))") //退貨後
	public void applause() { //掌聲
		System.out.println("Good show!!");
	}
	
	//表示只在方法「未正常結束(exception)」才攔截
	@AfterThrowing("execution(* course.spring.aop.show.Show.play(..))") //投擲後
	public void demandRefund() {
		System.out.println("Demanding a refund!!"); //要求退款
	}
	
	//攔截時間點在方法play執行「後」，而且不論方法正常結束與否
	@After("execution(* course.spring.aop.show.Show.play(..))") //之後
	public void leave() { //離開
		System.out.println("The show ends.");
	}
}
