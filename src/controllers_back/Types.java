package controllers_back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelsDao.DAOFactory;
import modelsDao.TeamsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class Types
 */
@WebServlet("/Types")
public class Types extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String content = "types.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Types() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private TypeDao typeDao;
    
    public void init() throws ServletException {
      	 DAOFactory factory = DAOFactory.getInstance();
           this.typeDao = factory.getType();
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("types", typeDao.lister());
		request.setAttribute("content", content);
		
		getServletContext().getRequestDispatcher("/back-office/template.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
