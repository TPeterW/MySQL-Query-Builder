package com.tpwang.sql;

public class SQLQuery {
	
	StringBuilder builder;
	
	/***
	 * Constructor
	 */
	public SQLQuery() {
		builder = new StringBuilder().append(' ');
	}
	
	/***
	 * What to query
	 * @param target		Selection target from table
	 * @return				builder
	 */
	public SQLQuery select(String target) {
		builder.append("SELECT ").append(target).append(' ').toString();
		return this;
	}
	
	/***
	 * What to query
	 * @param target		Selection target from table
	 * @return				builder
	 */
	public SQLQuery select(char target) {
		return select(Character.toString(target));
	}
	
	/***
	 * Where to query
	 * @param tableName		Selection destination/subquery
	 * @return				builder
	 */
	public SQLQuery from(String tableName) {
		builder.append("FROM ").append(tableName).append(' ');
		return this;
	}
	
	/***
	 * How to query
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				builder
	 */
	public SQLQuery where(String condition) {
		builder.append("WHERE ").append(condition).append(' ');
		return this;
	}
	
	/***
	 * Return the final query
	 * @return query
	 */
	public String make() {
		return toString();
	}
	
	/***
	 * Return the final query
	 */
	public String toString() {
		return builder.toString();
	}
}

