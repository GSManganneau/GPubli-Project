package com.autocomplete.sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable; 
import java.util.Iterator; 
import java.util.List;
import java.util.Set; 

import beans.Authors;

import com.DataSource.mysql.DataSource;

/**
 * Servlet implementation class AutoComplete
 */

public class AutoComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutoComplete() {
		super();

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("field");

		Hashtable<String, List<Hashtable>> AllResults = new Hashtable<String, List<Hashtable>>();
		List<Hashtable> AllResultsAuthors = new ArrayList<Hashtable>();
		List<Hashtable> AllResultsTeams = new ArrayList<Hashtable>();
		List<Hashtable> AllResultsPublications = new ArrayList<Hashtable>();

		try {
			DataSource ds = DataSource.getInstace();
			Connection conn = ds.getConnection();
			Statement stmtrsAuthors = conn.createStatement();
			Statement stmtrsTeams = conn.createStatement();
			Statement stmtrsPublications = conn.createStatement();

			// Requêtes
			String sqlAuthors = "SELECT firstname,lastname FROM authors LIMIT 3";
			String sqlPublications = "SELECT title,publicationId FROM publications LIMIT 3";
			String sqlTeams = "SELECT teamId,teamName FROM Teams LIMIT 3";

			// Résultats des requêtes
			ResultSet rsAuthors = stmtrsAuthors.executeQuery(sqlAuthors);
			ResultSet rsTeams = stmtrsTeams.executeQuery(sqlTeams);
			ResultSet rsPublications = stmtrsPublications.executeQuery(sqlPublications);

			// Stocage des données dans la Hashmap Author
			int i=0;
			while (rsAuthors.next()) {
				
				
				String firstname = rsAuthors.getString("firstname");
				String lastname = rsAuthors.getString("lastname");
				
				Hashtable<String, String> AuthorsResults = new Hashtable<String, String>();
				AuthorsResults.put("Firstname", firstname);
				AuthorsResults.put("Lastname", lastname);
				
				AllResultsAuthors.add(AuthorsResults);
				
				AllResults.put("Utilisateurs", AllResultsAuthors);
				i++;
			}

			// Stocage des données dans la Hashmap Team
			int j=0;
			while (rsTeams.next()) {
				
				
				String teamId = rsTeams.getString("teamId");
				String teamName = rsTeams.getString("teamName");
				
				Hashtable<String, String> TeamsResults = new Hashtable<String, String>();
				TeamsResults.put("TeamName", teamName);
				TeamsResults.put("TeamId", teamId);
				
				AllResultsTeams.add(TeamsResults);
				
				AllResults.put("Teams", AllResultsTeams);
				j++;
			}

			// Stocage des données dans la Hashmap Pub
			int k=0;
			while (rsPublications.next()) {
				
				String publicationId = rsPublications
						.getString("publicationId");
				String title = rsPublications.getString("title");
				
				Hashtable<String, String> PublicationsResults = new Hashtable<String, String>();			
				PublicationsResults.put("Title", title);
				PublicationsResults.put("PublicationId", publicationId);
				
				AllResultsPublications.add(PublicationsResults);
				
				AllResults.put("Publications", AllResultsPublications);
				k++;
			}


			// Close
			rsAuthors.close();
			rsTeams.close();
			rsPublications.close();

			stmtrsAuthors.close();
			stmtrsTeams.close();
			stmtrsPublications.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


		JSONObject json = new JSONObject(AllResults);

		response.setContentType("application/json");
		response.getWriter().print(json);
		System.out.println("json :"+ json);
	}
}
