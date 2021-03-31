package course.spring.aop.lockable;

import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import course.spring.aop.resource.Resource;
import course.spring.aop.resource.ResourceImpl;

@Configuration
@EnableAspectJAutoProxy
public class ResourceLockAspectConfig {
	@Bean
	public Resource createResource() {
		return new ResourceImpl();
	}
	
	@Bean
	public Lockable createLock() {
		return new LockableImpl();
	}
	
	@Bean
	public ResourceLockAspect createResourceLockAspect() {
		return new ResourceLockAspect();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ResourceLockAspectConfig.class);
		Resource resource = context.getBean(Resource.class);
		resource.setContent("Hi, Jim!!");//觸發方法1
		//lock預設為false
		
		/*
		 * Resource介面的子類別ResourceImpl實際上並未同時實作Lockable介面，且java允許在編譯時期物件參考值
		 * 可以轉型為任何介面，編譯器不予檢查，因代理人類別中有宣告:
		 * @DeclareParents(value = "course.spring.aop.resource.Resource+",defaultImpl = LockableImpl.class)
		 * private Lockable lock;
		 * 
		 * 所以介面Resource的子類別將被spring視同有實作介面Lockable，執行時期將可轉型為由Lockable，被呼叫Lockable
		 * 相關方法時則由spring改以LockableImpl物件的方法實作內容因應。
		*/
		Lockable lockable = (Lockable)resource;
		lockable.lock();//設定為true
		resource.setContent("Hi, Jim!!");//觸發方法2
		
		lockable.unlock();//設定為false
		resource.setContent("Hi, Jim!!");//觸發方法3

	}

}
