package controllers_front;

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
@WebServlet("/userpage")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();

		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else {
			int i = 0;
			if (request.getParameter("ldapId") != null)
				i = Integer.parseInt(request.getParameter("ldapId"));

			else {
				i = (int) s.getAttribute("ldapId");
			}

			// On instancie la classe Paginate
			Paginate paginate = new Paginate();

			// On définit le nombre d'éléments par page
			paginate.setElementsByPage(7);
			// on calcule le nombre de pages
			int numberOfPages = publicationDao.countNumberPage(
					paginate.getElementsByPage(),"ldapId", i);
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
							paginate.getElementsByPage(),"ldapId", i))
						paginate.setNextPageNumber(page + 1);
					else
						paginate.setNextPageNumber(0);

					// On définit le nombre de Pages
					paginate.setNumberOfPages(numberOfPages);

					// On définit la servlet
					paginate.setServlet("userpage");
					paginate.setParameter("ldapId");

					// On récupère les données
					int elementsByPage = paginate.getElementsByPage();
					request.setAttribute(
							"publications",
							publicationDao.listPublicationAuthor(
									(paginate.getCurrentPageNumber() - 1)
											* elementsByPage, elementsByPage, i));

					request.setAttribute("session", s);
					request.setAttribute("content", content);
					request.setAttribute("parameterValue", i);
					request.setAttribute("paginate", paginate);
					request.setAttribute("author", authorDao.find(i));

					// Chiffres-clés
					request.setAttribute("team", teamDao.teamOfAuthor(i));
					request.setAttribute("teamCount", teamDao.countAll());
					request.setAttribute("pubCount", publicationDao.countAll());
					request.setAttribute("authorCount", authorDao.countAll());
					request.setAttribute("typeCount", typeDao.countAll());

					getServletContext().getRequestDispatcher(
							"/front-office/template.jsp").include(request,
							response);

				}

			} else {
				response.sendRedirect("/GPubli-Project/userpage?page=1&ldapId="
						+ i);
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
