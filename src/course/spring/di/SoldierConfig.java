package course.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import course.spring.Soldier;
import course.spring.aop.AlertAnnotation;
import course.spring.diXML.GunDI;
import course.spring.diXML.MySoldierDI;
import course.spring.diXML.WeaponDI;

//spring所提供的關聯注入di可分2種:2.JAVA-based:使用JAVA類別搭配annotation設定類別間的關聯性。
@Configuration	//宣告為spring的設定類別
@EnableAspectJAutoProxy//宣告啟用Aspect，設定類別取代xml
public class SoldierConfig {	
	@Bean
	public Soldier getSoldier() {
		return new MySoldierDI(getWeapon());
	}
	
	@Bean	//表示spring啟動時將執行該方法，並將產出的物件納管為bean元件
	public WeaponDI getWeapon() {
		return new GunDI();
	}
	
	@Bean
	public AlertAnnotation getAlert() {
		return new AlertAnnotation();
	}
}
