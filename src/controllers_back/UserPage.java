package controllers_back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelsDao.AuthorsDao;
import modelsDao.PublicationsDao;
import modelsDao.TeamsDao;
import modelsDao.TypeDao;
import modelsDao.DAOFactory;


/**
 * Servlet implementation class Listing_author
 */
@WebServlet("/UserPage")
public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String content = "user.jsp";
	public String cssContent = "user.css";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPage() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		
		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else {
		
		request.setAttribute("session", s);
		
		String ldapId = request.getParameter("ldapId");
		int i = Integer.parseInt(ldapId);
		request.setAttribute("cssContent", cssContent);
		request.setAttribute("content", content);
		request.setAttribute("ldapId", i);
		
		request.setAttribute("publications",publicationDao.listPublicationAuthor(3, 3, i));
		
		
		//Chiffres-clés
		request.setAttribute("team", teamDao.teamOfAuthor(i));
		request.setAttribute("teamCount", teamDao.countAll());
		request.setAttribute("pubCount", publicationDao.countAll());
		request.setAttribute("authorCount", authorDao.countAll());
		request.setAttribute("typeCount", typeDao.countAll());
		
        getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
        
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
