package GPubli_Models_DAO;

import java.sql.Connection;
import GPubli_Models.Teams;

public class Teams_DAO extends DAO<Teams>{

	public Teams_DAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Teams find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Teams object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Teams object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Teams object) {
		// TODO Auto-generated method stub
		return false;
	}

}
