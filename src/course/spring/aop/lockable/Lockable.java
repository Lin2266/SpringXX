package course.spring.aop.lockable;

public interface Lockable {
	boolean isLocked();
	void lock();
	void unlock();
}
