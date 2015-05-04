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


        private PublicationsDao PublicationsDao;

        public void init() throws ServletException {
        	 EntityFactory factory = EntityFactory.getInstance();
             this.PublicationsDao = factory.getPublications();
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("Publications", PublicationsDao.lister());
            this.getServletContext().getRequestDispatcher("/WebContent/index.jsp").forward(request, response);
        }

        public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
           /* Publications Publications = new Publications();
            Publications.setNom(request.getParameter("nom"));
            Publications.setPrenom(request.getParameter("prenom"));
            
            PublicationsDao.ajouter(Publications);
            
            request.setAttribute("Publicationss", PublicationsDao.lister());
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);*/
        }
        
}
