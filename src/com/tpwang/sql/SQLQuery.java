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
	 * @return				query
	 */
	public SQLQuery select(String target) {
		builder.append("SELECT ").append(target).append(' ').toString();
		return this;
	}
	
	/***
	 * What to query
	 * @param target		Selection targets from table
	 * @return				query
	 */
	public SQLQuery select(String... targets) {
		builder.append("SELECT ");
		for (String str : targets) {
			builder.append(str);
		}
		builder.append(' ');
		return this;
	}
	
	/***
	 * What to query
	 * @param target		Selection target from table
	 * @return				query
	 */
	public SQLQuery select(char target) {
		return select(Character.toString(target));
	}
	
	/***
	 * Where to query
	 * @param tableName		Selection destination
	 * @return				query
	 */
	public SQLQuery from(String tableName) {
		builder.append("FROM ").append(tableName).append(' ');
		return this;
	}
	
	/***
	 * Where to query
	 * @param subquery		Selection destination (subquery)
	 * @return				query
	 */
	public SQLQuery fromSubquery(String subquery) {
		builder.append("FROM (").append(subquery).append(") ");
		return this;
	}
	
	/***
	 * Where to query
	 * @param subquery		Selection destination (subquery)
	 * @return				query
	 */
	public SQLQuery fromSubquery(SQLSubquery subquery) {
		builder.append("FROM (").append(subquery.create()).append(") ");
		return this;
	}
	
	/***
	 * How to query
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				query
	 */
	public SQLQuery where(String condition) {
		builder.append("WHERE ").append(condition).append(' ');
		return this;
	}
	
	/***
	 * How to query
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				query
	 */
	public SQLQuery where(SQLCondition condition) {
		builder.append("WHERE ").append(condition.create()).append(' ');
		return this;
	}
	
	/***
	 * Return the final query
	 * @return query
	 */
	public String create() {
		return toString();
	}
	
	/***
	 * Return the final query
	 */
	public String toString() {
		return builder.toString();
	}
}

