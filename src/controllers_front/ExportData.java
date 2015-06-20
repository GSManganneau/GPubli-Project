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

import org.apache.tomcat.jni.File;
import org.omg.CORBA.DataInputStream;










import beans.Publications;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TeamsDao;


/**
 * Servlet implementation class Search
 */
@WebServlet("/ExportData")
public class ExportData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String content = "export.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExportData() {
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
		request.setAttribute("Publications", publicationsDao.lister());
		List<Publications> publications = publicationsDao.lister();
		request.setAttribute("Publications", publications);
		
		response.setHeader("Content-Description", "File Transfer");
		response.setHeader("Content-type", "application/octet-stream");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		String typeExport = request.getParameter("export");
		if (typeExport.equals("text")) {
		response.setHeader("Content-Disposition","attachment; filename=allPubications.txt");	
		getServletContext().getRequestDispatcher("/front-office/export.jsp")
				.include(request, response);
		} else if (typeExport.equals("bibTeX")){
		response.setHeader("Content-Disposition","attachment; filename=allPubications.bib");	
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
