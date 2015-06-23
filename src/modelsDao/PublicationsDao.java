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
		Statement statement4 = null;
		ResultSet resultat4 = null;
		Publications publication = new Publications();


		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4 = connexion.createStatement();
			String queri = "SELECT DISTINCT publicationId FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ " natural join Types where publicationId="+id;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				
				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ id ;
				
				String typeName="";
				String resume="";
				String iconName="";
				String date="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				iconName=resultat4.getString("iconName");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
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
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int ldapId= resultat3.getInt("ldapId");
					String authorLogin = resultat3.getString("login");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(ldapId);
					author.setLogin(authorLogin);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);
				type.setIconName(iconName);

				


				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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
		List <Authors> authors = object.getAuthors();
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
			String query3 = "INSERT INTO Repositories (authorId,publicationId) Values (?,?)";
			PreparedStatement pS3 = connexion.prepareStatement(query3);
			for (int i = 0; i < authors.size(); i++) {
				pS3 = connexion.prepareStatement(query3);
				pS3.setInt(1,authors.get(i).getAuthorId());
				pS3.setInt(2, publicationId);
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
		Connection connexion = null;

		int typeId = object.getType().getTypeId();
		List<Attributes> attributes = object.getType().getAttributes();
		List <Authors> authors = object.getAuthors();
		String date = object.getDate();
		String resume = object.getResume();
		String title = object.getTitle();
		int publicationId = object.getPublicationId();
		try {

			connexion = factory.getConnection();
			String query = "UPDATE Publications SET date=?,typeId=?,resume=?,title=? WHERE publicationId="+publicationId;
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1, date);
			preparedStatement.setInt(2, typeId);
			preparedStatement.setString(3, resume);
			preparedStatement.setString(4, title);
			preparedStatement.executeUpdate();

			String query2 = "UPDATE DataPublications SET datas=?,attributeId=?,typeId=? where publicationId="+publicationId;
			for (int i = 0; i < attributes.size(); i++) {
				PreparedStatement pS2 = connexion.prepareStatement(query2);
				pS2.setString(1, attributes.get(i).getDatas());
				pS2.setInt(2, attributes.get(i).getAttributeId());
				pS2.setInt(3,typeId);
				pS2.executeUpdate();

			}
			String query3 = "UPDATE Repositories SET authorId=? where publicationId="+publicationId;
			PreparedStatement pS3 = connexion.prepareStatement(query3);
			for (int i = 0; i < authors.size(); i++) {
				pS3 = connexion.prepareStatement(query3);
				pS3.setInt(1,authors.get(i).getAuthorId());
				pS3.executeUpdate();

			}
			
			System.out.print("update");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

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
		Statement statement3 = null;
		ResultSet resultat3 = null;
		Statement statement4= null;
		ResultSet resultat4 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4=  connexion.createStatement();
			String queri = "SELECT DISTINCT publicationId FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types  "
					+ " ORDER BY publicationId DESC ";
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				
				int id = resultat.getInt("publicationId");
				
				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ id ;
				
				String typeName="";
				String resume="";
				String date="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id
						+ " ORDER BY Rang ASC";

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
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int ldapId= resultat3.getInt("ldapId");
					String authorLogin = resultat3.getString("login");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(ldapId);
					author.setLogin(authorLogin);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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
	public List<Publications> lister( String login) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;
		Statement statement4= null;
		ResultSet resultat4 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4=  connexion.createStatement();
			String queri = "SELECT DISTINCT publicationId FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types  "
					+ " where login="+ login 
					+ " ORDER BY publicationId DESC ";
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				
				int id = resultat.getInt("publicationId");
				
				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ id ;
				
				String typeName="";
				String resume="";
				String date="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id
						+ " ORDER BY Rang ASC";

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
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int ldapId= resultat3.getInt("ldapId");
					String authorLogin = resultat3.getString("login");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(ldapId);
					author.setLogin(authorLogin);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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
		Statement statement4= null;
		ResultSet resultat4 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4=  connexion.createStatement();
			String queri = "SELECT DISTINCT publicationId FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types  "
					+ " ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				
				int id = resultat.getInt("publicationId");
				
				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ id ;
				
				String typeName="";
				String resume="";
				String date="";
				String iconName="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				iconName = resultat4.getString("iconName");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id
						+ " ORDER BY Rang ASC";

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
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int ldapId= resultat3.getInt("ldapId");
					String authorLogin = resultat3.getString("login");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(ldapId);
					author.setLogin(authorLogin);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);
				type.setIconName(iconName);

				

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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
		Statement statement4= null;
		ResultSet resultat4 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4 = connexion.createStatement();
			String queri = "SELECT DISTINCT publicationId FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ "natural join Types where "
					+ " ldapId="+ldapId
					+ " ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
