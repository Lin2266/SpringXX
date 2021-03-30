package course.spring.aop.show;

public class ShowImpl implements Show{

	@Override
	public void play() throws Exception {
		System.out.println("The show is playing...");
		throw new Exception("例外");
	}
	
}
