package course.spring.aop.proxy;

//建立代理人ProxyImageNoCache，並實作介面Image，用於模擬圖片載入「要求」及時性，每次一定重新載入，避免cache。
public class ProxyImageNoCache implements Image{
	private String fileName;

	public ProxyImageNoCache(String fileName) {
		this.fileName = fileName;
	}
	
	//每次都重新建立RealImage物件
	@Override
	public void display() {
		new RealImage(fileName).display();		
	}
	
	
}
