package course.springMVC.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import junit.framework.Assert;

public class HomeConrollerTest {
	/*
	 * Spring 3.2 之前，只能測試controller元件的方法是否可以如預期回傳代表view的字串，無法測試http的協定，
	 * 或是模擬瀏覽器輸入url的測試，亦即只能當一般的POJO測試，如方法testHomePage()
	 */

	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		Assert.assertEquals("home",controller.home());
	}
	
	/*
	 * Spring 3.2 開始，可以controller的角度來測試元件，且不需啟動網站或使用瀏覽器，如方法testHomePage2()
	 */
	
	@Test
	public void testHomePage2() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); //建構MockMvc物件
		mockMvc.perform(MockMvcRequestBuilders.get("/"))	//使用http get方法呼叫網址"/"
		.andExpect(MockMvcResultMatchers.view().name("home")); //預期得到名字為"home"的view
	}

}
