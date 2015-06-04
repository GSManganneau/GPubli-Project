package modelsDao;
import java.sql.Connection;
import java.util.List;

import beans.Publications;
import controllers_front.Paginate;

public abstract class Dao<T> {
	protected Connection connect = null;
	



	public abstract T find(int id);
	
	public abstract boolean create(T object);

	public abstract boolean update(T object);

	public abstract boolean delete(T object);
	


}
