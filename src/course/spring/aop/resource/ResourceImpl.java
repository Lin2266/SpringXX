package course.spring.aop.resource;

public class ResourceImpl implements Resource{
	private String content;

	@Override
	public void setContent(String content) {
		this.content = content;
		System.out.println("ResourceImpl.setContent: " + content);
	}

	@Override
	public String getContent() {
		return this.content;
	}
	
	

}
