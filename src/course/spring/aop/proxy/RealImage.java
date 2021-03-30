package course.spring.aop.proxy;

/*
代理人設計模式:
當某當事人設立了「代理人proxy」，就是希望別人必須先經過代理人，才能找到當事人，所以代理人的任務是
「控制並管理存取」。
如網頁載入圖片時，可能需要:
要求及時性時，每次一定重新載入，避免cache。	ProxyImageNoCache.java
不要求及時性時，有cache就不再重新載入。	ProxyImageCache.java
*/

//被代理人類別
public class RealImage implements Image{
	private String fileName;
	
	//建構子傳入圖檔名稱，以log訊息模擬圖片載入。
	public RealImage(String fileName) {
		this.fileName = fileName;
		System.out.println(fileName + " is loading...");
	}
	
	//呼叫display()方法，以log訊息與模擬圖片呈現。
	@Override
	public void display() {
		System.out.println(fileName + " is displayed");
		
	}
		
}
