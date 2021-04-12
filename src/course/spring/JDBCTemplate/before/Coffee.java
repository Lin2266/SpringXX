package course.spring.JDBCTemplate.before;

public class Coffee {
	void boilWater() {
		System.out.println("Boil Water for Coffer");
	}
	void brewCoffee() {
		System.out.println("Brew Coffee");
	}
	void pourInCup() {
		System.out.println("Pour Coffee in cup");
	}
	void addSugarAndMilk() {
		System.out.println("Add sugar & milk to Coffee");
	}
	void process() {		//總流程
		boilWater();		//煮開水
		brewCoffee();		//煮咖啡
		pourInCup();		//倒水
		addSugarAndMilk();	//加糖和牛奶
	}

}
