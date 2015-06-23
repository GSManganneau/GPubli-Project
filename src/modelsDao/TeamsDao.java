package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.json.JSONObject;

import com.DataSource.mysql.DataSource;

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
		   Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        Teams Team = new Teams();
	        try {
	            connexion = factory.getConnection();
	            statement = connexion.createStatement();
	            resultat  = statement.executeQuery("SELECT * FROM teams where teamId="+id);

	            while (resultat.next()) {
	                String name = resultat.getString("teamName");
	                String thumb = resultat.getString("thumbnail");
	                
	                Team.setTeamName(name);
	                Team.setTeamId(id);
	                Team.setThumbnail(thumb);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Team;
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
            resultat  = statement.executeQuery("SELECT t.teamName,t.teamId,t.thumbnail FROM teams t");

            while (resultat.next()) {
                String name = resultat.getString("teamName");

                int teamId = Integer.parseInt(resultat.getString("teamId"));
                String thumbnail = resultat.getString("thumbnail");
                
                Teams team = new Teams();
                team.setTeamId(teamId);
                team.setTeamName(name);
                team.setThumbnail(thumbnail);

                Teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Teams;
	}
	
	public Teams countEffectif(int teamId) {
		// TODO Auto-generated method stub
		Teams team = new Teams();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat  = statement.executeQuery("SELECT COUNT(a.AuthorId) nombre FROM Authors a JOIN Teams t ON a.teamId = t.teamId AND t.teamId ="+teamId);

            while (resultat.next()) {

                int effectif = Integer.parseInt(resultat.getString("nombre"));
                
                
                team.setTeamId(effectif);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return team;
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
			String query = "SELECT * FROM Teams T JOIN Authors A "
					+ "ON T.teamId = A.teamId "
					+ "AND A.ldapId ="+ldapId;
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String teamName = resultat.getString("teamName");
          	   int teamId=resultat.getInt("teamId");
          	   String thumb = resultat.getString("thumbnail");
          	   Team.setTeamName(teamName);
          	   Team.setTeamId(teamId);
          	   Team.setThumbnail(thumb);
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
            
            String query = "SELECT * FROM authors a JOIN teams t "
            		+ "ON a.teamId = t.teamId "
            		+ "AND t.teamName ='"+teamName+"'";
            
            
            resultat  = statement.executeQuery(query);

            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                int ldapId=resultat.getInt("ldapId");
                
                Authors author = new Authors();
                author.setFirstname(firstname);
                author.setLastname(lastname);
                author.setLdapId(ldapId);

                Authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Authors;
	}
	
	public Authors countAuthorTeam(String teamName) {
		// TODO Auto-generated method stub
		Authors author = new Authors();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            
            String query = "SELECT COUNT(*) AS nombre FROM authors a JOIN teams t "
            		+ "ON a.teamId = t.teamId "
            		+ "AND t.teamName ='"+teamName+"'";
            
            
            resultat  = statement.executeQuery(query);

            while (resultat.next()) {
                int nombre = Integer.parseInt(resultat.getString("nombre"));
           
                author.setCount(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return author;
	}

}
