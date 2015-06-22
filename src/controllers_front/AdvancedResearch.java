package controllers_front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Authors;
import beans.Types;
import beans.Teams;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;
import modelsDao.TeamsDao;

/**
 * Servlet implementation class AdvancedResearch
 */
@WebServlet("/AdvancedResearch")
public class AdvancedResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public String cssContent = "advanced-search.css";
	public String content= "advancedSearch.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedResearch() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String template= "publication.jsp";
    private PublicationsDao PublicationsDao;
    private AuthorsDao authorDao;
    private TypeDao typeDao;
    private TeamsDao teamsDao;
    

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.PublicationsDao = factory.getPublications();
         this.authorDao = factory.getAuthors();
         this.typeDao = factory.getType();
         this.teamsDao = factory.getTeams();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       // request.setAttribute("Publications", PublicationsDao.research("roland"));
		List<Authors> authors = authorDao.lister();
		List<Types> types = typeDao.lister();
		List<Teams> teams = teamsDao.lister();
		request.setAttribute("authors", authors);
		request.setAttribute("types", types);
		request.setAttribute("teams", teams);
		request.setAttribute("cssContent",cssContent);
		request.setAttribute("content",content);
		getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		System.out.println("roland");
		//request.setAttribute("Publications", PublicationsDao.research("rola",null,null,2));
		String publiName = null;
		String keyWords[];
		String date[] = null;
		String resume=null;
		String dateFrom=null;
		String dateTo=null;
		String type=null;
		int typeInt=0;
		String team=null;
		int teamInt=0;
		String[] authors=null;
		int[] authorsInt;
		
		if(request.getParameter("publiName")!=null){
			publiName = request.getParameter("publiName");
		}
		if(request.getParameter("resume")!=null){
			resume = request.getParameter("resume");
		}
		if(request.getParameter("dateFrom")!=null){
			dateFrom= request.getParameter("dateFrom");
		}
		if(request.getParameter("dateTo")!=null){
			dateTo = request.getParameter("dateTo");
		}
		if(request.getParameter("type")!=null && !request.getParameter("type").isEmpty()){
			type = request.getParameter("type");
			typeInt = Integer.parseInt(type);
		}
		if(request.getParameter("authors")!=null && !request.getParameter("authors").isEmpty()){
			authors = request.getParameterValues("authors");
			authorsInt= new int[authors.length];
			

			for(int i=0;i<authors.length;i++){
				authorsInt[i] = Integer.parseInt(authors[i]);
			}
			System.out.println(authorsInt);
		} else {
			authorsInt= null;
		}
		
		if(request.getParameter("team")!=null && !request.getParameter("team").isEmpty()){
			team = request.getParameter("team");
			teamInt = Integer.parseInt(team);
		}
		
		if(request.getParameter("keyWords")!=null && !request.getParameter("keyWords").isEmpty()){
			keyWords = request.getParameterValues("keyWords");
			
			System.out.println(keyWords);
		} else {
			keyWords= null;
		}
		
		//System.out.println(date.length);
		//String type = request.getParameter("type");
        request.setAttribute("publicationsId", PublicationsDao.research(publiName,dateFrom,dateTo,resume,authorsInt,typeInt,teamInt,keyWords));
        
        getServletContext().getRequestDispatcher("/resultResearch.jsp").include(request, response);
		
	}

}

