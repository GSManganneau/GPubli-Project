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
            resultat  = statement.executeQuery("SELECT * FROM teams");

            while (resultat.next()) {
                String name = resultat.getString("teamName");
                /*String author_firstname = resultat.getString("firstname");
                String author_lastname = resultat.getString("lastname");*/
                
                Teams Team = new Teams();
                Team.setTeamName(name);
                
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
			String query = "SELECT teamName FROM teams WHERE teamName like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
                          
            	//Données de la table team
                String teamName = resultat.getString("teamName");          
                System.out.print(teamName);
                Teams Team = new Teams();
                Team.setTeamName(teamName);
                
                Teams.add(Team);
            }
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Teams;
	}


	public Teams count(String field) {
		// TODO Auto-generated method stub
		Teams Team = new Teams();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        int i;
        
		try{
			connexion=factory.getConnection();
			String query = "SELECT COUNT(teamName) AS nombre FROM teams WHERE teamName like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String nombre = resultat.getString("nombre");
          	   
          	   i = Integer.parseInt(nombre); 
          	   Team.setCount(i);
          	    	   
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Team;
	}
	
	public Teams countAll() {
		// TODO Auto-generated method stub
		Teams Team = new Teams();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        int i;
        
		try{
			connexion=factory.getConnection();
			String query = "SELECT COUNT(teamName) AS nombre FROM teams";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String nombre = resultat.getString("nombre");
          	   
          	   i = Integer.parseInt(nombre); 
          	   Team.setCount(i);
          	    	   
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Team;
	}
	
	public Teams teamOfAuthor(int ldapId) {
		Teams Team = new Teams();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
		try{
			connexion=factory.getConnection();
			String query = "SELECT T.teamName FROM Teams T JOIN Authors A "
					+ "ON T.teamId = A.teamId "
					+ "AND A.ldapId ="+ldapId;
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String teamName = resultat.getString("teamName");
          	   Team.setTeamName(teamName);
          	    	   
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Team;
	}
	
	public List<Authors> listContentTeam(String teamName) {
		// TODO Auto-generated method stub
        List<Authors> Authors = new ArrayList<Authors>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat  = statement.executeQuery("SELECT * FROM authors a JOIN Teams t "
            		+ "ON a.teamId = T.teamId "
            		+ "AND teamName ="+teamName);

            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                
                Authors author = new Authors();
                author.setFirstname(firstname);
                author.setLastname(lastname);

                Authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Authors;
	}

}
