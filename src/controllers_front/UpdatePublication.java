package controllers_front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Publications;
import beans.Types;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TeamsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class UpdatePublication
 */
@WebServlet("/updatepublication")
public class UpdatePublication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String content = "updatePublication.jsp";
	public String jsContent = "addPublicationForm.js";

	private PublicationsDao publicationDao;
	private AuthorsDao authorDao;
	private TeamsDao teamDao;
	private TypeDao typeDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.publicationDao = factory.getPublications();
		this.authorDao = factory.getAuthors();
		this.typeDao = factory.getType();
		this.teamDao = factory.getTeams();

	}
    public UpdatePublication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();

		// Si l'utilsateur n'est pas connecté il est redirigé vers la page
		// connexion

		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else {
			if(request.getParameter("publicationId")!=null){
				int publicationId = Integer.parseInt((String)request.getParameter("publicationId"));
				Publications publication = publicationDao.find(publicationId);
				boolean find =false;
				for(int i=0;i<publication.getAuthors().size() && !find ;i++){
				if(publication.getAuthors().get(i).getAuthorId()==(int)s.getAttribute("authorId")){
					find=true;
					request.setAttribute("publication", publication);
					request.setAttribute("types",typeDao.lister());
					request.setAttribute("session", s);
					request.setAttribute("content",content);
					request.setAttribute("jsContent",jsContent);
					this.getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
				}
			}
			}
			else{
				response.sendRedirect("/GPubli-Project/home");
			
			}
	}
	}
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
