package com.tpwang.sql;

import com.tpwang.sql.SQLQuery;

public class SQLSubQuery {
	
	private SQLQuery query;
	
	public SQLSubQuery() {
		this.query = new SQLQuery();
	}
	
	// TODO: add other commands
	
	/***
	 * Return the final query
	 * @return query
	 */
	public String make() {
		return toString();
	}
	
	/***
	 * Return the final subquery
	 */
	public String toString() {
		return (new StringBuilder()).append('(').append(query.make()).append(')').toString();
	}
	
}
