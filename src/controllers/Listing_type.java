package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Types;
import modelsDao.DAOFactory;
import modelsDao.TypeDao;

/**
 * Servlet implementation class Listing_type
 */
@WebServlet("/Listing_type")
public class Listing_type extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listing_type() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private TypeDao TypeDao;

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.TypeDao = factory.getType();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("Types", TypeDao.lister());
        getServletContext().getRequestDispatcher("/List_type.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
