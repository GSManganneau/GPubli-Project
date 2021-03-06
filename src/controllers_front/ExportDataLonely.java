package controllers_front;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;













import beans.Publications;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TeamsDao;


/**
 * Servlet implementation class Search
 */
@WebServlet("/ExportDataLonely")
public class ExportDataLonely extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String content = "exportLonely.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExportDataLonely() {
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
		String field = request.getParameter("p");
		int p = Integer.parseInt(field);
		List<Publications> publications = publicationsDao.listeLoneLy(p);
		request.setAttribute("Publications", publications);
		

		
		//response.setContentType("application/octet-stream");
		response.setHeader("Content-Description", "File Transfer");
		response.setHeader("Content-type", "application/octet-stream");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		String typeExport = request.getParameter("export");
		if (typeExport.equals("text")) {
		response.setHeader("Content-Disposition","attachment; filename="+ publications.get(0).getTitle() +p+".txt");	
		getServletContext().getRequestDispatcher("/front-office/export.jsp")
				.include(request, response);
		} else if (typeExport.equals("bibTeX")){
		response.setHeader("Content-Disposition","attachment; filename="+ publications.get(0).getTitle() +p+".bib");	
		getServletContext().getRequestDispatcher("/front-office/exportBibTeX.jsp")
				.include(request, response);	
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
