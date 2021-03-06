package controllers_back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.DataSource.mysql.DataSource;

import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String content = "users.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private AuthorsDao authorDao;
    
    public void init() throws ServletException {
      	 DAOFactory factory = DAOFactory.getInstance();
           this.authorDao = factory.getAuthors();
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Hashtable<String, String>> listTeams = new ArrayList<Hashtable<String, String>>();
		
		try {
			DataSource ds = DataSource.getInstace();
			Connection conn = ds.getConnection();
			Statement stmtrsListTeam = conn.createStatement();
	
			// Requête
			String sqlTeams = "SELECT teamName, teamId FROM Teams";
			
	
			// Résultats de la requête
			ResultSet rslTeams = stmtrsListTeam.executeQuery(sqlTeams);
	
			// Stocage des données
			while (rslTeams.next()) {
				String teamName = rslTeams.getString("teamName");
				String teamId = rslTeams.getString("teamId");
				
				Hashtable<String, String> listTeam = new Hashtable<String, String>();				
				listTeam.put("name", teamName);
				listTeam.put("value", teamId);
				
				listTeams.add(listTeam);
			}

			// Close
			rslTeams.close();		
			stmtrsListTeam.close();
			conn.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		JSONArray json = new JSONArray(listTeams);
		
		
		request.setAttribute("json", json);
		request.setAttribute("infoAuthor", authorDao.lister());
		request.setAttribute("content", content);
		
		getServletContext().getRequestDispatcher("/back-office/template.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
