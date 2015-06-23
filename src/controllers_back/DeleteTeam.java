package controllers_back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataSource.mysql.DataSource;

/**
 * Servlet implementation class DeleteTeam
 */
@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if ( request.getParameter("teamId") != null )  {
				
				try {
					DataSource ds = DataSource.getInstace();
					Connection conn = ds.getConnection();
					Statement stmtrsListTeam = conn.createStatement();
						
					// Résultats de la requête
					stmtrsListTeam.executeUpdate("DELETE FROM teams WHERE teamId="+Integer.parseInt(request.getParameter("teamId")));
					
					//close
					stmtrsListTeam.close();
					conn.close();		
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.sendRedirect("/GPubli-Project/Teams");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
