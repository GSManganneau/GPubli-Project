package controllers_back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Attributes;
import modelsDao.AttributesDao;
import modelsDao.DAOFactory;
import modelsDao.TypeDao;

/**
 * Servlet implementation class AddAttribute
 */
@WebServlet("/AddAttribute")
public class AddAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttribute() {
        super();
        // TODO Auto-generated constructor stub
    }
    private AttributesDao attributeDao;
    private TypeDao typeDao;
    
    public void init() throws ServletException {
     	 DAOFactory factory = DAOFactory.getInstance();
          this.attributeDao = factory.getAttributes();
          this.typeDao = factory.getType();
     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String attributeName =request.getParameter("attributeName").split("]")[1];
		Attributes attribute = new Attributes();
		attribute.setAttributeName(attributeName);
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		attributeDao.update(attribute, typeId);
		response.sendRedirect("/GPubli-Project/Attributes?typeId="+typeId);
	}

}
