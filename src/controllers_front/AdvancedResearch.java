package controllers_front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Authors;
import beans.Publications;
import beans.Types;
import beans.Teams;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;
import modelsDao.TeamsDao;

/**
 * Servlet implementation class AdvancedResearch
 */
@WebServlet("/AdvancedResearch")
public class AdvancedResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public String cssContent = "advanced-search.css";
	public String content= "advancedSearch.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedResearch() {
        super();
        // TODO Auto-generated constructor stub
    }
 
 
    public String template= "publication.jsp";
    private PublicationsDao publicationsDao;
    private AuthorsDao authorDao;
    private TypeDao typeDao;
    private TeamsDao teamsDao;  

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.publicationsDao = factory.getPublications();
         this.authorDao = factory.getAuthors();
         this.typeDao = factory.getType();
         this.teamsDao = factory.getTeams();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       // request.setAttribute("Publications", PublicationsDao.research("roland"));
		List<Authors> authors = authorDao.lister();
		List<Types> types = typeDao.lister();
		List<Teams> teams = teamsDao.lister();
		request.setAttribute("authors", authors);
		request.setAttribute("types", types);
		request.setAttribute("teams", teams);
		request.setAttribute("cssContent",cssContent);
		request.setAttribute("content",content);
		getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	}

}

