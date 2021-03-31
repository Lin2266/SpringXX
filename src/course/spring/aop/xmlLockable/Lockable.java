package course.spring.aop.xmlLockable;

public interface Lockable {
	boolean isLocked();
	void lock();
	void unlock();
}
