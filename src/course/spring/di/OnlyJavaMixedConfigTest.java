package course.spring.di;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定測試類別，可協助建立spring容器。
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring容器設定類別，AppConfig.java設定檔
@ContextConfiguration(classes = SystemConfigOnlyJava.class)
public class OnlyJavaMixedConfigTest {
	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();
	
	//@Autowired注入需要的bean物件，spring將自動建立符合的bean物件，並關聯注入
	@Autowired
	private MediaPlayer player;	

	@Test
	public void testOnlyJava() {
		log.clearLog();
		player.perform();
		assertEquals("Playing [Nice Song] by [Some Artist]",log.getLog());
	}

}
