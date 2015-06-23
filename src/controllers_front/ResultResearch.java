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
import beans.Publications;
import beans.Types;
import beans.Teams;
import modelsDao.AuthorsDao;
import modelsDao.DAOFactory;
import modelsDao.PublicationsDao;
import modelsDao.TypeDao;
import modelsDao.TeamsDao;


import beans.Publications;

/**
 * Servlet implementation class ResultResearch
 */
@WebServlet("/ResultResearch")
public class ResultResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public String cssContent = "advanced-search.css";
	public String content= "advancedSearch.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultResearch() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String template= "publication.jsp";
    private PublicationsDao publicationsDao;   
    private AuthorsDao authorDao;
    private TypeDao typeDao;
    private TeamsDao teamsDao;  

    public void init() throws ServletException {
    	 DAOFactory factory = DAOFactory.getInstance();
         this.publicationsDao = factory.getPublications();
         this.authorDao = factory.getAuthors();
         this.typeDao = factory.getType();
         this.teamsDao = factory.getTeams();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		this.content = "advancedSearchResults.jsp";
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
        List<Integer> publicationsId = publicationsDao.research(publiName,dateFrom,dateTo,resume,authorsInt,typeInt,teamInt,keyWords);
        List <Publications> publications = new ArrayList<Publications>();
        for(int i =0; i < publicationsId.size(); i++){
        	Publications publication = publicationsDao.find(publicationsId.get(i));
        	publications.add(publication);
        }
        int countPubli = publications.size();
        request.setAttribute("publications", publications);
        request.setAttribute("content",content);
        request.setAttribute("countPubli",countPubli);
        getServletContext().getRequestDispatcher("/front-office/template.jsp").include(request, response);
		
	}

}
