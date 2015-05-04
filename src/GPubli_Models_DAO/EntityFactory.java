
package GPubli_Models_DAO;

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
	
	public Authors_DAO getAuthors() {
			return new Authors_DAO(connection);
		}
	public Publications_DAO getPublications() {
		return new Publications_DAO(connection);
	}
	public Teams_DAO getTeams() {
		return new Teams_DAO(connection);
	}
	public Type_DAO getType() {
		return new Type_DAO(connection);
	}
	
	public Published_DAO getPublished() {
		return new Published_DAO(connection);
	}
	}


