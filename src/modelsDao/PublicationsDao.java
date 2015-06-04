package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Publications;

public class PublicationsDao extends Dao<Publications> {

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

		int type = object.getType();
		String date = object.getDate();
		String resume = object.getResume();
		String title = object.getTitle();
		String url = object.getUrl();
		try {

			connexion = factory.getConnection();
			String query = "INSERT INTO  Publications (date,type_id,resume,book_title,title,journal,url) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1, date);
			preparedStatement.setInt(2, type);
			preparedStatement.setString(3, resume);
			preparedStatement.setString(5, title);
			preparedStatement.setString(7, url);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
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
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM Publication");

			while (resultat.next()) {
				int type = resultat.getInt("type_id");
				String resume = resultat.getString("resume");

				Publications Publication = new Publications();
				Publication.setType(type);
				Publication.setResume(resume);

				Publications.add(Publication);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Publications;
	}

	public List<Publications> research(String reqPubliName, String reqDate, String reqResume) {
		List<Publications> Publications = new ArrayList<Publications>();
		Connection connexion = null;
		// Statement statement = null;

		PreparedStatement preparedStatement = null;

		try {
			connexion = factory.getConnection();
			// statement = connexion.createStatement();

			/*
			 * String requete_part1 = "SELECT * FROM publication"; String
			 * requete_part2 = " WHERE "; String requete_date =
			 * "date = '"+req_date+"'"; String requete_name =
			 * "title LIKE '%"+req_publi_name+"%'"; String requete_resume =
			 * "resume LIKE '%"+req_resume+"%'"; //String requete_type =
			 * "typeId = '"+req_type+"'"; String requete_and = " AND "; boolean
			 * and = false;
			 */

			/*
			 * if(!req_date.isEmpty()){ if(and){ requete_to_execute +=
			 * requete_and; } requete_to_execute += requete_date; and = true; }
			 * 
			 * if(!requete_name.isEmpty()){ if(and){ requete_to_execute +=
			 * requete_and; } requete_to_execute += requete_name; and = true; }
			 * 
			 * if(!requete_resume.isEmpty()){ if(and){ requete_to_execute +=
			 * requete_and; } requete_to_execute += requete_resume; and = true;
			 * }
			 */

			String requetePart1 = "SELECT * FROM publication";
			String requetePart2 = " WHERE ";
			String requeteDate = "date = ?";
			String requeteName = "title LIKE ?";
			String requeteResume = "resume LIKE ?";
			// String requete_type = "typeId = '"+req_type+"'";
			String requeteAnd = " AND ";
			boolean and = false;
			int i = 1;

			String requeteToExecute = requetePart1 + requetePart2;

			if (!reqDate.isEmpty()) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteDate;
				System.out.println(requeteToExecute);
				and = true;				
			}

			if (!reqPubliName.isEmpty()) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteName;
				and = true;
			}

			if (!reqResume.isEmpty()) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteResume;
				and = true;
				
			}
			
			preparedStatement = connexion.prepareStatement(requeteToExecute);
			
			if (!reqDate.isEmpty()) {
				preparedStatement.setString(i, reqDate);
				i++;
			}
			
			if (!reqPubliName.isEmpty()) {
				preparedStatement.setString(i, "%" + reqPubliName + "%");
				i++;
			}
			
			if (!reqResume.isEmpty()) {
				preparedStatement.setString(i, "%" + reqResume + "%");
				i++;
			}


			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				int publicationId = resultat.getInt("publicationId");
				String resume = resultat.getString("resume");
				String title = resultat.getString("title");
				String date = resultat.getString("date");
				// int typeId = resultat.getInt("typeId");
				String url = resultat.getString("url");

				Publications Publication = new Publications();
				Publication.setId(publicationId);
				Publication.setDate(date);
				Publication.setResume(resume);
				Publication.setTitle(title);
				// Publication.setType(typeId);
				Publication.setUrl(url);

				Publications.add(Publication);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Publications;
	}

}
