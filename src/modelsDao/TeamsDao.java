package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Authors;
import beans.Teams;

public class TeamsDao extends Dao<Teams>{
	
	private DAOFactory factory;
	public TeamsDao(DAOFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.factory = daoFactory;
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


	public List<Authors> lister() {
		// TODO Auto-generated method stub
        List<Authors> Teams = new ArrayList<Authors>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat  = statement.executeQuery("SELECT a.firstname, a.lastname, t.name FROM author a,team t "
            		+ "WHERE t.team_id = a.team_id");

            while (resultat.next()) {
                String team_name = resultat.getString("name");
                String author_firstname = resultat.getString("firstname");
                String author_lastname = resultat.getString("lastname");
                
                //Nom des auteurs
                Authors author = new Authors();
                author.setFirstname(author_firstname);
                author.setLastname(author_lastname);  
                author.getTeam().setName(team_name);

                Teams.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Teams;
	}

}
