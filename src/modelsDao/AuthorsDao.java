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
			String query= "SELECT * FROM Authors where ldap_id="+id;
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	     // Récupération des données
            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                int author_id=resultat.getInt("author_id");
                int eldap_id=resultat.getInt("ldap_id");
                int team_id= resultat.getInt("team_id");
                
               author = new Authors();
               author.setFirstname(firstname);
               author.setLastname(lastname);
               author.setEldap_id(eldap_id);
               author.setAuthor_id(author_id);
               
                    
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
        String firstname=object.getFirstname();
        String lastname=object.getLastname();
        int team_id=object.getTeam().getTeam_id();
        int eldap_id=object.getEldap_id();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Authors (firstname,lastname,team_id,ldap_id) VALUES (?,?,?,?)";
        			PreparedStatement preparedStatement = connexion.prepareStatement(query);
        			preparedStatement.setString(1,firstname);
    	            preparedStatement.setString(2,lastname);
    	            preparedStatement.setInt(3,team_id);
    	            preparedStatement.setInt(4,eldap_id);
    	           
    	            
    	            preparedStatement.executeUpdate();

        		}catch(SQLException e){
        			e.printStackTrace();
        		}
        		
		return true;
	}
	
	public List<Authors> lister() {
        List<Authors> Authors = new ArrayList<Authors>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT a.firstname, a.lastname, t.name FROM author a,team t WHERE t.team_id = a.team_id");

            while (resultat.next()) {
            	String team_name = resultat.getString("name");
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                

                Authors Author = new Authors();
                Author.setFirstname(firstname);
                Author.setLastname(lastname);
                Author.getTeam().setName(team_name);

                Authors.add(Author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Authors;
    }
	
	
	public List<Authors> search(String field) {
		List<Authors> Authors = new ArrayList<Authors>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
      
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query = "SELECT * FROM authors WHERE firstname like '%"+field+"%' OR lastname like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
            	
            	//Données de la table author
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");          

                Authors author = new Authors();
                author.setFirstname(firstname);
                author.setLastname(lastname);
                
                Authors.add(author);
            }
		}catch (SQLException e) {
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

}
