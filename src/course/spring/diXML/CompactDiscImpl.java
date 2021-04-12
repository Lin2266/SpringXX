package course.spring.diXML;


public class CompactDiscImpl implements CompactDisc{
	private String title = "[Nice Song]";
	private String artist = "[Some Artist]";

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);		
	}

}
