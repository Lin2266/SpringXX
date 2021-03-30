package course.spring.aop.proxy;

//建立代理人類別ProxyImageCache，並實作介面Image，用於模擬圖片載入「不要求」及時性，有cache就不再重新載入。
public class ProxyImageCache implements Image{
	private Image reaImage; //代理人類別含被代理人類別(RealImage)的物件參考。
	private String fileName;
	
	//傳入檔案名稱
	public ProxyImageCache(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void display() {
		//若被代理人類別RealImage的物件不存在，則使用檔案名稱載入該物件
		if(reaImage == null) {
			reaImage = new RealImage(fileName);
		}
		//若存在則使用該物件，亦即實作「快取cache」的概念。
		//代理人物件的display()方法，將委派給被代理人物件的display()執行。
		reaImage.display();
	}
	
	
}
