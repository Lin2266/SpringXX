package course.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//以java設定類別為主，整合其他java設定類別(使用混合方式進行DI)
@Configuration
public class CompactDiscConfig{
	@Bean
	public CompactDisc compactDisc() {
		return new CompactDiscImpl();
	}

}
