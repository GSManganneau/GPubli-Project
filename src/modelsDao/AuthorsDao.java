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
			String query= "SELECT * FROM Author where ldapId="+id;
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
        int teamId=object.getTeam().getTeamId();
        int ldapId=object.getLdapId();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Author (firstname,lastname,teamId,ldapId) VALUES (?,?,?,?)";
        			PreparedStatement preparedStatement = connexion.prepareStatement(query);
        			preparedStatement.setString(1,firstname);
    	            preparedStatement.setString(2,lastname);
    	            preparedStatement.setInt(3,teamId);
    	            preparedStatement.setInt(4,ldapId);
    	           
    	            
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
            resultat = statement.executeQuery("SELECT a.firstname, a.lastname, t.name FROM author a,team t WHERE t.teamId = a.teamId");

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
