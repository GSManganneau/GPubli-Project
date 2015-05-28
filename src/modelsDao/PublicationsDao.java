package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Authors;
import beans.Publications;
import beans.Type;

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
  
        int type =object.getType().getType_id();
        String date=object.getDate();
        String resume =object.getResume();
        String journal = object.getJournal();
        String book_title= object.getBook_title();
        String title = object.getTitle();
        String url = object.getUrl();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Publication (date,type_id,resume,book_title,title,journal,url) VALUES (?,?,?,?,?,?,?)";
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
        List<Publications> publications = new ArrayList<Publications>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT *,t.name FROM  Publication p, Type t where p.type_id=t.type_id ORDER BY publication_id DESC");

            while (resultat.next()) {
                int type_id = resultat.getInt("type_id");
                String type_name= resultat.getString("name");
               
                Type type = new Type();
                type.setType_id(type_id);
                type.setName(type_name);
                
                String resume = resultat.getString("resume");
                String journal= resultat.getString("journal");
                String date=resultat.getString("date");
                String book_title= resultat.getString("book_title");
                String title = resultat.getString("title");
                
                Publications publication = new Publications();
                publication.setType(type);
                publication.setResume(resume);
                publication.setJournal(journal);
                publication.setDate(date);
                publication.setBook_title(book_title);
                publication.setTitle(title);
               

                publications.add(publication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publications;
    }
	
	public List<Publications> search(String field) {
		List<Publications> Publications = new ArrayList<Publications>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
      
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query = "SELECT * FROM publications WHERE title like '%"+field+"%' OR resume like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
                          
                //Données de la table publication
                String title = resultat.getString("title");
                String resume = resultat.getString("resume");           
                
                Publications Publication = new Publications();
                Publication.setTitle(title);
                Publication.setResume(resume);
                
                Publications.add(Publication);
            }
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Publications;
	}


}
