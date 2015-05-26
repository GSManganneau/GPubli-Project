package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Authors;
import beans.Publications;
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


	public List<Teams> lister() {
		// TODO Auto-generated method stub
        List<Teams> Teams = new ArrayList<Teams>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat  = statement.executeQuery("SELECT * FROM team");

            while (resultat.next()) {
                String name = resultat.getString("name");
                /*String author_firstname = resultat.getString("firstname");
                String author_lastname = resultat.getString("lastname");*/
                
                Teams Team = new Teams();
                Team.setName(name);
                
/*                //Nom des auteurs
                Authors author = new Authors();
                author.setFirstname(author_firstname);
                author.setLastname(author_lastname);  
                author.getTeam().setName(team_name);*/

                Teams.add(Team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Teams;
	}
	
	public List<Teams> search(String field) {
		List<Teams> Teams = new ArrayList<Teams>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
      
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query = "SELECT name FROM team WHERE name like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
                          
            	//Données de la table team
                String name = resultat.getString("name");          
                
                Teams Team = new Teams();
                Team.setName(name);
                
                Teams.add(Team);
            }
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Teams;
	}

}
