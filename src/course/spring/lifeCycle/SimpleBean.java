package course.spring.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SimpleBean implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,
									InitializingBean,DisposableBean{
	//spring元件的生命週期
	//1.instantiate	建構物件實例
	//2.Populate Properties 注入欄位值
	private String message;
	private int order;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	//3.可以將此方法取得spring注入的「bean元件名稱(id)」
	@Override	//from BeanNameAware
	public void setBeanName(String arg0) {
		System.out.println(++order + ": setBeanName()");		
	}
	
	//4.可以將此方法取得spring注入的「BeanFactory」
	@Override	//from BeanFactoryAware
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println(++order + ": setBeanFactory()");		
	}
	
	//5.取得spring注入的「ApplicationContext」物件
	@Override	//from ApplicationContextAware
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println(++order + ": setApplicationContext()");
	}
	
	//6.若有bean元件實作介面「BeanPostProcessor」，spring將在其postProcessBeforeInitialization()
	//方法中注入其他bean元件，以客製化或管控其他bean的生成流程。
	
	//7.若bean元件有實作介面「InitializingBean」，spring將呼叫afterPropertiesSet()方法，或呼叫bean
	//元件設定「init-method」方法，以客製化或管控其他bean的生成流程。
	@Override	//from InitializingBean
	public void afterPropertiesSet() throws Exception {
		System.out.println(++order + ": afterPropertiesSet() | init()");		
	}
	
	//8.若bean元件有實作介面「BeanPostProcessor」，spring將在其postProcessAfterInitialization()
	//方法中注入其他bean，以客製化或管控其他bean的生成流程。
	
	//9.至此，spring的bean元件已經可以正常使用。
	
	//10.若bean有實作介面「DisposableBean」，spring將呼叫destroy()方法，或呼叫bean元件設定的
	//「destory-method」方法，以客製化或管控其他bean的生成流程。
	@Override	//from DisposableBean
	public void destroy() throws Exception {
		System.out.println(++order + ": destroy()");		
	}

	//以上介面除「BeanPostProcessor」外，均實作在類別SimpleBean裡

	//from xml setting
	public void myInit() {
		System.out.println(++order + ": myInit()");
	}
	
	//from xml setting
	public void myDestroy() throws Exception{
		System.out.println(++order + ": myDestroy()");
	}

	

	
	
}
