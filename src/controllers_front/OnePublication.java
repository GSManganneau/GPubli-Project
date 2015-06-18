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
@WebServlet("/OnePublication")
public class OnePublication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Definition du content à inclure au template, du style et du script.

	public String cssContent = "publications.css";
	public String content = "home.jsp";
	public String jsContent = "publications.js";

	private PublicationsDao publicationDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.publicationDao = factory.getPublications();

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

			// On envoi les données à la servlet
			request.setAttribute("session", s);
			
			String pId = request.getParameter("p");
			int p = Integer.parseInt(pId);
			
			request.setAttribute("publications", publicationDao.listeLoneLy(p));
			request.setAttribute("content", content);
			request.setAttribute("jsContent", jsContent);

			request.setAttribute("cssContent", cssContent);
			this.getServletContext()
					.getRequestDispatcher("/front-office/template.jsp")
					.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
