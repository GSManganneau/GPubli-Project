
package modelsDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityFactory {

	    private String url;
	    private String username;
	    private String password;

	    EntityFactory(String url, String username, String password) {
	        this.url = url;
	        this.username = username;
	        this.password = password;
	    }

	    public static EntityFactory getInstance() {
	        try {
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {

	        }

	        EntityFactory instance = new EntityFactory(
	                "jdbc:postgresql://localhost:5432/Gpubli","postgres","1gillesleon");
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


