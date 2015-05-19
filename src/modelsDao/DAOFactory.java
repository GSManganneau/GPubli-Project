
package modelsDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

	    private String url;
	    private String username;
	    private String password;

	    DAOFactory(String url, String username, String password) {
	        this.url = url;
	        this.username = username;
	        this.password = password;
	    }

	    public static DAOFactory getInstance() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {

	        }

	        DAOFactory instance = new DAOFactory(
	                "jdbc:mysql://localhost:3306/GPubli","root","root");
	        return instance;
	    }

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }
	
	public AuthorsDao getAuthors() {
			return new AuthorsDao(this);
		}
	public PublicationsDao getPublications() {
		return new PublicationsDao(this);
	}
	public TeamsDao getTeams() {
		return new TeamsDao(this);
	}
	public TypeDao getType() {
		return new TypeDao(this);
	}
	
	public PublishedDao getPublished() {
		return new PublishedDao(this);
	}
	}


