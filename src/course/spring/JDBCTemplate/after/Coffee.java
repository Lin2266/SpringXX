package course.spring.JDBCTemplate.after;

public class Coffee extends DrinkTemplate {

	@Override
	void cookMain() {
		System.out.println("Brew coffee");
		
	}

	@Override
	void addCondiments() {
		System.out.println("Add sugar & milk to Coffee");
		
	}
	
}