int id = resultat.getInt("publicationId");
				
				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ id ;
				
				String typeName="";
				String resume="";
				String date="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id
						+ " ORDER BY Rang ASC";

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
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int aldapId= resultat3.getInt("ldapId");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(aldapId);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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
		Statement statement4 = null;
		ResultSet resultat4 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4 = connexion.createStatement();
			String queri = "SELECT DISTINCT publicationId FROM  Repositories"
					+ " natural join Publications "
					+ " natural join Authors "
					+ " natural join Types "
					+ "where teamId="+teamId
					+ " ORDER BY publicationId DESC "
					+ "LIMIT " + i + " , " + j;
			resultat = statement.executeQuery(queri);
			while (resultat.next()) {
				int id = resultat.getInt("publicationId");
				
				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ id ;
				
				String typeName="";
				String resume="";
				String date="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + id
						+ " ORDER BY Rang ASC";

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
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int ldapId= resultat3.getInt("ldapId");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(ldapId);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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

	public List<Publications> search(String s) {
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
			String queri = "SELECT DISTINCT * FROM  Repositories"
					+ " natural join Publications " + " natural join Authors "
					+ "natural join Types " + "WHERE title like '%" + s + "%'"
					+ " ORDER BY publicationId DESC ";

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
				String query2 = "select * from Repositories "
						+ " natural join Author where publicationId=" + id;
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat.getInt("authorId");
					String authorFirstName = resultat.getString("firstName");
					String authorLastName = resultat.getString("lastName");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

	

				Publications publication = new Publications();
				publication.setId(id);
				publication.setType(type);
				publication.setAuthors(authors);
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

	public List<Integer> research(String reqPubliName, String reqDateFrom, String reqDateTo, String reqResume, int[] reqAuthors, int reqType, int reqTeam, String[] reqKeyWords) {

		Connection connexion = null;
		// Statement statement = null;
		ArrayList<Integer> publicationsId = new ArrayList<Integer>();

		PreparedStatement preparedStatement = null;

		try {
			connexion = factory.getConnection();
			// statement = connexion.createStatement();

			String requetePart1_Normal = "SELECT * FROM publications";
			String requetePart1_Author = "SELECT DISTINCT publications.publicationId FROM publications, repositories, authors";
			String requetePart2 = " WHERE publications.publicationId = repositories.publicationId AND authors.authorId = repositories.authorId AND ";
			String requeteKeyWords = "(title LIKE ? OR resume LIKE ?)";
			String requetePreAuthor = "publications.publicationId = repositories.publicationId AND authors.authorId = repositories.authorId";
			String requeteFirstAuthor = " repositories.authorId = ?";
			String requeteMultipleAuthor = " AND repositories.publicationId IN (SELECT repositories.publicationId FROM repositories WHERE repositories.authorId = ?";
			String requeteAuthorEnd = ")";
			String requeteDateFrom = "date > ?";
			String requeteDateTo = "date < ?";
			String requeteName = "title LIKE ?";
			String requeteResume = "resume LIKE ?";
			String requeteType = "typeId=?";
			String requeteTeam = "teamId=?";
			String requeteAnd = " AND ";
			String requeteOr = " OR ";
			boolean and = false;
			boolean or = false;
			int i = 1;
			String requeteToExecute = null;

//CONSTRUIT LA REQUETE
			requeteToExecute = requetePart1_Author + requetePart2;

			
			if (!reqPubliName.isEmpty()) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteName;
				and = true;
			}

			if (reqResume!=null) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteResume;
				and = true;

			}

			if (reqDateFrom!=null && !reqDateFrom.isEmpty()) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteDateFrom;
				and = true;
			}

			if (reqDateTo!=null && !reqDateTo.isEmpty()) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteDateTo;
				and = true;
			}
							
			if (reqAuthors!=null) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				//requeteToExecute += requetePreAuthor;
				and = true;
				
				requeteToExecute += requeteFirstAuthor;
				
				for(int j=1;j<reqAuthors.length;j++){					
					requeteToExecute += requeteMultipleAuthor;					
				}
				for(int k=1;k<reqAuthors.length;k++){
					requeteToExecute += requeteAuthorEnd;
				}
			}
			
			if (reqType!=0) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteType;
				and = true;				
			}
			
			if (reqTeam!=0) {
				if (and) {
					requeteToExecute += requeteAnd;
				}
				requeteToExecute += requeteTeam;
				and = true;				
			}
			
			if(reqKeyWords != null){
				if (and) {
					requeteToExecute += requeteAnd;
				}
				
					for(int j = 0; j < reqKeyWords.length; j++){
						if (or) {
							requeteToExecute += requeteOr;
						}
						
						requeteToExecute += requeteKeyWords;
						or = true;
					}
				
				and = true;			
			  }

			preparedStatement = connexion.prepareStatement(requeteToExecute);

