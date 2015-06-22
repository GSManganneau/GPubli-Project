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
		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;
		Publications publication = new Publications();


		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			String queri = "SELECT * FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types where publicationId="+id
					+ " and coAuthorId=0";
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				int ldapId= resultat.getInt("ldapId");

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
				String query2 = "select * from Repositories R,"
						+ " Authors  A where R.publicationId=" + id
						+ " and R.coAuthorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> coAuthors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int coAuthorId = resultat3.getInt("authorId");
					
					String coAuthorFirstName = resultat3.getString("firstName");
					String coAuthorLastName = resultat3.getString("lastName");	
					int coldapId= resultat3.getInt("ldapId");
					Authors coAuthor = new Authors();
					coAuthor.setAuthorId(coAuthorId);
					coAuthor.setFirstname(coAuthorFirstName);
					coAuthor.setLastname(coAuthorLastName);
					coAuthor.setLdapId(coldapId);
					coAuthors.add(coAuthor);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);
				author.setLdapId(ldapId);

				publication.setId(id);
				publication.setType(type);
				publication.setAuthor(author);
				publication.setCoAuthors(coAuthors);
				publication.setResume(resume);
				publication.setDate(date);
				publication.setTitle(title);


			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publication;
	}


	@Override
	public boolean create(Publications object) {
		// TODO Auto-generated method stub
		Connection connexion = null;

		int typeId = object.getType().getTypeId();
		List<Attributes> attributes = object.getType().getAttributes();
		List <Authors> coAuthors = object.getCoAuthors();
		Authors author = object.getAuthor();
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
			String query3 = "INSERT INTO Repositories (authorId,publicationId,coAuthorId) Values (?,?,?)";
			PreparedStatement pS3 = connexion.prepareStatement(query3);
			pS3.setInt(1, author.getAuthorId());
			pS3.setInt(2, publicationId);
			pS3.setInt(3,0);
			pS3.executeUpdate();
			for (int i = 0; i < coAuthors.size(); i++) {
				pS3 = connexion.prepareStatement(query3);
				pS3.setInt(1,0);
				pS3.setInt(2, publicationId);
				pS3.setInt(3, coAuthors.get(i).getAuthorId());
				pS3.executeUpdate();

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
		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		Statement statement3 = null;
		String query = "DELETE FROM Publications where publicationId ="+ object.getPublicationId();
		String query2 = "DELETE FROM DataPublications where publicationId="+object.getPublicationId();
		String query3 = "DELETE FROM Repositories where publicationId="+object.getPublicationId();
		try{
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3= connexion.createStatement();
			statement.executeUpdate(query);
			statement2.executeUpdate(query2);
			statement3.executeUpdate(query3);
			System.out.print("supprimée");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
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
			resultat = statement.executeQuery("SELECT * FROM  Repositories"
					+ " natural join Publications " + " natural join Authors "
					+ "natural join Types ORDER BY publicationId DESC");
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				int ldapId= resultat.getInt("ldapId");

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

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);

				Publications publication = new Publications();
				publication.setType(type);
				publication.setAuthor(author);
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
		Statement statement3 = null;
		ResultSet resultat3 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			String queri = "SELECT * FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types where authorId <> 0 and coAuthorId = 0 "
					+ " ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				int ldapId= resultat.getInt("ldapId");

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
				String query2 = "select * from Repositories R,"
						+ " Authors  A where R.publicationId=" + id
						+ " and R.coAuthorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> coAuthors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int coAuthorId = resultat3.getInt("authorId");
					
					String coAuthorFirstName = resultat3.getString("firstName");
					String coAuthorLastName = resultat3.getString("lastName");	
					int coldapId= resultat3.getInt("ldapId");
					Authors coAuthor = new Authors();
					coAuthor.setAuthorId(coAuthorId);
					coAuthor.setFirstname(coAuthorFirstName);
					coAuthor.setLastname(coAuthorLastName);
					coAuthor.setLdapId(coldapId);
					coAuthors.add(coAuthor);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);
				author.setLdapId(ldapId);

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthor(author);
				publication.setCoAuthors(coAuthors);
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
	
	public List<Publications> listPublicationAuthor(int i, int j, int ldapId) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			String queri = "SELECT * FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types where authorId <> 0 "
					+ "and coAuthorId = 0 "
					+ "AND ldapId="+ldapId
					+ " ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				int LdapId= resultat.getInt("ldapId");

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
				String query2 = "select * from Repositories R,"
						+ " Authors  A where R.publicationId=" + id
						+ " and R.coAuthorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> coAuthors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int coAuthorId = resultat3.getInt("authorId");
					
					String coAuthorFirstName = resultat3.getString("firstName");
					String coAuthorLastName = resultat3.getString("lastName");	
					int coLdapId= resultat3.getInt("ldapId");
					Authors coAuthor = new Authors();
					coAuthor.setAuthorId(coAuthorId);
					coAuthor.setFirstname(coAuthorFirstName);
					coAuthor.setLastname(coAuthorLastName);
					coAuthor.setLdapId(coLdapId);
					coAuthors.add(coAuthor);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);
				author.setLdapId(LdapId);

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthor(author);
				publication.setCoAuthors(coAuthors);
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
	public List<Publications> listPublicationTeam(int i, int j, int teamId) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			String queri = "SELECT * FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ " natural join Types "
					+ "where teamId="+teamId
					+ " ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				int LdapId= resultat.getInt("ldapId");

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
				String query2 = "select * from Repositories R,"
						+ " Authors  A where R.publicationId=" + id
						+ " and R.coAuthorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> coAuthors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int coAuthorId = resultat3.getInt("authorId");
					
					String coAuthorFirstName = resultat3.getString("firstName");
					String coAuthorLastName = resultat3.getString("lastName");	
					int coLdapId= resultat3.getInt("ldapId");
					Authors coAuthor = new Authors();
					coAuthor.setAuthorId(coAuthorId);
					coAuthor.setFirstname(coAuthorFirstName);
					coAuthor.setLastname(coAuthorLastName);
					coAuthor.setLdapId(coLdapId);
					coAuthors.add(coAuthor);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);
				author.setLdapId(LdapId);

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthor(author);
				publication.setCoAuthors(coAuthors);
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
//pour la page home
	public boolean checkNextPage(int currentPage, int elementsByPage) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		boolean nextPage = false;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT * FROM  Publications "
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
	//pour la page user et team
	public boolean checkNextPage(int currentPage, int elementsByPage,String param,int i) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		boolean nextPage = false;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT * FROM  Repositories "
					+ "natural join Authors"
					+ " natural join Publications"
					+ " where "+param+"="+i
					+ " LIMIT " + currentPage * elementsByPage + " , "
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
	
	//pour les résultats de recherche
	public boolean checkNextPage(int currentPage, int elementsByPage,String s) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		boolean nextPage = false;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT (publicationId) FROM Publications Where title like '%"
					+ s+" %'"
					+ "UNION ALL "
					+ "select (teamId) from Teams where teamName like '%"
					+ s+" %"
					+ "UNION ALL "
					+ "select (authorId) from Authors where firstname like '%"
					+ s+" % or name like '%"
							+ s+ " %"
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
	//pour user et team
	public int countNumberPage(int elementsByPage,String param,int i) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		int numberOfPage = 0;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT COUNT(*) FROM Repositories natural join Authors"
					+ " natural join Publications"
					+ " where "+param+"="+ i;
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
	public int countNumberPage(int elementsByPage,String s) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		int numberOfPage = 0;
		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			String query = "SELECT COUNT(publicationId) FROM Publications Where title like '%"
					+ s+" %'"
					+ "UNION ALL "
					+ "select count(teamId) from Teams where teamName like '%"
					+ s+" %"
					+ "UNION ALL "
					+ "select count(authorId) from Authors where firstname like '%"
					+ s+" % or name like '%"
							+ s+ " %";
			resultat = statement.executeQuery(query);
			int numberOfResults=0;
			while(resultat.next()){
				numberOfResults+=resultat.getInt(1);
			}
			if (numberOfResults % elementsByPage > 0)
				numberOfPage = ((int) (numberOfResults / elementsByPage)) + 1;
			else
				numberOfPage = ((int) (numberOfResults / elementsByPage));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfPage;

	}

	public List<Publications> search(String s, int i, int j) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			String queri = "SELECT * FROM  Repositories"
					+ " natural join Publications " + " natural join Authors "
					+ "natural join Types " + "WHERE title like '%" + s + "%'"
					+ " ORDER BY publicationId DESC " + "LIMIT " + i + " , "
					+ j;

			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");

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
				String query2 = "select * from Repositories "
						+ " natural join Author where publicationId=" + id
						+ " and  authorId <> " + authorId;
				resultat3 = statement3.executeQuery(query2);
				List<Authors> coAuthors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int coAuthorId = resultat.getInt("authorId");
					String coAuthorFirstName = resultat.getString("firstName");
					String coAuthorLastName = resultat.getString("lastName");
					Authors coAuthor = new Authors();
					coAuthor.setAuthorId(coAuthorId);
					coAuthor.setFirstname(coAuthorFirstName);
					coAuthor.setLastname(coAuthorLastName);
					coAuthors.add(coAuthor);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthor(author);
				publication.setCoAuthors(coAuthors);
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
	
	public Publications countAll() {
		// TODO Auto-generated method stub
		Publications Publication = new Publications();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		int i;

		try {
			connexion = factory.getConnection();
			String query = "SELECT COUNT(*) AS nombre FROM publications";

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

	public List<Publications> research(String reqPubliName, String reqDate, String reqResume, Integer reqAuthor) {
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

			String requetePart1_Normal = "SELECT * FROM publications";
			String requetePart1_Author = "SELECT * FROM publications, repositories, authors";
			String requetePart2 = " WHERE ";
			String requetePreAuthor = "publications.publicationId = repositories.publicationId AND authors.authorId = repositories.authorId AND authors.authorId = ?";
			String requeteAuthorId = "authors.authorId = ?";
			String requeteDate = "date = ?";
			String requeteName = "title LIKE ?";
			String requeteResume = "resume LIKE ?";
			// String requete_type = "typeId = '"+req_type+"'";
			String requeteAnd = " AND ";
			boolean and = false;
			int i = 1;
			String requeteToExecute = null;
			
			if (reqAuthor != null) {
				requeteToExecute = requetePart1_Author + requetePart2;
			} else {
				requeteToExecute = requetePart1_Normal + requetePart2;
			}

			
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

			
			
			if (reqAuthor!=null) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requetePreAuthor;
				System.out.println(requeteToExecute);
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
			
			if (reqAuthor!=null) {
				preparedStatement.setInt(i, reqAuthor );
				i++;
			}

			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				int publicationId = resultat.getInt("publicationId");
				String resume = resultat.getString("resume");
				String title = resultat.getString("title");
				String date = resultat.getString("date");
				//String author = resultat.getString("author");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				// int typeId = resultat.getInt("typeId");
				//String url = resultat.getString("url");
				
				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);

				Publications Publication = new Publications();
				Publication.setId(publicationId);
				Publication.setDate(date);
				Publication.setResume(resume);
				Publication.setTitle(title);
				Publication.setAuthor(author);
				// Publication.setType(typeId);
				//Publication.setUrl(url);

				Publications.add(Publication);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Publications;
	}
	
	public List<Publications> listeLoneLy(int PubId) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			String queri = "SELECT * FROM  Repositories "
					+ " natural join Publications "
					+ " natural join Authors "
					+ " natural join Types WHERE publicationId = " + PubId
					+ " ORDER BY publicationId DESC ";
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				String resume = resultat.getString("resume");
				String date = resultat.getString("date");
				String title = resultat.getString("title");
				int id = resultat.getInt("publicationId");
				String typeName = resultat.getString("typeName");
				int typeId = resultat.getInt("typeId");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");

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
				String query2 = "select * from Repositories "
						+ " natural join Authors where publicationId=" + id
						+ " and  authorId <> " + authorId;
				resultat3 = statement3.executeQuery(query2);
				List<Authors> coAuthors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int coAuthorId = resultat.getInt("authorId");
					String coAuthorFirstName = resultat.getString("firstName");
					String coAuthorLastName = resultat.getString("lastName");
					Authors coAuthor = new Authors();
					coAuthor.setAuthorId(coAuthorId);
					coAuthor.setFirstname(coAuthorFirstName);
					coAuthor.setLastname(coAuthorLastName);
					coAuthors.add(coAuthor);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				Authors author = new Authors();
				author.setAuthorId(authorId);
				author.setFirstname(firstName);
				author.setLastname(lastName);

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthor(author);
				publication.setCoAuthors(coAuthors);
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
}
