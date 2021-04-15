package course.springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import course.springMVC.PlacardDao;

@Configuration
@RequestMapping("/placards")
public class PlacardController {
	private PlacardDao placardDao;
	@Autowired
	public PlacardController(PlacardDao placardDao) {
		this.placardDao = placardDao;
	}
}
