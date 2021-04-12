package course.spring.diXML;

import course.spring.diXML.CompactDisc;

//設定檔ConstructorArgValueTest-context.xml跟CNamespaceValueTest-comtext.xml
public class CompactDiscBlankImpl implements CompactDisc{
	private String title;
	private String artist;
		
	public CompactDiscBlankImpl(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);		
	}

}
