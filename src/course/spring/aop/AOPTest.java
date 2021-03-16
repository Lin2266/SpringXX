package course.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import course.spring.Soldier;
import course.spring.di.SoldierConfig;

public class AOPTest {

	public static void main(String[] args) {
		//aop的Aspect用annotation設定
				ApplicationContext context = new AnnotationConfigApplicationContext(SoldierConfig.class);
				Soldier soldier = context.getBean(Soldier.class);
				soldier.destroyTarget();

	}

}
