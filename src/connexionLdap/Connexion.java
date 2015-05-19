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
    private AuthorsDao AuthorsDao;

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.AuthorsDao = factory.getAuthors();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("eeeee");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String l = request.getParameter("login");
		String p = request.getParameter("password");
		LDAPObject reponse =null;
		try {
			 reponse =LDAPaccess.LDAPget(l, p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			int id= Integer.parseInt(reponse.getNumber());
			Authors author= AuthorsDao.find(id);
			if(author==null){
				Authors nwAuthor = new Authors();
				nwAuthor.setEldap_id(id);
				String firstname = reponse.getNom().split(" ")[0];
				nwAuthor.setFirstname(firstname);
				nwAuthor.setLastname(reponse.getNomFamille());
				AuthorsDao.create(nwAuthor);
				HttpSession s = request.getSession();
				Authors createSessionAuthor= AuthorsDao.find(nwAuthor.getEldap_id());
				s.setAttribute("author_id",createSessionAuthor.getAuthor_id() ); 
				s.setAttribute("ldap_id",createSessionAuthor.getEldap_id() );
				s.setAttribute("firstname",createSessionAuthor.getFirstname() ); 
				request.setAttribute("session",s);
				getServletContext().getRequestDispatcher("/Publications.jsp").include(request, response);
			}
			else{
				HttpSession s = request.getSession();
				s.setAttribute("author_id",author.getAuthor_id() );
				s.setAttribute("ldap_id", author.getEldap_id());
				s.setAttribute("firstname", author.getFirstname());
				request.setAttribute("session",s);
				getServletContext().getRequestDispatcher("/Publications.jsp").include(request, response);
				
			}
			
		
	}

}
