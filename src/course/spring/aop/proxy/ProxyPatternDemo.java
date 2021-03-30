package course.spring.aop.proxy;

//測試cache跟no cache
public class ProxyPatternDemo {
	public static void main(String[] args) {
		/*
		 * 因為使用代理人物件的關係，不須異動被代理人物件，且可自由決定是否利用cache呈現圖片。
		 * 若是，則圖片載入1次但可呈現2次(亦可多次)，
		 * 若否，每次呈現都要先載入，本例中呈現2次故載入2次。
		 */
		System.out.println("--------------- Cache Image Demo");
		Image cache = new ProxyImageCache("someImage.jpg");
		cache.display();
		cache.display();
		System.out.println("\n------------- NO Cache Image Demo");
		Image noCache = new ProxyImageNoCache("someImage.jpg");
		noCache.display();
		noCache.display();
	}
}
