package controllers_back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.DataSource.mysql.DataSource;

import modelsDao.AttributesDao;
import modelsDao.DAOFactory;
import modelsDao.TypeDao;

/**
 * Servlet implementation class Attributes
 */
@WebServlet("/Attributes")
public class Attributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String content = "attributes.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attributes() {
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
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		String typeName = request.getParameter("typeName");
		String iconName = request.getParameter("iconName");
		
		List<Hashtable<String, String>> listAttributes = new ArrayList<Hashtable<String, String>>();
		
		try {
			DataSource ds = DataSource.getInstace();
			Connection conn = ds.getConnection();
			Statement stmtrsListAttributes = conn.createStatement();
	
			// Requête
			String sqlTeams = "SELECT attributeName, attributeId FROM attributes";
			
	
			// Résultats de la requête
			ResultSet rslAttributes = stmtrsListAttributes.executeQuery(sqlTeams);
	
			// Stocage des données
			while (rslAttributes.next()) {
				String attributeName = rslAttributes.getString("attributeName");
				String attributeId = rslAttributes.getString("attributeId");
				
				Hashtable<String, String> listAttribute = new Hashtable<String, String>();				
				listAttribute.put("name", attributeName);
				listAttribute.put("value", attributeId);
				
				listAttributes.add(listAttribute);
			}

			// Close
			rslAttributes.close();		
			stmtrsListAttributes.close();
			conn.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		JSONArray json = new JSONArray(listAttributes);
		
		
		request.setAttribute("json", json);
		
		request.setAttribute("attributes", attributeDao.lister(typeId));
		request.setAttribute("type", typeDao.lister(typeId));
		request.setAttribute("content", content);
		request.setAttribute("typeName", typeName);
		request.setAttribute("iconName", iconName);
		request.setAttribute("typeId", typeId);
		
		
		getServletContext().getRequestDispatcher("/back-office/template.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
