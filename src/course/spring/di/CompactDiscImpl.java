package course.spring.di;

import org.springframework.stereotype.Component;

//@Component表示該類別需要被spring建立為bean物件，並列入控管
//@Component("beanName")
//@Named("beanName")

//@Component()
public class CompactDiscImpl implements CompactDisc{
	private String title = "[Nice Song]";
	private String artist = "[Some Artist]";

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);		
	}

}
