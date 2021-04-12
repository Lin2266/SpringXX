package course.spring.diXML;

import org.springframework.context.annotation.Import;

@Import(CompactDiscConfig.class)
public class MediaPlayerConfig {
	
	public MediaPlayer cdPlayer(CompactDisc compactDisc) {
		return new MediaPlayerImpl(compactDisc);
	}
}
