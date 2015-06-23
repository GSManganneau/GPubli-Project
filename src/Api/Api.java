package Api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import beans.Publications;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class Api
 */
@WebServlet("/Api")
public class Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Api() {
        super();
        // TODO Auto-generated constructor stub
    }
    private PublicationsDao publicationDao;
	private TypeDao typeDao;
	private AuthorsDao authorDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.publicationDao = factory.getPublications();
		this.typeDao = factory.getType();
		this.authorDao = factory.getAuthors();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		List <Publications> publications = publicationDao.lister("login");
		request.setAttribute("publications",publications);
		String clientOrigin = request.getHeader("origin");
		System.out.print(clientOrigin);
		this.getServletContext().getRequestDispatcher("/api.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		List <Publications> publications = publicationDao.lister("login");
		String clientOrigin = request.getHeader("origin");
		System.out.print(clientOrigin);
		JSONObject json= new JSONObject();
		try {
			json.put("authorization", true);
			json.put("publications", publications);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", " true");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST");
	}

}
