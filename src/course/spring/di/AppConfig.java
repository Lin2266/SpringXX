package course.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
  @Configuration表示該類別為spring設定檔，將建立所有bean物件，及其關聯性。
  本列並未如前章範例以@Bean標註bean元件的方法而是改用@ComponentScan。
  因而將自動搜尋和本類別在「同一個路徑」或是「所有子路徑」的所有bean類別，並建立
  物件及注入關聯性。
  也可以改用設定檔appConfig.xml取代設定類別AppConfig.java。
*/

//@ComponentScan //for automatically scanning wiring 用於自動掃描接線
//設定類別內可以使用自動搜尋bean元件，可直接指定搜尋的套件 @componentScan("course.spring.di")
//或加上屬性 @componentScan(basePackages = "course.spring.di")
//也可指定搜尋多個套件 @componentScan(basePackages = "course.spring.di","others")
//或指定特定類別或介面所在套件 @componentScan(basePackageClasses = {CompactDisc.class,MediaPlayer.class})
@Configuration
public class AppConfig {
	//使用@Bean標註類別指定DI元件
	@Bean
	public CompactDisc getCompactDisc() {
		return new CompactDiscImpl();
	}
	
	//以下2方法得到相同結果，以應降低相依度的設計原則來看，方法2優於方法1
//	@Bean //方法1
//	public MediaPlayer getMediaPlayer1() {
//		return new MediaPlayerImpl(getCompactDisc());
//	}
	
	@Bean //方法2
	public MediaPlayer getMediaPlayer(CompactDisc compactDisc) {
		return new MediaPlayerImpl(compactDisc);
	}
//	@Bean(name="compactDisc")
//	public CompactDisc randomCD() {
//		int choice = (int)Math.floor(Math.random() * 4);
//		if(choice == 0) {
//			return new CompactDiscImpl();
//		}else {
//			return new CompactDiscImpl();
//		}
//	}
	


}
