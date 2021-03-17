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
@ContextConfiguration(classes = AppConfig.class)
public class CDPlayerTest {
	
		//用AppConfig.java設定測試
	
		//搭配SystemOutRule可側錄使用輸出的日誌紀錄，側錄前先使用方法clearLog()清除紀錄
		//側錄後呼叫方法getLog()取得紀錄。
		@Rule
		public final SystemOutRule out = new SystemOutRule().enableLog();
		
		//@Autowired注入需要的bean物件，spring將自動建立符合的bean物件，並關聯注入
		@Autowired
		private MediaPlayer player;
		@Autowired
		private CompactDisc cd;
		
		//使用@Test的所有方法都會進行測試
		@Test
		public void cdShouldNotBeNull() {
			//斷言物件參考非null，用於驗證spring是否已完成關聯注入
			assertNotNull(cd);
		}
		
		@Test
		public void verifyCdPlayResult() {
			//側錄前先清除紀錄
			out.clearLog();
			player.perform();
			//側錄後呼叫getLog()取得紀錄，使用assertEquals()斷言兩參數值內容相同。
			assertEquals("Playing [Nice Song] by [Some Artist]",out.getLog());
		}

}
