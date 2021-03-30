package course.spring.aop.show;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //啟動攔截並建立代理人物件，若xml檔則<aop:aspectj-autoproxy>
@ComponentScan
public class ShowConfig {
	//方法一啟動，2個aop都會觸發
	//@Bean //aop攔截
	public Audience audience() {
		return new Audience();
	}
	
	//@Bean //aop攔截，表示式重複使用
	public AudiencePointcut AudiencePointcut() {
		return new AudiencePointcut();
	}
	
	@Bean
	public AudienceAround audienceAround() {
		return new AudienceAround();
	}
	
	@Bean //觸發的方法
	public Show getShow() {
		return new ShowImpl();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ShowConfig.class);
		Show show = context.getBean(Show.class);
		try {
			show.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
