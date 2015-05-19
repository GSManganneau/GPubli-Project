package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Teams;
import modelsDao.TeamsDao;
import modelsDao.EntityFactory;
import modelsDao.PublicationsDao;

/**
 * Servlet implementation class Listing_author
 */
@WebServlet("/Listing_team")
public class Listing_team extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listing_team() {
        super();
        // TODO Auto-generated constructor stub
    }

    private TeamsDao TeamsDao;

    public void init() throws ServletException {
    	 EntityFactory factory = EntityFactory.getInstance();
         this.TeamsDao = factory.getTeams();
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("Authors", TeamsDao.lister());
        getServletContext().getRequestDispatcher("/List_team.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
