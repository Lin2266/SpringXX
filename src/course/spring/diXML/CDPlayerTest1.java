package course.spring.diXML;

import org.junit.Test;

import course.spring.di.CompactDiscImpl;
import course.spring.di.MediaPlayerImpl;

public class CDPlayerTest1 {

	@Test
	public void test() {
		CompactDiscImpl cd = new CompactDiscImpl();
		MediaPlayerImpl play = new MediaPlayerImpl(cd);
		play.perform();
	}

}
