package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Attributes;

public class AttributesDao extends Dao<Attributes>{
	
	private DAOFactory factory;
	
	public AttributesDao(DAOFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.factory = daoFactory;
	}

	@Override
	public Attributes find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean create(Attributes object) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Attributes object) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Attributes object) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Attributes> lister(int typeId) {
		// TODO Auto-generated method stub
        List<Attributes> Attributes = new ArrayList<Attributes>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat  = statement.executeQuery("SELECT a.*, ta.rang FROM Types t NATURAL JOIN TypeHasAttributes ta "
            		+ "NATURAL JOIN Attributes a "
            		+ "WHERE t.typeId ="+typeId);
            
            while (resultat.next()) {
                String attributeName = resultat.getString("attributeName");
                int attributeId = resultat.getInt("attributeId");
                int rang = resultat.getInt("rang");
                
                Attributes attribute = new Attributes();
                attribute.setAttributeId(attributeId);
                attribute.setAttributeName(attributeName);
                attribute.setCount(rang);
                
                Attributes.add(attribute);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Attributes;
	}
	
}
