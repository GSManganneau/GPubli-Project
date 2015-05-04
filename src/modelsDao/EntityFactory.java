
package modelsDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityFactory {
	public Connection connection;
	
	public EntityFactory(){
		
	        try {
	            Class.forName("com.postgresql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }

	        try {
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GPubli", "root", "");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
		
	}
	
	public AuthorsDao getAuthors() {
			return new AuthorsDao(connection);
		}
	public PublicationsDao getPublications() {
		return new PublicationsDao(connection);
	}
	public TeamsDao getTeams() {
		return new TeamsDao(connection);
	}
	public TypeDao getType() {
		return new TypeDao(connection);
	}
	
	public PublishedDao getPublished() {
		return new PublishedDao(connection);
	}
	}


