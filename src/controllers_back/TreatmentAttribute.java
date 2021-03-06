package controllers_back;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataSource.mysql.DataSource;

/**
 * Servlet implementation class TreatmentAttribute
 */
@WebServlet("/TreatmentAttribute")
public class TreatmentAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreatmentAttribute() {
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
			
			int typeId = Integer.parseInt(request.getParameter("typeId"));
			String[] name = request.getParameterValues("name[]");
			
			for (int i=0, n = name.length ; i<n ; i++) {
				try {
					DataSource ds = DataSource.getInstace();
					Connection conn = ds.getConnection();
					Statement stmtrsListTeam = conn.createStatement();
			
					// Requête
					String sqlTeams = "UPDATE Attributes SET attributeId="+name[i];
					
			
					// Résultats de la requête
					stmtrsListTeam.executeUpdate(sqlTeams);
					
					//close
					stmtrsListTeam.close();
					conn.close();
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				//System.out.println(name[i]);
			}
			response.sendRedirect("/GPubli-Project/Attributes?typeId="+typeId);
		}

	}



