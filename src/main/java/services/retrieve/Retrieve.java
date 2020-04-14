package services.retrieve;

import java.sql.Connection;

import services.retrieve.retrieve_by_ci.CI_FIELDS;

public abstract class Retrieve {

	protected Connection con;
	
	public Retrieve(Connection con) {
		this.con=con;
	}
	
	protected static String get_conditions_as_sql_stmts(CI_FIELDS field, String value) {
	 	String sql_stmt= field.getVal() + "\'"+value+ "\'"; //these single quotes are important.
	return sql_stmt;
	}
}
