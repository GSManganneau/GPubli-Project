package GPubli_Models_DAO;

import java.sql.Connection;
import GPubli_Models.Published;

public class Published_DAO extends DAO<Published>{

	public Published_DAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Published find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Published object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Published object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Published object) {
		// TODO Auto-generated method stub
		return false;
	}

}
