package course.springMVC;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Placard {
	
	private Long id;
	private String message;
	private Date time;
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"id","time");//比較傳入物件(that)和自己(this)的id、time欄位值。
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this,"id","time");//以自己(this)的id、time欄位計算hascode值。
	}
}
