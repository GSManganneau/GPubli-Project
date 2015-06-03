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

		Hashtable<String, Object> AllResults = new Hashtable<String, Object>();
		Hashtable<String, String> AuthorsResults = new Hashtable<String, String>();
		Hashtable<String, String> TeamsResults = new Hashtable<String, String>();
		Hashtable<String, String> PublicationsResults = new Hashtable<String, String>();

		try {
			DataSource ds = DataSource.getInstace();
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();

			// Requêtes
			String sqlAuthors = "SELECT firstname,lastname FROM authors ";
			String sqlPublications = "SELECT title,publicationId FROM publications ";
			String sqlTeams = "SELECT title,publicationId FROM publications ";

			// Résultats des requêtes
			ResultSet rsAuthors = stmt.executeQuery(sqlAuthors);
			ResultSet rsTeams = stmt.executeQuery(sqlTeams);
			ResultSet rsPublications = stmt.executeQuery(sqlPublications);

			// Stocage des données dans la Hashmap Author
			while (rsAuthors.next()) {
				String firstname = rsAuthors.getString("firstname");
				String lastname = rsAuthors.getString("lastname");

				AuthorsResults.put("Firstname", firstname);
				AuthorsResults.put("Lastname", lastname);
			}

			// Stocage des données dans la Hashmap Team
			while (rsTeams.next()) {
				String teamId = rsTeams.getString("teamId");
				String teamName = rsTeams.getString("teamName");

				TeamsResults.put("TeamId", teamId);
				TeamsResults.put("TeamName", teamName);
			}

			// Stocage des données dans la Hashmap Pub
			while (rsPublications.next()) {
				String publicationId = rsPublications
						.getString("publicationId");
				String title = rsPublications.getString("title");

				PublicationsResults.put("PublicationId", publicationId);
				PublicationsResults.put("Title", title);
			}

			// HashMap contenant toutes les données
			AllResults.put("Publications", PublicationsResults);
			AllResults.put("Teams", TeamsResults);
			AllResults.put("Utilisateurs", AuthorsResults);

			// Close
			rsAuthors.close();
			rsTeams.close();
			rsPublications.close();

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray json = null;
		try {
			json = new JSONArray(AllResults);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().print(json);
	}
}
