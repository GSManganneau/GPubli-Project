package controllers_front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Teams;
import modelsDao.AuthorsDao;
import modelsDao.TeamsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class Listing_author
 */
@WebServlet("/teampage")
public class TeamPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String content = "team.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamPage() {
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

			int i = 0;
			if (request.getParameter("teamId") != null)
				i = Integer.parseInt(request.getParameter("teamId"));

			// On instancie la classe Paginate
			Paginate paginate = new Paginate();

			// On définit le nombre d'éléments par page
			paginate.setElementsByPage(7);
			// on calcule le nombre de pages
			int numberOfPages = publicationDao.countNumberPage(
					paginate.getElementsByPage(),"teamId", i);
			int pageId = 0;

			if (request.getParameter("page") != null) {
				pageId = Integer.parseInt(request.getParameter("page"));

				if (pageId > 0 && pageId <= numberOfPages) {

					// On récupère le numéro de la page actuelle
					int page = Integer.parseInt(request.getParameter("page"));
					paginate.setCurrentPageNumber(page);

					// On définit la page précédente
					if (paginate.getCurrentPageNumber() > 1)
						paginate.setPreviousPageNumber(paginate
								.getCurrentPageNumber() - 1);
					else
						paginate.setPreviousPageNumber(0);

					// On défint la page suivante
					if (publicationDao.checkNextPage(page,
							paginate.getElementsByPage(),"teamId", i))
						paginate.setNextPageNumber(page + 1);
					else
						paginate.setNextPageNumber(0);

					// On définit le nombre de Pages
					paginate.setNumberOfPages(numberOfPages);

					// On définit la servlet
					paginate.setServlet("teampage");
					paginate.setParameter("teamId");

					// On récupère les données
					int elementsByPage = paginate.getElementsByPage();
					request.setAttribute(
							"publications",
							publicationDao.listPublicationTeam(
									(paginate.getCurrentPageNumber() - 1)
											* elementsByPage, elementsByPage, i));
			
			Teams team = teamDao.find(i);
			request.setAttribute("teamName", team.getTeamName());
			request.setAttribute("teamId", team.getTeamId());
			request.setAttribute("session", s);
			request.setAttribute("paginate", paginate);
			request.setAttribute("parameterValue", i);
			request.setAttribute("content", content);
			
			//request.setAttribute("publications",publicationDao.listPublicationAuthor(3, 3, i));
			
			//Chiffres-clés
			request.setAttribute("teamCount", teamDao.countAll());
			request.setAttribute("pubCount", publicationDao.countAll());
			request.setAttribute("authorCount", authorDao.countAll());
			request.setAttribute("typeCount", typeDao.countAll());
			
			request.setAttribute("authors", teamDao.listContentTeam(team.getTeamName()));
			request.setAttribute("countAuthorTeam", teamDao.countAuthorTeam(team.getTeamName()));
	        getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
		
		}
			}else {
				response.sendRedirect("/GPubli-Project/teampage?page=1&teamId="
						+ i);
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
