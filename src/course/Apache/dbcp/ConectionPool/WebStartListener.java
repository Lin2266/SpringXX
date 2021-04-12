package course.Apache.dbcp.ConectionPool;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


@WebListener
public class WebStartListener implements ServletContextListener {
	public static final String DB = "DB";
	//實作ServletContextListener，在ServletContext啟動或終止時都可以接收到事件通知，因此常用來
	//放置需要在容器啟動或終止時需要執行的程式碼，此外web.xml也要設定

    public void contextInitialized(ServletContextEvent event)  { 
        ServletContext servletContext = event.getServletContext();
        //create connection pool
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.apache.derby.jdbc.clientDriver");//java DB
        //ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("sa");
        ds.setUrl("jdbc:derby://localhost:1527/myDB");
        //ds.setUrl("jdbc:mysql://localhost:3306/totalbuy?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8\"");
        ds.setInitialSize(10);
        //set connection pool in ServletContext
        servletContext.setAttribute(DB,ds);
        
        
   }
	

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Null implementation
    }

}
