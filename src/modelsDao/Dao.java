package modelsDao;
import java.sql.Connection;

public abstract class Dao<T> {
	protected Connection connect = null;


	public abstract T find(int id);

	public abstract boolean create(T object);

	public abstract boolean update(T object);

	public abstract boolean delete(T object);

}