//REMPLACEMENT DES ? DANS LES PREPARESTATEMENT
			

			if (!reqPubliName.isEmpty()) {
				preparedStatement.setString(i, "%" + reqPubliName + "%");
				i++;
			}

			if (reqResume!=null) {
				preparedStatement.setString(i, "%" + reqResume + "%");
				i++;
			}
			
			if (reqDateFrom!=null && !reqDateFrom.isEmpty()) {
				preparedStatement.setString(i, reqDateFrom);
				i++;
			}
			
			if (reqDateTo!=null && !reqDateTo.isEmpty()) {
				preparedStatement.setString(i, reqDateTo);
				i++;
			}
			
			if (reqAuthors!=null) {
				for(int j=0;j<reqAuthors.length;j++){
					preparedStatement.setInt(i, reqAuthors[j] );
					i++;
				}
			}
			
			if (reqType!=0) {
				preparedStatement.setInt(i, reqType );
				i++;
			}	
			
			if (reqTeam!=0) {
				preparedStatement.setInt(i, reqTeam );
				i++;
			}	
			
			if(reqKeyWords != null){

				for(int j = 0; j < reqKeyWords.length; j++){
					preparedStatement.setString(i, "%" +reqKeyWords[j] + "%");
					i++;
					preparedStatement.setString(i,  "%" + reqKeyWords[j] + "%");
					i++;
				}
			}
			
			
			
			ResultSet resultat = preparedStatement.executeQuery();

			
			while (resultat.next()) {
				int publicationId = resultat.getInt("publicationId");
				publicationsId.add(publicationId);
				/*
				String resume = resultat.getString("resume");
				String title = resultat.getString("title");
				String date = resultat.getString("date");
				//String author = resultat.getString("author");
				int authorId = resultat.getInt("authorId");
				String firstName = resultat.getString("firstName");
				String lastName = resultat.getString("lastName");
				int typeId = resultat.getInt("typeId");
				String typeName = resultat.getString("lastName");
				//String attributes = resultat.getString("attributes");
				
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				//type.setAttributes(attributes);
				
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
				
				*/
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publicationsId;
	}
	
	public List<Publications>listeLoneLy(int pubId) {
		List<Publications> publications = new ArrayList<Publications>();

		Connection connexion = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet resultat = null;
		ResultSet resultat2 = null;
		Statement statement3 = null;
		ResultSet resultat3 = null;
		Statement statement4 = null;
		ResultSet resultat4 = null;

		try {
			connexion = factory.getConnection();
			statement = connexion.createStatement();
			statement2 = connexion.createStatement();
			statement3 = connexion.createStatement();
			statement4 = connexion.createStatement();

				String req= "SELECT * FROM Publications "
						+ "natural join Types where "
						+ "publicationId ="+ pubId ;
				
				String typeName="";
				String resume="";
				String date="";
				String title="";
				int typeId=0;
				
				resultat4 = statement4.executeQuery(req);
				while(resultat4.next()){
				typeName = resultat4.getString("typeName");
				typeId = resultat4.getInt("typeId");
				resume = resultat4.getString("resume");
				date = resultat4.getString("date");
				title = resultat4.getString("title");
				}
				String query = "select * from DataPublications "
						+ "DP join TypeHasAttributes "
						+ "T on (DP.typeId=T.typeId "
						+ "and DP.attributeId=T.attributeId) "
						+ "join Attributes A on "
						+ "(T.attributeId=A.attributeId) "
						+ "where publicationId = " + pubId;

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
						+ " Authors  A where R.publicationId=" + pubId
						+ " and R.authorId = A.authorId";
				resultat3 = statement3.executeQuery(query2);
				List<Authors> authors = new ArrayList<Authors>();
				while (resultat3.next()) {
					int authorId = resultat3.getInt("authorId");
					
					String authorFirstName = resultat3.getString("firstName");
					String authorLastName = resultat3.getString("lastName");	
					int ldapId= resultat3.getInt("ldapId");
					String authorLogin = resultat3.getString("login");
					Authors author = new Authors();
					author.setAuthorId(authorId);
					author.setFirstname(authorFirstName);
					author.setLastname(authorLastName);
					author.setLdapId(ldapId);
					author.setLogin(authorLogin);
					authors.add(author);

				}
				Types type = new Types();
				type.setTypeId(typeId);
				type.setTypeName(typeName);
				type.setAttributes(attributes);

				

				Publications publication = new Publications();
				publication.setId(pubId);
				publication.setType(type);
				publication.setAuthors(authors);
				publication.setResume(resume);
				publication.setDate(date);
				publication.setTitle(title);
				publications.add(publication);
				

			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return publications;
	}

}
