package course.spring.aop.xmlResource;

public class ResourceAspect {
	//使用AspectJ指定器args()搭配execute()攔截方法參數。
	//args(content1)指定方法名稱，並配合setResourceContent()的方法參數名稱content1，execute()指定方法參數型態String	
	public void beforeSetContent(String content) {
		System.out.println("@Aspect: before set content: " + content);
	}

}
