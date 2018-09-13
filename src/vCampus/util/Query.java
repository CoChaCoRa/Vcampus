package vCampus.util;

import java.util.ArrayList;

public class Query {

	public static ArrayList<String> allQueries;
	
	
	public Query() {
		// TODO Auto-generated constructor stub
		allQueries = new ArrayList<String>();
	}
	public static void addQuery(String newQuery) {
		allQueries.add(newQuery);
	}
	
	public static ArrayList<String> getAllQueries() {
		return allQueries;
	}
}
