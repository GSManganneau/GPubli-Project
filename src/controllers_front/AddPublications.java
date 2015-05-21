package controllers_front;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Publications;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;

/**
 * Servlet implementation class AddPublications
 */
@WebServlet("/AddPublications")
public class AddPublications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 
		public String content="addPublicationForm.jsp";
		
		
     private PublicationsDao publicationDao;

     public void init() throws ServletException {
     	 DAOFactory factory = DAOFactory.getInstance();
          this.publicationDao = factory.getPublications();
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
		if(connected==null){
			response.sendRedirect("/GPubli-Project/connexion");
		}
		else{
		request.setAttribute("session", s);
        request.setAttribute("content",content);
        this.getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int type_id=1;
		String type_name =request.getParameter("type");
        String date = "";
        String resume =request.getParameter("resume");
        String journal = request.getParameter("journal");
        String book_title= request.getParameter("book_title");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (type_name.equals("article")){
        	type_id=1;
        }
        Publications publication = new Publications();
        publication.getType().setType_id(type_id);
        publication.setBook_title(book_title);
        publication.setDate(date);
        publication.setJournal(journal);
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
