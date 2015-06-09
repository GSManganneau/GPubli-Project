package controllers_front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;

/**
 * Servlet implementation class Advanced_research
 */
@WebServlet("/Advanced_research")
public class Advanced_research extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Advanced_research() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String template= "publication.jsp";
    private PublicationsDao PublicationsDao;

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.PublicationsDao = factory.getPublications();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       // request.setAttribute("Publications", PublicationsDao.research("roland"));
       // getServletContext().getRequestDispatcher("/result_research.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		
		String publiName = request.getParameter("publiName");
		String date = request.getParameter("date");
		String resume = request.getParameter("resume");
		//String type = request.getParameter("type");
        request.setAttribute("Publications", PublicationsDao.research(publiName,date,resume));
        getServletContext().getRequestDispatcher("/result_research.jsp").include(request, response);
		
	}

}
