package controllers_front;

import java.io.IOException;
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
import modelsDao.TeamsDao;
import modelsDao.TypeDao;

/**
 * Servlet implementation class UpdatePublication
 */
@WebServlet("/updatepublication")
public class UpdatePublication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public String content = "updatePublication.jsp";
	public String jsContent = "addPublicationForm.js";

	private PublicationsDao publicationDao;
	private AuthorsDao authorDao;
	private TeamsDao teamDao;
	private TypeDao typeDao;

	public void init() throws ServletException {
		DAOFactory factory = DAOFactory.getInstance();
		this.publicationDao = factory.getPublications();
		this.authorDao = factory.getAuthors();
		this.typeDao = factory.getType();
		this.teamDao = factory.getTeams();

	}

	public UpdatePublication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();

		// Si l'utilsateur n'est pas connecté il est redirigé vers la page
		// connexion

		String connected = (String) s.getAttribute("connected");
		if (connected == null) {
			response.sendRedirect("/GPubli-Project/connexion");
		} else {
			if (request.getParameter("publicationId") != null) {
				int publicationId = Integer.parseInt((String) request
						.getParameter("publicationId"));
				Publications publication = publicationDao.find(publicationId);
				boolean find = false;
				for (int i = 0; i < publication.getAuthors().size() && !find; i++) {
					if (publication.getAuthors().get(i).getAuthorId() == (int) s
							.getAttribute("authorId")) {
						find = true;
						request.setAttribute("publication", publication);
						request.setAttribute("types", typeDao.lister());
						request.setAttribute("session", s);
						request.setAttribute("content", content);
						request.setAttribute("jsContent", jsContent);
						this.getServletContext()
								.getRequestDispatcher(
										"/front-office/template.jsp")
								.forward(request, response);
					}
				}
			} else {
				response.sendRedirect("/GPubli-Project/home");

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("publicationId") != null) {
			int publicationId = Integer.parseInt((String) request
					.getParameter("publicationId"));
			Publications publication = publicationDao.find(publicationId);
			System.out.print(publication.toString());
			int typeId = Integer.parseInt(request.getParameter("type"));
			String date = request.getParameter("date");
			String resume = request.getParameter("resume");
			String title = request.getParameter("title");
			
			if (typeId != publication.getType().getTypeId()) {
				publication.setType(typeDao.find(typeId));
				for (int i = 0; i < publication.getType().getAttributes()
						.size(); i++) {
					int attributeId = publication.getType().getAttributes()
							.get(i).getAttributeId();
					String data = request.getParameter("attribute"
							+ attributeId);
					publication.getType().getAttributes().get(i).setDatas(data);
				}
			} else {
				for (int i = 0; i < publication.getType().getAttributes()
						.size(); i++) {
					int attributeId = publication.getType().getAttributes()
							.get(i).getAttributeId();
					String data = request.getParameter("attribute"
							+ attributeId);
					publication.getType().getAttributes().get(i).setDatas(data);
				}

			}
			if (!date.equals(publication.getDate())) {
				publication.setDate(date);
			}
			if (!resume.equals(publication.getResume())) {
				publication.setResume(resume);
			}
			if (!title.equals(publication.getTitle())) {
				publication.setTitle(title);
			}

			List<Authors> auteurs = new ArrayList<Authors>();
			if (request.getParameterValues("authors") != null) {
				String[] authors = request.getParameterValues("authors");
				for (int i = 0; i < authors.length; i++) {
					Authors author = new Authors();
					if (authors[i].startsWith("[")) {

						author.setLastname(authors[i].split("]")[1].split("/")[0]);
						author.setFirstname(authors[i].split("]")[1].split("/")[1]);
						author.setAuthorId(authorDao.create(author, false));
					} else {
						author = authorDao.findWithId(Integer
								.parseInt(authors[i]));

					}
					auteurs.add(author);
				}
				if (!auteurs.equals(publication.getAuthors())) {
					publication.setAuthors(auteurs);
				}
				HttpSession s = request.getSession();
				int authorId = (int)(s.getAttribute("authorId"));
				Authors author=authorDao.findWithId(authorId);
				auteurs.add(author);

			}
			publicationDao.update(publication);
			response.sendRedirect("/GPubli-Project/home");

		}
	}
}