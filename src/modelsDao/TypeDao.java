package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Attributes;
import beans.Authors;
import beans.Types;

public class TypeDao extends Dao<Types>{
	 private DAOFactory factory;
	
	 public TypeDao(DAOFactory daoFactory) {
		
		// TODO Auto-generated constructor stub
		this.factory = daoFactory;
	}


	@Override
	public Types find(int id) {
		// TODO Auto-generated method stub
		Types type = new Types();
		List<Attributes> attributes = new ArrayList<Attributes>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query= "SELECT * FROM TypeHasAttributes "
					+ "natural join Types "
					+ "natural join Attributes "
					+ " where typeId="+id;
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        int i =0;
	        String typeName="";
	        while(resultat.next()){
	        	i++;
	        if (i==1) typeName = resultat.getString("typeName");
	       	String attributeName = resultat.getString("attributeName");
	       	int attributeId = resultat.getInt("attributeId");
	       	String attributeNature= resultat.getString("attributeNature");
	        Attributes attribute = new Attributes();
	        attribute.setAttributeName(attributeName);
	        attribute.setAttributeId(attributeId);
	        attribute.setAttributeNature(attributeNature);
	        attributes.add(attribute);
	        }
	      
	        type.setAttributes(attributes);
	        type.setTypeName(typeName);
	        type.setTypeId(id);
	        
		
	}
		catch (SQLException e) {
            e.printStackTrace();
		}
		return type;
	}

	
	@Override
	public boolean create(Types object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Types object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Types object) {
		// TODO Auto-generated method stub
		return false;
	}
 
	public List<Types> lister(){
		List<Types>types = new ArrayList<Types>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try{
        	connexion=factory.getConnection();
        	String query = "SELECT * FROM Types ";
        	statement = connexion.createStatement();
        	resultat=statement.executeQuery(query);
        	while(resultat.next()){
        		int typeId= resultat.getInt("typeId");
        		String typeName = resultat.getString("typeName");
        		Types type = new Types();
        		type.setTypeName(typeName);
        		type.setTypeId(typeId);
        		types.add(type);
        	}
        	
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        return types;
		
	}
}
