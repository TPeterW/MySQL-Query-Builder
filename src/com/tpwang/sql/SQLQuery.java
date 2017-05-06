package com.tpwang.sql;

import java.util.StringJoiner;

public class SQLQuery {
	
	protected StringBuilder builder;
	
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
		StringJoiner joiner = new StringJoiner(", ");
		for (String str : targets)
			joiner.add(str);
		builder.append(joiner.toString()).append(' ');
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
	 * How to order
	 * @param attributeName	Selection ordering
	 * @param ascending		order direction
	 * @return				query
	 */
	public SQLQuery orderBy(String attributeName, boolean ascending) {
		builder.append("ORDER BY ").append(attributeName).append(ascending ? " " : " DESC ");
		return this;
	}
	
	/***
	 * How to order
	 * @param attributeName	Selection ordering
	 * @param ascending		order direction
	 * @return				query
	 */
	public SQLQuery orderBy(char attributeName, boolean ascending) {
		builder.append("ORDER BY ").append(attributeName).append(ascending ? " " : " DESC ");
		return this;
	}
	
	/***
	 * How to group
	 * @param attributeName	Selection grouping
	 * @return				query
	 */
	public SQLQuery groupBy(char attributeName) {
		builder.append("GROUP BY ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * How to group
	 * @param attributeName	Selection grouping
	 * @return				query
	 */
	public SQLQuery groupBy(String attributeName) {
		builder.append("GROUP BY ").append(attributeName).append(' ');
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
		return builder.toString().trim();
	}
}

