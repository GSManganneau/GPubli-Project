package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Publications;

public class PublicationsDao extends Dao<Publications>{

	 private EntityFactory factory;

	    PublicationsDao(EntityFactory daoFactory) {
	        this.factory = daoFactory;
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
	public List<Publications> lister() {
        List<Publications> Publications = new ArrayList<Publications>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM Publication");

            while (resultat.next()) {
                int type = resultat.getInt("type_id");
                String resume = resultat.getString("resume");
                String journal= resultat.getString("journal");

                Publications Publication = new Publications();
                Publication.setType(type);
                Publication.setResume(resume);
                Publication.setJournal(journal);

                Publications.add(Publication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Publications;
    }


}
