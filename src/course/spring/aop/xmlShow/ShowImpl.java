package course.spring.aop.xmlShow;


public class ShowImpl implements Show{

	@Override
	public void play() throws Exception {
		System.out.println("The show is playing...");
		//throw new Exception("例外:測試@AfterThrowing");//測試@AfterThrowing(未正常exception)時使用
	}
	
}
