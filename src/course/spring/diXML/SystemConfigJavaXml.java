package course.spring.diXML;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import course.spring.diXML.MediaPlayerConfig;

@Import({MediaPlayerConfig.class})
@ImportResource("classpath:/course/spring/diXML/compactDiscBlankConfig.xml")
public class SystemConfigJavaXml {

}
