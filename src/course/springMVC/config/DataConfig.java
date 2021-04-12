package course.springMVC.config;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfig {
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				/*資料庫使用內嵌式EmbeddedDatabaseType.HSQL，將在Spring啟動時一併啟動
				  結束時一併移除資料庫，啟動時以schema.sql建立系統需要之表格與資料列。
				  HSQL是存在於JVM中，100%純Java開發的資料庫，加入本方法程式碼後可以在啟
				  動Spring時同步啟動「HSQL Database Manager」的SWING視窗來存取資料庫
				*/
				.setType(EmbeddedDatabaseType.HSQL)
			  //.setName(databaseName)
				.addScript("schema.sql")
				.build();
	}
	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	@PostConstruct
	public void startDBManager() {
		DatabaseManagerSwing.main(
			new String[] {
				"--url",
				"jdbc:hsqldb:men:testdb",
				"--user",
				"sa",
				"--password",
				""
			}
		);
	}
}
