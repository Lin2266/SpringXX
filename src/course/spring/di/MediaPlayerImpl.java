package course.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component表示該類別需要被spring建立為bean物件，並列入控管
@Component
public class MediaPlayerImpl implements MediaPlayer{
	private CompactDisc cd;
	
	//@Autowired表示執行時期將自動以需要的bean元件縫合至建構子參數CompactDisc內
	@Autowired
	public MediaPlayerImpl(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void perform() {
		cd.play();
		
	}
}
