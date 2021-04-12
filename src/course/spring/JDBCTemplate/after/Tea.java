package course.spring.JDBCTemplate.after;

public class Tea extends DrinkTemplate{

	@Override
	void cookMain() {
		System.out.println("Steep Tea");
		
	}

	@Override
	void addCondiments() {
		System.out.println("Add fruit to Tea");
		
	}

	@Override
	void hook() {//提示飲料製程需添加冰塊或其他
		System.out.println("Add ice or some stuffs to Tea");
	}		

}
