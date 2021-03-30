package course.spring.di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({MediaPlayerConfig.class})
@ImportResource("classpath:/course/spring/di/compactDiscBlankConfig.xml")
public class SystemConfigJavaXml {

}
