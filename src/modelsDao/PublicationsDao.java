package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Publications;

public class PublicationsDao extends Dao<Publications>{

	 private DAOFactory factory;

	    PublicationsDao(DAOFactory daoFactory) {
	        this.factory = daoFactory;
	    }


	@Override
	public Publications find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Publications object) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        int id=object.getId();
        int type =object.getType();
        String date=object.getDate();
        String resume =object.getResume();
        String journal = object.getJournal();
        String book_title= object.getBook_title();
        String title = object.getTitle();
        String url = object.getUrl();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Publications (date,type_id,resume,book_title,title,journal,url) VALUES (?,?,?,?,?,?,?)";
        			PreparedStatement preparedStatement = connexion.prepareStatement(query);
        			preparedStatement.setString(1,date);
    	            preparedStatement.setInt(2,type);
    	            preparedStatement.setString(3,resume);
    	            preparedStatement.setString(4,book_title);
    	            preparedStatement.setString(5,title);
    	            preparedStatement.setString(6,journal);
    	            preparedStatement.setString(7, url);
    	          
    	           
    	            
    	            preparedStatement.executeUpdate();

        		}catch(SQLException e){
        			e.printStackTrace();
        		}
        		
		return true;
	}

	@Override
	public boolean update(Publications object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Publications object) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Publications> lister() {
        List<Publications> Publications = new ArrayList<Publications>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM Publication");

            while (resultat.next()) {
                int type = resultat.getInt("type_id");
                String resume = resultat.getString("resume");
                String journal= resultat.getString("journal");

                Publications Publication = new Publications();
                Publication.setType(type);
                Publication.setResume(resume);
                Publication.setJournal(journal);

                Publications.add(Publication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Publications;
    }


}
