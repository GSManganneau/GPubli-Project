package modelsDao;

import java.sql.Connection;

import models.Publications;

public class PublicationsDao extends Dao<Publications>{

	public PublicationsDao(Connection connect) {
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
