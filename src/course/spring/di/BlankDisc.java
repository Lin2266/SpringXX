package course.spring.di;

import java.util.List;

//設定檔 ConstructorArgCollectionTest-context.xml、PropertyValueTest-context.xml
public class BlankDisc implements CompactDisc{
	private String title;
	private String artist;
	private List<String> tracks;
	
	public BlankDisc(String title, String artist, List<String> tracks) {
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}


	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist + "\n");
		for(String track:tracks) {
			System.out.println("-Track: " + track +"\n");
		}
	}
		
}
