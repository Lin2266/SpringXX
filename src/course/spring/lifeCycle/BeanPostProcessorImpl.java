package course.spring.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor{
	//實作BeanPostProcessor對其他bean元件的影響
	//重新執行MainApp，因bean元件BeanPostProcessorImpl實作介面BeanPostProcessor，因此其他bean
	//元件如SimpleBean、OtherBean將在適當生命週期被傳入以下兩個方法。
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcess Before Initialization: " + beanName);
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcess After Initialization: " + beanName);
		return bean;
	}

	
	
}
