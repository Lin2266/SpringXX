package course.springMVC.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 若將@RequestMapping改標註於Controller類別上，稱「類別階級」的請求處理方式，整個類別將專注在處理約定URL請求 不同的HTTP
 * 方法如GET、POST，則由不同的方法處理。
 */
@Controller	
@RequestMapping({"/","/homepage"})
public class HomeController2 {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}
}
