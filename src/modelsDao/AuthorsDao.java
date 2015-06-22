package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Authors;
import beans.Teams;

public class AuthorsDao extends Dao<Authors>{

	private DAOFactory factory;

	    public AuthorsDao(DAOFactory daoFactory) {
	        this.factory = daoFactory;
	    }



	@Override
	public Authors find(int id) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Authors author=null;
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query= "SELECT * FROM Authors where ldapId="+id;
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	     // Récupération des données
            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                String login=resultat.getString("login");
                int authorId=resultat.getInt("authorId");
                int ldapId=resultat.getInt("ldapId");
                int teamId= resultat.getInt("teamId");
                
               author = new Authors();
               author.setFirstname(firstname);
               author.setLastname(lastname);
               author.setLogin(login);
               author.setLdapId(ldapId);
               author.setAuthorId(authorId);
               author.getTeam().setTeamId(teamId);
               
                    
            }
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return author;
	}
	public Authors findWithId(int id) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        Authors author=null;
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query= "SELECT * FROM Authors where authorId="+id;
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	     // Récupération des données
            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                int authorId=resultat.getInt("authorId");
                int ldapId=resultat.getInt("ldapId");
                int teamId= resultat.getInt("teamId");
                
               author = new Authors();
               author.setFirstname(firstname);
               author.setLastname(lastname);
               author.setLdapId(ldapId);
               author.setAuthorId(authorId);
               author.getTeam().setTeamId(teamId);
               
                    
            }
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return author;
	}

	
	@Override
	public boolean create(Authors object) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		int authorId=0;
        String firstname=object.getFirstname();
        String lastname=object.getLastname();
        String login = object.getLogin();
        int teamId=object.getTeam().getTeamId();
        int ldapId=object.getLdapId();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Authors (firstname,lastname,teamId,ldapId,login) VALUES (?,?,?,?,?)";
        			PreparedStatement preparedStatement = connexion.prepareStatement(
        					query, Statement.RETURN_GENERATED_KEYS);
        			preparedStatement.setString(1,firstname);
    	            preparedStatement.setString(2,lastname);
    	            preparedStatement.setInt(3,teamId);
    	            preparedStatement.setInt(4,ldapId);
    	            preparedStatement.setString(5,login);
    	            
    	            preparedStatement.executeUpdate();
    	            ResultSet result = preparedStatement.getGeneratedKeys();
    				result.next();
    				authorId = result.getInt(1);

        		}catch(SQLException e){
        			e.printStackTrace();
        		}
        		
		return true;
	}
	public int create(Authors object,boolean j) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		int authorId=0;
        String firstname=object.getFirstname();
        String lastname=object.getLastname();
        String login = object.getLogin();
        int teamId=object.getTeam().getTeamId();
        int ldapId=object.getLdapId();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Authors (firstname,lastname,teamId,ldapId,login) VALUES (?,?,?,?,?)";
        			PreparedStatement preparedStatement = connexion.prepareStatement(
        					query, Statement.RETURN_GENERATED_KEYS);
        			preparedStatement.setString(1,firstname);
    	            preparedStatement.setString(2,lastname);
    	            preparedStatement.setInt(3,teamId);
    	            preparedStatement.setInt(4,ldapId);
    	            preparedStatement.setString(5,login);
    	            
    	            preparedStatement.executeUpdate();
    	            ResultSet result = preparedStatement.getGeneratedKeys();
    				result.next();
    				authorId = result.getInt(1);

        		}catch(SQLException e){
        			e.printStackTrace();
        		}
        		
		return authorId;
	}
	
	public List<Authors> lister(int i) {
        List<Authors> Authors = new ArrayList<Authors>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM Authors natural join Teams where authorId <>"+ i);

            while (resultat.next()) {
            	String teamName= resultat.getString("teamName");
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                String login=resultat.getString("login");
                int authorId = resultat.getInt("authorId");
                
                

                Authors Author = new Authors();
                Author.setAuthorId(authorId);
                Author.setFirstname(firstname);
                Author.setLastname(lastname);
                Author.setLogin(login);
                Author.getTeam().setTeamName(teamName);

                Authors.add(Author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Authors;
    }
	
	public List<Authors> lister() {
        List<Authors> Authors = new ArrayList<Authors>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM Authors natural join Teams");

            while (resultat.next()) {
            	String teamName= resultat.getString("teamName");
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                String login=resultat.getString("login");
                int authorId = resultat.getInt("authorId");
                int teamId = resultat.getInt("teamId");
                
                

                Authors Author = new Authors();
                Author.setAuthorId(authorId);
                Author.setFirstname(firstname);
                Author.setLastname(lastname);
                Author.setLogin(login);
                Author.getTeam().setTeamName(teamName);
                Author.getTeam().setTeamId(teamId);

                Authors.add(Author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Authors;
    }
	
	@Override
	public boolean update(Authors object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Authors object) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Authors> search(String field) {
		// TODO Auto-generated method stub
		List<Authors> Authors = new ArrayList<Authors>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

		try{
			connexion=factory.getConnection();
			String query = "SELECT * FROM authors WHERE firstname like '%"+field+"%' OR lastname like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	              
	        // Récupération des données
            while (resultat.next()) {
                          
            	//Données de la table team
                String firstname = resultat.getString("firstname");   
                String lastname = resultat.getString("lastname");
                String login= resultat.getString("login");
                
                Authors Author = new Authors();
                Author.setFirstname(firstname);
                Author.setLastname(lastname);
                Author.setLogin(login);
                
                Authors.add(Author);
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Authors;
	}
	
	public Authors count(String field) {
		// TODO Auto-generated method stub
		Authors Author = new Authors();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        int i;
		try{
			connexion=factory.getConnection();
			String query = "SELECT COUNT(*) AS nombre FROM authors WHERE firstname like '%"+field+"%' OR lastname like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String nombre = resultat.getString("nombre");
          	  
          	   i = Integer.parseInt(nombre); 
          	   Author.setCount(i);        	   
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Author;
	}
	
	public Authors countAll() {
		// TODO Auto-generated method stub
		Authors Author = new Authors();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        int i;
		try{
			connexion=factory.getConnection();
			String query = "SELECT COUNT(*) AS nombre FROM authors";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String nombre = resultat.getString("nombre");
          	  
          	   i = Integer.parseInt(nombre); 
          	   Author.setCount(i);        	   
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Author;
	}
	
	public Authors countInTeam(int teamId) {
		// TODO Auto-generated method stub
		Authors Author = new Authors();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        int i;
		try{
			connexion=factory.getConnection();
			String query = "SELECT COUNT(A.firstname) AS nombre FROM authors A JOIN teams T "
					+ "ON A.teamId = T.teamId "
					+ "WHERE teamId ="+teamId;
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
          	   String nombre = resultat.getString("nombre");
          	  
          	   i = Integer.parseInt(nombre); 
          	   Author.setCount(i);        	   
            }
            
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Author;
	}


/*	@Override
	public List<Object> lister(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
