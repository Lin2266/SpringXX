package course.springMVC.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//1.可成為Controller類別，讓Spring啟動後可以自動生成bean元件，也可使用@Component，兩者效果一樣
//可以讓開發者較清楚識別元件種類。
@Controller	
public class HomeController {
	/*2.RequestMapping標註方法home(), 方法名稱不拘，使用之屬性value= {"/","/homepage"}，等同建立於HttpServlet類別時
	  標註的@WebServlet的屬性「urlPetterns」，為接受存取的url樣式。
	  method=RequestMethod.GET，表示接受由瀏覽器發送的GET請求。
	  兩者合併表示若用戶端指定url為「/」或「/homepage」，且使用HTTP方法為GET，才能呼叫本方法處理請求並回應。
	  3.因為@RequestMapping標註在方法上，故稱為「方法層級」的請求處理方式。
	  4.home()方法回傳的字串"home"為view的邏輯名稱，WebConfig的方法viewResolver()，實作InternalResourceViewResolver，
	  將導向至實體的view檔案:「/WEB-INF/views/home.jsp」
	*/
	@RequestMapping(value= {"/","/homepage"},method=RequestMethod.GET)
	public String home() {
		return "home";
	}

}
