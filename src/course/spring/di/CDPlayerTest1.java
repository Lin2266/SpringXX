package course.spring.di;

import org.junit.Test;

public class CDPlayerTest1 {

	@Test
	public void test() {
		CompactDiscImpl cd = new CompactDiscImpl();
		MediaPlayerImpl play = new MediaPlayerImpl(cd);
		play.perform();
	}

}
