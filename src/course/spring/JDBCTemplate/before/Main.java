package course.spring.JDBCTemplate.before;

public class Main {

	public static void main(String[] args) {
		new Coffee().process();
		System.out.println("------------------------------------");
		new Tea().process();
		
		//Coffee跟Tea的boilWater()、pourInCup()相同，brewCoffee()、steepTea()、addSugarAndMilk()、addFruit()相似。
		//after套件建立抽象父類別DrinkTemplate將相同的步驟直接搬到父類別，讓子類別可以共用。
	}

}
