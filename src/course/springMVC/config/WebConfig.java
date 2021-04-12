package course.springMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration	//表示該類別為spring設定檔，將建立所有bean物件，及其關聯性。
@EnableWebMvc	//啟動Spring MVC，對應spring設定檔使用的標籤<mvc:annotation-driven>。
@ComponentScan("bulletin.web")	//自動掃描套件bulletin.web內的Spring MVC元件，如標註有@Controller的類別。
public class WebConfig extends WebMvcConfigurerAdapter{
	
/*	定義Spring MVC架構裡需要的ViewResolver，方法內使用InternalResourceViewResolver物件來規範
	controller裡面view的解析方式，若controller要求view的邏輯字串為"home"，則解析器自動在字首(prefix)
	加「/WEB-INF/views/」，並在字尾(suffix)加上「.jsp」，因此形成「/WEB-INF/views/home.jsp」，
	若未定義ViewResolver使用的解析元件，將會預設使用類別BeanNameViewResolver，此時會在Spring容器
	裡尋找名稱符合，且有實作介面view的bean元件。
*/
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();//內部資源視圖解析器
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
/*	可以要求Spring的DispatcherServlet將static的資源，如圖片、css、javascript等轉交給web容器預設的
 	DefaultServlet處理，也可以在設定檔內以標籤<mvc:default-servlet-handler/>取代。
 
*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
