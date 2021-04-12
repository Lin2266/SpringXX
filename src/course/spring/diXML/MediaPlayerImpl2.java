package course.spring.diXML;

import course.spring.diXML.CompactDisc;

public class MediaPlayerImpl2 implements MediaPlayer2{
	private CompactDisc compactDisc;
	
	//若物件間有較強的關聯性，可考慮使用「建構子」注入關係，其他則使用「欄位/屬性」
	public MediaPlayerImpl2(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}
	
	//欄位/屬性注入關聯，參考 PropertyReferenceTest-context.xml
	@Override
	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
		
	}

	@Override
	public void play() {
		compactDisc.play();
		
	}


	
	

}
