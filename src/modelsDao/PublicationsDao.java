package modelsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controllers_front.Home;
import beans.Attributes;
import beans.Authors;
import beans.Publications;
import beans.Types;

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

		int typeId = object.getType().getTypeId();
		List<Attributes> attributes = object.getType().getAttributes();
		String date = object.getDate();
		String resume = object.getResume();
		String title = object.getTitle();
		int publicationId = 0;

		try {

			connexion = factory.getConnection();
			String query = "INSERT INTO  Publications (date,typeId,resume,title) VALUES (?,?,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(
					query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, date);
			preparedStatement.setInt(2, typeId);
			preparedStatement.setString(3, resume);
			preparedStatement.setString(4, title);
			preparedStatement.executeUpdate();
			ResultSet result = preparedStatement.getGeneratedKeys();
			result.next();
			publicationId = result.getInt(1);
			result.close();

			String query2 = "INSERT INTO DataPublications (publicationId,datas,attributeId,typeId) Values (?,?,?,?)";
			for (int i = 0; i < attributes.size(); i++) {
				PreparedStatement pS2 = connexion.prepareStatement(query2);
				pS2.setInt(1, publicationId);
				pS2.setString(2, attributes.get(i).getDatas());
				pS2.setInt(3, attributes.get(i).getAttributeId());
				pS2.setInt(4, typeId);
				pS2.executeUpdate();

			}
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
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM  Publications "
					+ "natural join Types ORDER BY publicationId DESC");
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");

				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id;

				resultat2 = statement2.executeQuery(query);
				List<Attributes> attributes = new ArrayList<Attributes>();
				while (resultat2.next()) {
					String attributeName = resultat2.getString("attributeName");
					String data = resultat2.getString("datas");
					Attributes attribute = new Attributes();

					attribute.setAttributeName(attributeName);
					attribute.setDatas(data);
					attributes.add(attribute);

				}

				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
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

	public List<Publications> lister(int i, int j) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			String queri = "SELECT * FROM  Publications "
					+ "natural join Types ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");

				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id;

				resultat2 = statement2.executeQuery(query);
				List<Attributes> attributes = new ArrayList<Attributes>();
				while (resultat2.next()) {
					String attributeName = resultat2.getString("attributeName");
					String data = resultat2.getString("datas");
					Attributes attribute = new Attributes();

					attribute.setAttributeName(attributeName);
					attribute.setDatas(data);
					attributes.add(attribute);

				}

				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Publications publication = new Publications();
				publication.setId(id);
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

	public boolean checkNextPage(int currentPage, int elementsByPage) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		boolean nextPage = false;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT * FROM  Publications "
					+ "natural join Types ORDER BY publicationId DESC "
					+ "LIMIT " + currentPage * elementsByPage + " , "
					+ elementsByPage * (currentPage + 1);
			resultat = statement.executeQuery(query);
			if (resultat.next())
				nextPage = true;
			else
				nextPage = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextPage;
	}

	public int countNumberPage(int elementsByPage) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		int numberOfPage = 0;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT COUNT(*) FROM Publications";
			resultat = statement.executeQuery(query);
			resultat.next();
			int numberOfResults = resultat.getInt(1);
			if (numberOfResults % elementsByPage > 0)
				numberOfPage = ((int) (numberOfResults / elementsByPage)) + 1;
			else
				numberOfPage = ((int) (numberOfResults / elementsByPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfPage;

	}

	public List<Publications> search(String field) {
		// TODO Auto-generated method stub
		List<Publications> Publications = new ArrayList<Publications>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = factory.getConnection();
			String query = "SELECT * FROM publications WHERE title like '%"
					+ field + "%'";

			statement = connexion.createStatement();
			resultat = statement.executeQuery(query);

			// Récupération des données
			while (resultat.next()) {

				// Données de la table team
				String title = resultat.getString("title");
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");

				Publications Publication = new Publications();
				Publication.setTitle(title);
				Publication.setResume(resume);
				Publication.setDate(date);

				Publications.add(Publication);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Publications;
	}

	public int attributeId(String s) {
		int attributeId = 0;
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT (attributeId) FROM Attributes WHERE (attributeName ="
					+ s;
			resultat = statement.executeQuery(query);
			while (resultat.next()) {
				attributeId = resultat.getInt("attributeId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attributeId;
	}

	/*
	 * public boolean createData( int publicationId, int typeId, String data){
	 * Connection connexion = null; Statement statement = null; ResultSet
	 * resultat = null; try{} return false;
	 */

	public Publications count(String field) {
		// TODO Auto-generated method stub
		Publications Publication = new Publications();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		int i;

		try {
			connexion = factory.getConnection();
			String query = "SELECT COUNT(*) AS nombre FROM publications WHERE title like '%"
					+ field + "%'";

			statement = connexion.createStatement();
			resultat = statement.executeQuery(query);

			// Récupération des données
			while (resultat.next()) {
				String nombre = resultat.getString("nombre");

				i = Integer.parseInt(nombre);
				Publication.setCount(i);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Publication;

	}

}
