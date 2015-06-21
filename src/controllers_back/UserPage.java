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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPage() {
        super();
        // TODO Auto-generated constructor stub
    }

    private TeamsDao TeamsDao;
    private PublicationsDao PublicationsDao;
    private AuthorsDao AuthorsDao;
    private TypeDao TypeDao;

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.TeamsDao = factory.getTeams();
         this.PublicationsDao = factory.getPublications();
         this.AuthorsDao = factory.getAuthors();
         this.TypeDao = factory.getType();
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		
		request.setAttribute("session", s);
		
		String ldapId = request.getParameter("ldapId");
		int i = Integer.parseInt(ldapId);
		request.setAttribute("content", content);
		request.setAttribute("ldapId", i);
		
		//Chiffres-clés
		request.setAttribute("team", TeamsDao.teamOfAuthor(i));
		request.setAttribute("teamCount", TeamsDao.countAll());
		request.setAttribute("pubCount", PublicationsDao.countAll());
		request.setAttribute("authorCount", AuthorsDao.countAll());
		request.setAttribute("typeCount", TypeDao.countAll());
		
        getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
