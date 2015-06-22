package controllers_back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelsDao.AuthorsDao;
import modelsDao.TeamsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String cssContent = "index.css";
	public String content = "index.jsp";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private TeamsDao teamDao;
    private PublicationsDao publicationDao;
    private AuthorsDao authorDao;
    private TypeDao typeDao;
    
    public void init() throws ServletException {
   	 DAOFactory factory = DAOFactory.getInstance();
        this.teamDao = factory.getTeams();
        this.publicationDao = factory.getPublications();
        this.authorDao = factory.getAuthors();
        this.typeDao = factory.getType();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Chiffres-clés
		request.setAttribute("teamCount", teamDao.countAll());
		request.setAttribute("pubCount", publicationDao.countAll());
		request.setAttribute("authorCount", authorDao.countAll());
		request.setAttribute("typeCount", typeDao.countAll());
		
		request.setAttribute("cssContent", cssContent);
		request.setAttribute("content", content);
		
		getServletContext().getRequestDispatcher("/back-office/template.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
