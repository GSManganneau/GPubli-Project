package controllers_back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataSource.mysql.DataSource;

/**
 * Servlet implementation class TreatmentTeam
 */
@WebServlet("/TreatmentTeam")
public class TreatmentTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreatmentTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int teamId = Integer.parseInt(request.getParameter("teamId"));
		
		if ( request.getParameterValues("name[]") != null && request.getParameterValues("id[]") != null ) {
		String[] name = request.getParameterValues("name[]");
		String[] id = request.getParameterValues("id[]");
		
		for (int i=0, n = name.length ; i<n ; i++) {
			try {
				DataSource ds = DataSource.getInstace();
				Connection conn = ds.getConnection();
				Statement stmtrsListTeam = conn.createStatement();
					
				// Résultats de la requête
				stmtrsListTeam.executeUpdate("UPDATE Teams SET teamName = '"+name[i]+"' WHERE teamId="+id[i]);
				
				//close
				stmtrsListTeam.close();
				conn.close();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("/GPubli-Project/Teams");
		} else if (request.getParameter("name") != null && request.getParameter("icon") != null) {
			DataSource ds = DataSource.getInstace();
			Connection conn = ds.getConnection();
			Statement stmtrsListTeam = null;
	
			try {
				stmtrsListTeam = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				stmtrsListTeam.executeUpdate("INSERT INTO Teams (teamName, thumbnail) VALUES ('"+request.getParameter("name")+"','"+request.getParameter("icon")+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/GPubli-Project/Teams");
		}
	}

}
