package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Authors;
import modelsDao.AuthorsDao;
import modelsDao.EntityFactory;
import modelsDao.PublicationsDao;

/**
 * Servlet implementation class Listing_author
 */
@WebServlet("/Listing_author")
public class Listing_author extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listing_author() {
        super();
        // TODO Auto-generated constructor stub
    }

    private AuthorsDao AuthorsDao;

    public void init() throws ServletException {
    	 EntityFactory factory = EntityFactory.getInstance();
         this.AuthorsDao = factory.getAuthors();
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("Authors", AuthorsDao.lister());
        getServletContext().getRequestDispatcher("/Liste_auteurs.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
