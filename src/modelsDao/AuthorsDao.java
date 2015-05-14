package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Authors;

public class AuthorsDao extends Dao<Authors>{
	
	 private EntityFactory factory;

	    public AuthorsDao(EntityFactory daoFactory) {
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
			String query= "SELECT * FROM Author where eldap_id="+id;
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	     // Récupération des données
            while (resultat.next()) {
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                int author_id=resultat.getInt("author_id");
                int eldap_id=resultat.getInt("eldap_id");
                int team_id= resultat.getInt("team_id");
                
               author = new Authors();
               author.setFirstname(firstname);
               author.setLastname(lastname);
               author.setEldap_id(eldap_id);
               author.setTeam_id(team_id);
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
        int team_id=object.getTeam_id();
        int eldap_id=object.getEldap_id();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Author (firstname,lastname,team_id,eldap_id) VALUES (?,?,?,?)";
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
