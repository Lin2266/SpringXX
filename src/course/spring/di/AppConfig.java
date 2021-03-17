package course.spring.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
  @Configuration表示該類別為spring設定檔，將建立所有bean物件，及其關聯性。
  本列並未如前章範例以@Bean標註bean元件的方法而是改用@ComponentScan。
  因而將自動搜尋和本類別在「同一個路徑」或是「所有子路徑」的所有bean類別，並建立
  物件及注入關聯性。
  也可以改用設定檔appConfig.xml取代設定類別AppConfig.java。
*/
@Configuration
@ComponentScan
public class AppConfig {

}
