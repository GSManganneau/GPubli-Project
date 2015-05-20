package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import models.Publications;
import modelsDao.*;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
	    public String cssContent ="publications.css";
		public String content="publications.jsp";
		public String jsContent ="publications.js";
		
        private PublicationsDao publicationDao;

        public void init() throws ServletException {
        	 DAOFactory factory = DAOFactory.getInstance();
             this.publicationDao = factory.getPublications();
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
            request.setAttribute("publications", publicationDao.lister());
            request.setAttribute("content",content);
            request.setAttribute("jsContent",jsContent);
            request.setAttribute("cssContent",cssContent);
            this.getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
        }

        public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
          
            
            request.setAttribute("Publications", publicationDao.lister());
      
            request.setAttribute("content",content);
           
            
            
            this.getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
        }
        
}
