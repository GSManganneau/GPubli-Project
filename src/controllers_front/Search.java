package controllers_front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TeamsDao;
import controllers_front.Paginate;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String content = "search.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	private AuthorsDao authorsDao;
	private PublicationsDao publicationDao;
	private TeamsDao teamsDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.authorsDao = factory.getAuthors();
		this.publicationDao = factory.getPublications();
		this.teamsDao = factory.getTeams();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-gen
		HttpSession s = request.getSession();

		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else { 
			Paginate paginate = new Paginate();
			String search = request.getParameter("search");

			// On définit le nombre d'éléments par page
			paginate.setElementsByPage(7);
			// on calcule le nombre de pages
			int numberOfPages = publicationDao.countNumberPage(paginate
					.getElementsByPage(),search);
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
							paginate.getElementsByPage()))
						paginate.setNextPageNumber(page + 1);
					else
						paginate.setNextPageNumber(0);

					// On définit le nombre de Pages
					paginate.setNumberOfPages(numberOfPages);

					// On définit la servlet
					paginate.setServlet("search");

					// On récupère les données
					int elementsByPage = paginate.getElementsByPage();

				request.setAttribute("Authors", authorsDao.search(search));
				request.setAttribute("AuthorCount", authorsDao.count(search));

				request.setAttribute("Publications",
						publicationDao.search(search));
				request.setAttribute("PublicationCount",
						publicationDao.count(search));

				request.setAttribute("Teams", teamsDao.search(search));
				request.setAttribute("TeamCount", teamsDao.count(search));

				request.setAttribute("content", content);
				request.setAttribute("search", search);
				getServletContext().getRequestDispatcher(
						"/front-office/template.jsp")
						.include(request, response);
			} else {
				response.sendRedirect("/GPubli-Project/searchpublication?page=1");
			}
		}
	}
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
