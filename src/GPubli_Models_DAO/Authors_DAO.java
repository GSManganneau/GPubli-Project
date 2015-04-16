package GPubli_Models_DAO;

import java.sql.Connection;
import GPubli_Models.Authors;

public class Authors_DAO extends DAO<Authors>{

	public Authors_DAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Authors find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Authors object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Authors object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Authors object) {
		// TODO Auto-generated method stub
		return false;
	}

}
