package course.spring.di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//只匯入設定類別MediaPlayerConfig的內容也會間接匯入設定類別CompactDiscConfig的內容
//單元測試OnlyJavaMixedConfigTest.java
@Configuration
@Import({MediaPlayerConfig.class})
public class SystemConfigOnlyJava {

}
