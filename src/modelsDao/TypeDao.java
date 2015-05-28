package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Teams;
import beans.Type;

public class TypeDao extends Dao<Type>{
	
	private DAOFactory factory;
	public TypeDao(DAOFactory daoFactory) {	
		// TODO Auto-generated constructor stub
		this.factory = daoFactory;
	}


	@Override
	public Type find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean create(Type object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Type object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Type object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Type> search(String field) {
		List<Type> Types = new ArrayList<Type>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
      
		// TODO Auto-generated method stub
		try{
			connexion=factory.getConnection();
			String query = "SELECT typeName FROM types WHERE typeName like '%"+field+"%'";
			
			statement = connexion.createStatement();
	        resultat = statement.executeQuery(query);
	        
	        // Récupération des données
            while (resultat.next()) {
                          
            	//Données de la table type
                String name = resultat.getString("typeName");          
                
                Type Type = new Type();
                Type.setName(name);
                
                Types.add(Type);
            }
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return Types;
	}

}
