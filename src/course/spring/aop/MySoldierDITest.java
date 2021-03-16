package course.spring.aop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import course.spring.di.GunDI;
import course.spring.di.MySoldierDI;
import course.spring.di.WeaponDI;


class MySoldierDITest {

	@Test
	void test() {		
		//關聯注入DI
		//GunDI實作weaponDI
		WeaponDI weaponDI = new GunDI();
		new MySoldierDI(weaponDI).destroyTarget();
				
	}

}
