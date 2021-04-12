package course.spring.diXML;

import org.springframework.beans.factory.annotation.Autowired;

//@Autowired 可在建構子外，也可在方法、欄位加上@Autowired
public class MediaPlayerImpl implements MediaPlayer{
	@Autowired //欄位
	private CompactDisc cd;
	
	//@Autowired表示執行時期將自動以需要的bean元件縫合至建構子參數CompactDisc內
	@Autowired //建構子
	public MediaPlayerImpl(CompactDisc cd) {
		this.cd = cd;
	}
	
	//若方法加註@Autowired，但spring未找到合適的元件注入，將拋出例外並終止程式執行，此時可以加入
	//屬性「required=false」來避免程式中斷，但因該屬性有可能因為無元件注入而致物件參考是null，因此必須
	//注意執行實期可能會拋出NullPointerException例外。
	@Autowired(required=false) //方法
	public void setCd(CompactDisc cd) {
		this.cd = cd;
	}
	
	@Override
	public void perform() {
		cd.play();
		
	}

	@Override
	public CompactDisc getCD() {
		return this.cd;		
	}
}
