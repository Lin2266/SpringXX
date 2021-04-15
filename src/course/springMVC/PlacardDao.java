package course.springMVC;

import java.util.List;

public interface PlacardDao {
	List<Placard> findRecentPlacards();
	List<Placard> findPlacards(long max,int count);
	Placard findBy(long id);
	void save(Placard placard);
}
