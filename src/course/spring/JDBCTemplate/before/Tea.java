package course.spring.JDBCTemplate.before;

public class Tea {
	void boilWater() {
		System.out.println("Boil Water for Tea");
	}
	void steepTea() {
		System.out.println("Steep Tea");
	}
	void pourInCup() {
		System.out.println("Pour Tea in cup");
	}
	void addFruit() {
		System.out.println("Add fruit to Tea");
	}
	void process() {		//總流程
		boilWater();		//煮開水
		steepTea();			//浸泡茶葉
		pourInCup();		//倒水
		addFruit();			//加水果
	}
}
