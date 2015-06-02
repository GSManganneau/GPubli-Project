package controllers_front;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Publications;
import beans.Types;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class AddPublications
 */
@WebServlet("/AddPublications")
public class AddPublications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
		public String content="addPublicationForm.jsp";
		
		
     private PublicationsDao publicationDao;
     private TypeDao typeDao;

     public void init() throws ServletException {
     	 DAOFactory factory = DAOFactory.getInstance();
          this.publicationDao = factory.getPublications();
          this.typeDao = factory.getType();
     }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPublications() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		String connected=(String)s.getAttribute("connected");
//		if(connected==null){
//			response.sendRedirect("/GPubli-Project/connexion");
//		}
//		else{
		List<Types> types = typeDao.lister();
		request.setAttribute("session", s);
        request.setAttribute("content",content);
        request.setAttribute("types", types);
        this.getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int typeId=1;
		String type_name =request.getParameter("type");
        String date = "";
        String resume =request.getParameter("resume");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (type_name.equals("article")){
        	typeId=1;
        }
        Publications publication = new Publications();
        publication.getType().setTypeId(typeId);
        publication.setDate(date);
        publication.setResume(resume);
        publication.setTitle(title);
        publication.setUrl(url);
        
        publicationDao.create(publication);
        
        this.content="publications.jsp";
        String cssContent ="publications.css";
        String jsContent ="publications.js";
        request.setAttribute("publications", publicationDao.lister());
        request.setAttribute("content",content);
        request.setAttribute("jsContent",jsContent);
        request.setAttribute("cssContent",cssContent);
        getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
        
        
	}

}
