package course.springMVC.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;


@Configuration
@Import(DataConfig.class)	//將資料庫存取部分，委由DataConfig設定類別處理。
//excludeFilters(排除過濾器)屬性避免載入特定元件(使用類別ExcludeWebConfigFilter指定)。
//此設定排除由設定類別WebConfig載入的bean元件，避免重複。
@ComponentScan(basePackages= {"bulletin"},excludeFilters= {
		@Filter(type=FilterType.CUSTOM,value=ExcludeWebConfigFilter.class)
		//另一種排除Spring MVC使用的元件的做法。
		//@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
})
public class RootConfig {

}


class ExcludeWebConfigFilter extends RegexPatternTypeFilter{

	public ExcludeWebConfigFilter() {
		//在bulletin.web套件下的所有元件都將被排除，目的是讓設定類別RootConfig和WebConfig
		//載入的元件不重複。
		super(Pattern.compile("bulletin\\.web"));
	}
	
}