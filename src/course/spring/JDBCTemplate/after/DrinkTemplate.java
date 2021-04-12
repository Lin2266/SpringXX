package course.spring.JDBCTemplate.after;

public abstract class DrinkTemplate {
	void boilWater() {		//Coffee跟Tea一樣的, this.getClass().getSimpleName()取得呼叫此方法的建構型態
		System.out.println("Boil Water for " + this.getClass().getSimpleName());
	}
	
	abstract void cookMain();//Coffee跟Tea相似的
	
	void pourInCup() {		//Coffee跟Tea一樣的
		System.out.println("Pour " + this.getClass().getSimpleName() + " in cup");
	}
	
	abstract void addCondiments();//Coffee跟Tea相似的
	
	void hook() {}					//default null implementation
	
	void processTemplate() {
		boilWater();
		cookMain();
		pourInCup();
		addCondiments();
		hook();
	}
}
