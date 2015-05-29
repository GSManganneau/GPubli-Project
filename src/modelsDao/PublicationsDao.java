package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Attributes;
import beans.Authors;
import beans.Publications;
import beans.Types;

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
  
        int type =object.getType().getTypeId();
        List<Attributes> attributes = object.getType().getAttributes();
        String date=object.getDate();
        String resume =object.getResume();
        String title = object.getTitle();
        String url = object.getUrl();
        		try{
        			
        	            
        			connexion=factory.getConnection();
        			String query= "INSERT INTO  Publications (date,typeId,resume,title,url) VALUES (?,?,?,?,?)";
        			PreparedStatement preparedStatement = connexion.prepareStatement(query);
        			preparedStatement.setString(1,date);
    	            preparedStatement.setInt(2,type);
    	            preparedStatement.setString(3,resume);
    	            preparedStatement.setString(4,title);
    	            preparedStatement.setString(5, url);
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
        Statement statement2=null;
        ResultSet resultat = null;
        ResultSet resultat2	= null;

        try {
            connexion =factory.getConnection();
            statement = connexion.createStatement();
            statement2=connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM  Publications "
            		+ "natural join Types ORDER BY publicationId DESC");
            while (resultat.next()) {
            	String resume = resultat.getString("resume");
                String date=resultat.getString("date");
                String title = resultat.getString("title");
                int id = resultat.getInt("publicationId");
                String typeName= resultat.getString("typeName");
                int typeId= resultat.getInt("typeId");
                
                String query="select * from DataPublications "
                		+ "natural join TypeHasAttributes "
                		+ "natural join Attributes A "
                		+ "natural join Types "
                		+ "WHERE publicationId="+id;
                System.out.print(query);
                resultat2= statement2.executeQuery(query);
                List<Attributes> attributes = new ArrayList<Attributes>();
                while(resultat2.next()){
                	String attributeName = resultat2.getString("attributeName");
                	String data= resultat2.getString("datas");
                	Attributes attribute = new Attributes();
                	
                	attribute.setAttributeName(attributeName);
                	attribute.setDatas(data);
                	attributes.add(attribute);
                	
                } 

                Types type = new Types();
                type.setTypeId(typeId);
                type.setName(typeName);
                type.setAttributes(attributes);
                
                Publications publication = new Publications();
                publication.setType(type);
                publication.setResume(resume);
                publication.setDate(date);
                publication.setTitle(title);
               

                publications.add(publication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publications;
    }


	public List<Publications> search(String field) {
		// TODO Auto-generated method stub
		List<Publications> Publications = new ArrayList<Publications>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

		try{
			connexion=factory.getConnection();
			String query = "SELECT * FROM publications WHERE title like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
                          
            	//Données de la table team
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
