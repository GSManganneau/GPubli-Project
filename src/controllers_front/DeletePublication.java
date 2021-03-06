package controllers_front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Authors;
import beans.Publications;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;

/**
 * Servlet implementation class DeletePublication
 */
@WebServlet("/deletepublication")
public class DeletePublication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String cssContent = "";
	public String content = "";
	public String jsContent = "";

	private PublicationsDao publicationDao;
	private AuthorsDao authorsDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.publicationDao = factory.getPublications();
		this.authorsDao = factory.getAuthors();

	}
    public DeletePublication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();

		// Si l'utilsateur n'est pas connecté il est redirigé vers la page
		// connexion

		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else {
			int id = Integer.parseInt(request.getParameter("publicationId"));
			Publications publication = publicationDao.find(id);
			int userId = (int)s.getAttribute("authorId");
			boolean find =false;
			for(int i=0;i<publication.getAuthors().size() && !find ;i++){
				
			if(publication.getAuthors().get(i).getAuthorId() == userId){
				publicationDao.delete(publication);
				response.sendRedirect("/GPubli-Project/home");
				find = true;
			}
			
			}
		/*	else{
				String messageError = "You can't delete this publication!!!";
				PrintWriter out =response.getWriter();
				out.write(messageError);
			}*/
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
