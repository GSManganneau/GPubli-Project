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
		
		if (field != "") {
		Hashtable<String, List<Hashtable<String, String>>> AllResults = new Hashtable<String, List<Hashtable<String, String>>>();
		List<Hashtable<String, String>> AllResultsAuthors = new ArrayList<Hashtable<String, String>>();
		List<Hashtable<String, String>> AllResultsTeams = new ArrayList<Hashtable<String, String>>();
		List<Hashtable<String, String>> AllResultsPublications = new ArrayList<Hashtable<String, String>>();

		try {
			DataSource ds = DataSource.getInstace();
			Connection conn = ds.getConnection();
			Statement stmtrsAuthors = conn.createStatement();
			Statement stmtrsTeams = conn.createStatement();
			Statement stmtrsPublications = conn.createStatement();

			// Requêtes
			String sqlAuthors = "SELECT ldapId,firstname,lastname FROM authors WHERE firstname like '%"+field+"%' or lastname like '%"+field+"%'  LIMIT 3";
			String sqlPublications = "SELECT title,publicationId FROM publications WHERE title like '%"+field+"%' LIMIT 3";
			String sqlTeams = "SELECT teamId,teamName FROM Teams WHERE teamName like '%"+field+"%' LIMIT 3";

			// Résultats des requêtes
			ResultSet rsAuthors = stmtrsAuthors.executeQuery(sqlAuthors);
			ResultSet rsTeams = stmtrsTeams.executeQuery(sqlTeams);
			ResultSet rsPublications = stmtrsPublications.executeQuery(sqlPublications);

			// Stocage des données dans la Hashmap Author
			while (rsAuthors.next()) {
				String ldapId = rsAuthors.getString("ldapId");
				String firstname = rsAuthors.getString("firstname");
				String lastname = rsAuthors.getString("lastname");
				
				Hashtable<String, String> AuthorsResults = new Hashtable<String, String>();
				AuthorsResults.put("value", firstname+" "+lastname);
				AuthorsResults.put("id", ldapId);
				
				
				AllResultsAuthors.add(AuthorsResults);
				
				AllResults.put("users", AllResultsAuthors);
			}

			// Stocage des données dans la Hashmap Team
			while (rsTeams.next()) {
				
				
				String teamId = rsTeams.getString("teamId");
				String teamName = rsTeams.getString("teamName");
				
				Hashtable<String, String> TeamsResults = new Hashtable<String, String>();
				TeamsResults.put("value", teamName);
				TeamsResults.put("id", teamId);
				
				AllResultsTeams.add(TeamsResults);
				
				AllResults.put("teams", AllResultsTeams);
			}

			// Stocage des données dans la Hashmap Pub
			while (rsPublications.next()) {
				
				String publicationId = rsPublications
						.getString("publicationId");
				String title = rsPublications.getString("title");
				
				Hashtable<String, String> PublicationsResults = new Hashtable<String, String>();			
				PublicationsResults.put("value", title);
				PublicationsResults.put("id", publicationId);
				
				AllResultsPublications.add(PublicationsResults);
				
				AllResults.put("publications", AllResultsPublications);
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
		
		}else {
			String res = "{}";
			response.setContentType("application/json");
			response.getWriter().print(res);
			
		}
	}
}
