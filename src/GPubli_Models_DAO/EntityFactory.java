/**
package GPubli_Models_DAO;

import java.sql.Connection;

public class EntityFactory {
	public Connection connection;
	
	public EntityFactory(){
		
	}
	
	public DAO getEntity(String entity) {

		if(entity==null)return null;
		else if (entity.equalsIgnoreCase("Authors")){
			return new Authors_DAO(connection);
		}
	}

}*/
