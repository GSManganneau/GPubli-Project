package modelsDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Authors;
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
	
	public List<Type> lister() {
		// TODO Auto-generated method stub
        List<Type> Types = new ArrayList<Type>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = factory.getConnection();
            statement = connexion.createStatement();
            resultat  = statement.executeQuery("SELECT * FROM type");

            while (resultat.next()) {
            	int type_id = resultat.getInt("type_id");
            	String name = resultat.getString("name");
                
                //Nom des auteurs
                Type type = new Type();
                type.setType_id(type_id);
                type.setName(name); 
                
                Types.add(type);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Types;
	}

}
