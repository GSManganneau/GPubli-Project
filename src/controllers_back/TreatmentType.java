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
@WebServlet("/TreatmentType")
public class TreatmentType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreatmentType() {
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
				stmtrsListTeam.executeUpdate("UPDATE Types SET typeName = '"+name[i]+"' WHERE typeId="+id[i]);
				
				//close
				stmtrsListTeam.close();
				conn.close();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("/GPubli-Project/Types");
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
				stmtrsListTeam.executeUpdate("INSERT INTO Types (typeName, numberField, iconName) VALUES ('"+request.getParameter("name")+"',4,'"+request.getParameter("icon")+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("/GPubli-Project/Types");
		}
	}

}
