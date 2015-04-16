package GPubli_Models_DAO;

import java.sql.Connection;
import GPubli_Models.Publications;

public class Publications_DAO extends DAO<Publications>{

	public Publications_DAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Publications find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Publications object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Publications object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Publications object) {
		// TODO Auto-generated method stub
		return false;
	}

}
