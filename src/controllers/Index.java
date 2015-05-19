package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.Publications;
//import models.Publications;
import modelsDao.*;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

		public String template= "publication.jsp";
        private PublicationsDao PublicationsDao;

        public void init() throws ServletException {
        	 DAOFactory factory = DAOFactory.getInstance();
             this.PublicationsDao = factory.getPublications();
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
            request.setAttribute("Publications", PublicationsDao.lister());
            request.setAttribute("template",template);
            this.getServletContext().getRequestDispatcher("/WebContent/Front-Office/template.jsp").forward(request, response);
        }

        public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
          // Publications Publications = new Publications();
          //Publications.setN(request.getParameter("nom"));
            //Publications.setPrenom(request.getParameter("prenom"));
            
           // PublicationsDao.ajouter(Publications);
            
            request.setAttribute("Publications", PublicationsDao.lister());
            request.setAttribute("template",template);
            
            
            this.getServletContext().getRequestDispatcher("/WebContent/Front-Office/template.jsp").forward(request, response);
        }
        
}
