package connexionLdap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beans.*;
import modelsDao.*;
import connexionLdap.LDAPObject;
import connexionLdap.LDAPaccess;
import controllers_front.Home;

/**
 * Servlet implementation class Connexion
 */
@WebServlet
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }
    private AuthorsDao authorDao;
   // public String content="connexion.jsp";

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.authorDao = factory.getAuthors();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("content", content);
		this.getServletContext().getRequestDispatcher("/front-office/authentification.jsp").include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s;
		String l = request.getParameter("login");
		String p = request.getParameter("password");
		/*LDAPObject reponse =null;
		try {
			 reponse =LDAPaccess.LDAPget(l, p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			int id= Integer.parseInt(reponse.getNumber());
		//
			if(author==null){
				Authors nwAuthor = new Authors();
				nwAuthor.setLdapId(id);
				String firstname = reponse.getNom().split(" ")[0];
				nwAuthor.setFirstname(firstname);
				nwAuthor.setLastname(reponse.getNomFamille());
				authorDao.create(nwAuthor);
				s = request.getSession();
				Authors createSessionAuthor= authorDao.find(nwAuthor.getLdapId());
				s.setAttribute("authorId",createSessionAuthor.getAuthorId() ); 
				s.setAttribute("ldapId",createSessionAuthor.getLdapId() );
				s.setAttribute("firstname",createSessionAuthor.getFirstname()); 
				s.setAttribute("name", createSessionAuthor.getLastname());
			}*/
		//	else{
		int id =8329;
		Authors author= authorDao.find(id);
				s = request.getSession();
				s.setAttribute("connected", "true");
				s.setAttribute("authorId",author.getAuthorId() );
				s.setAttribute("ldapId", author.getLdapId());
				s.setAttribute("firstname", author.getFirstname());
				s.setAttribute("name", author.getLastname());
				 
				
			//}
			response.sendRedirect("/GPubli-Project/home");
			
		
	}

	}
