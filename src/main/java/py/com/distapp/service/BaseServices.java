package py.com.distapp.service;

import java.util.List;

public interface BaseServices<T> {
	public abstract void create(T t);

	public abstract void update(T t);

	public abstract void delete(T t);

	public abstract List<T> findAll();

	//public abstract T findById(Long id);

}
