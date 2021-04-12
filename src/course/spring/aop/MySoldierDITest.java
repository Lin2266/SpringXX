package course.spring.aop;

import org.junit.Test;

import course.spring.diXML.GunDI;
import course.spring.diXML.MySoldierDI;
import course.spring.diXML.WeaponDI;


class MySoldierDITest {

	@Test
	void test() {		
		//關聯注入DI
		//GunDI實作weaponDI
		WeaponDI weaponDI = new GunDI();
		new MySoldierDI(weaponDI).destroyTarget();
				
	}

}
