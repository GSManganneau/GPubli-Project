package modelsDao;

import java.sql.Connection;

import models.Published;

public class PublishedDao extends Dao<Published>{

	public PublishedDao(Connection connect) {
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
