package course.spring;

import org.junit.jupiter.api.Test;

class MySoldierTest {

	@Test
	void test() {
		//建立MySoldierNG物件必然伴隨Gun物件的建立，測試邏輯就無法切割
		//使用關聯注入(dependency Injection DI)就可以解決此問題
		//所有武器統一建立介面Weapon
		//new MySoldierNG().destroyTarget();	
		
	}

}
