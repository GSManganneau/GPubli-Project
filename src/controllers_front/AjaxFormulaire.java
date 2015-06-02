package controllers_front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Attributes;
import beans.Types;
import modelsDao.DAOFactory;
import modelsDao.TypeDao;

/**
 * Servlet implementation class AjaxFormulaire
 */
@WebServlet("/AjaxFormulaire")
public class AjaxFormulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TypeDao typeDao;
	public void init() throws ServletException {
     	 DAOFactory factory = DAOFactory.getInstance();
          this.typeDao= factory.getType();
     } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxFormulaire() {
        super();
        // TODO Auto-generated constructor stub
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
		int typeId =Integer.parseInt(request.getParameter("typeId"));
		System.out.println("typeId:"+ typeId);
		Types type = typeDao.find(typeId);
		List <Attributes> attributes = type.getAttributes();
		JSONObject json= new JSONObject();
		
		try {
			
				json.put("attributes",attributes);
				
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().print(json);
		System.out.println(json);
		System.out.print(json.length());
		
		
		
	}

}
