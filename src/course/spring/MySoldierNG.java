package course.spring;

import course.spring.aop.AlertXML;
import course.spring.di.WeaponDI;

public class MySoldierNG implements Soldier{
	WeaponDI weapon;
	AlertXML alert;
	public MySoldierNG(WeaponDI w,AlertXML a) {
		this.weapon = w;
		this.alert = a;
	}

	@Override
	public void destroyTarget() {
		this.alert.beforeAttack();
		this.weapon.attack();
		this.alert.afterAttack();
		
	}

}
