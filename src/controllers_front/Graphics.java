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


/**
 * Servlet implementation class Search
 */
@WebServlet("/Graphics")
public class Graphics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String content = "graphics.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Graphics() {
		super();
		// TODO Auto-generated constructor stub
	}

	private AuthorsDao authorsDao;
	private PublicationsDao publicationsDao;
	private TeamsDao teamsDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.authorsDao = factory.getAuthors();
		this.publicationsDao = factory.getPublications();
		this.teamsDao = factory.getTeams();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");

		request.setAttribute("Authors", authorsDao.search(search));
		request.setAttribute("AuthorCount", authorsDao.count(search));
		
		request.setAttribute("Publications", publicationsDao.search(search));
		request.setAttribute("PublicationCount", publicationsDao.count(search));
		
		request.setAttribute("Teams", teamsDao.search(search));
		request.setAttribute("TeamCount", teamsDao.count(search));

		request.setAttribute("content", content);
		request.setAttribute("search", search);
		getServletContext().getRequestDispatcher("/front-office/template.jsp")
				.include(request, response);
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
