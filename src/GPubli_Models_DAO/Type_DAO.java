package GPubli_Models_DAO;

import java.sql.Connection;
import GPubli_Models.Type;

public class Type_DAO extends DAO<Type>{

	public Type_DAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Type find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Type object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Type object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Type object) {
		// TODO Auto-generated method stub
		return false;
	}

}
