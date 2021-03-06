package controllers_front;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Authors;
import beans.Publications;
import beans.Types;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class AddPublications
 */
@WebServlet("/AddPublications")
public class AddPublications extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String content = "addPublicationForm.jsp";
	public String jsContent = "addPublicationForm.js";

	private PublicationsDao publicationDao;
	private TypeDao typeDao;
	private AuthorsDao authorDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.publicationDao = factory.getPublications();
		this.typeDao = factory.getType();
		this.authorDao = factory.getAuthors();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPublications() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		String connected=(String)s.getAttribute("connected");
		if(connected==null){
			response.sendRedirect("/GPubli-Project/connexion");
			}
		else{
		int id = (int)s.getAttribute("authorId");
		List<Types> types = typeDao.lister();
		List<Authors> authors = authorDao.lister(id);
		request.setAttribute("session", s);
        request.setAttribute("content",content);
        request.setAttribute("jsContent", jsContent);
        request.setAttribute("types", types);
        request.setAttribute("authors", authors);
        this.getServletContext().getRequestDispatcher("/front-office/template.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int typeId = Integer.parseInt(request.getParameter("type"));
		String date = request.getParameter("date");
		String resume = request.getParameter("resume");
		String title = request.getParameter("title");
		Types type = typeDao.find(typeId);
		for (int i = 0; i < type.getAttributes().size(); i++) {
			int attributeId=type.getAttributes().get(i).getAttributeId();
			String data = request.getParameter("attribute"+attributeId);
			type.getAttributes().get(i).setDatas(data);
		}
		Publications publication = new Publications();
		//récupère les coAuteurs
		List <Authors> auteurs = new ArrayList <Authors>();
		if(request.getParameterValues("authors")!=null){
			String[] authors = request.getParameterValues("authors");
			for(int i=0;i<authors.length;i++){
				Authors author = new Authors();
				if (authors[i].startsWith("[")){
					
					author.setLastname(authors[i].split("]")[1].split("/")[0]);
					author.setFirstname(authors[i].split("]")[1].split("/")[1]);
					author.setAuthorId(authorDao.create(author, false));
					}
				else{
					author=authorDao.findWithId(Integer.parseInt(authors[i]));
					
				}
				auteurs.add(author);
			}
			
		}
		HttpSession s = request.getSession();
		int authorId = (int)(s.getAttribute("authorId"));
		Authors author=authorDao.findWithId(authorId);
		auteurs.add(author);
		publication.setAuthors(auteurs);
		publication.setDate(date);
		publication.setResume(resume);
		publication.setTitle(title);
		publication.setType(type);
		publicationDao.create(publication);
		response.sendRedirect("/GPubli-Project/home");

	}

}
