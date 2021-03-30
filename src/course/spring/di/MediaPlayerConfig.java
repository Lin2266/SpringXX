package course.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CompactDiscConfig.class)
public class MediaPlayerConfig {
	//表示spring啟動時將執行該方法，並將產出的物件納管為bean元件
	@Bean
	public MediaPlayer cdPlayer(CompactDisc compactDisc) {
		return new MediaPlayerImpl(compactDisc);
	}
}
