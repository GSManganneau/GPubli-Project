package controllers_back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Teams;
import modelsDao.TeamsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;

/**
 * Servlet implementation class Listing_author
 */
@WebServlet("/TeamPage")
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

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.teamDao = factory.getTeams();
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
			
			String teamName = request.getParameter("team");
			request.setAttribute("session", s);
			request.setAttribute("content", content);
			
			request.setAttribute("teams", teamDao.listContentTeam(teamName));
	        getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
