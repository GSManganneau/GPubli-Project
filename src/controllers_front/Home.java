package controllers_front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Publications;
//import models.Publications;
import modelsDao.*;

/**
 * Servlet implementation class Index
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Definition du content à inclure au template, du style et du script.

	public String cssContent = "publications.css";
	public String content = "home.jsp";
	public String jsContent = "publications.js";

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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();

		// Si l'utilsateur n'est pas connecté il est redirigé vers la page
		// connexion

		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else {
			// On instancie la classe Paginate
			Paginate paginate = new Paginate();

			// On définit le nombre d'éléments par page
			paginate.setElementsByPage(7);
			// on calcule le nombre de pages
			int numberOfPages = publicationDao.countNumberPage(paginate
					.getElementsByPage());
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
					paginate.setServlet("home");

					// On récupère les données
					int elementsByPage = paginate.getElementsByPage();
					request.setAttribute(
							"publications",
							publicationDao.lister(
									(paginate.getCurrentPageNumber() - 1)
											* elementsByPage,
									elementsByPage));
					
					// On envoi les données à la servlet
					request.setAttribute("session", s);
				
					request.setAttribute("paginate", paginate);
					request.setAttribute("content", content);
					request.setAttribute("jsContent", jsContent);
					
					//Chiffres-clés
					request.setAttribute("teamCount", teamDao.countAll());
					request.setAttribute("pubCount", publicationDao.countAll());
					request.setAttribute("authorCount", authorDao.countAll());
					request.setAttribute("typeCount", typeDao.countAll());
													
					request.setAttribute("cssContent", cssContent);
					this.getServletContext()
							.getRequestDispatcher("/front-office/template.jsp")
							.forward(request, response);
				} else {
					response.sendRedirect("/GPubli-Project/home?page=1");
				}
			} else {
				response.sendRedirect("/GPubli-Project/home?page=1");
			}

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
