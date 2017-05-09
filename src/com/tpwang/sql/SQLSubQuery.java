package com.tpwang.sql;

import java.util.StringJoiner;

public class SQLSubquery extends SQLQuery {
	
	// whether a join statement
	private boolean isJoinStmt = false;
	private StringBuilder joinBuilder = null;
	
	public SQLSubquery() {
		super();
		joinBuilder = new StringBuilder().append(' ');
	}
	
	/***
	 * What to subquery
	 * @param target		Selection target from table
	 * @return				subquery
	 */
	@Override
	public SQLSubquery select(String target) {
		super.select(target);
		joinBuilder.append("SELECT ").append(target).append(' ');
		
		return this;
	}
	
	/***
	 * What to query
	 * @param target		Selection targets from table
	 * @return				query
	 */
	@Override
	public SQLSubquery select(String... targets) {
		super.select(targets);
		joinBuilder.append("SELECT ");
		StringJoiner joiner = new StringJoiner(", ");
		for (String str : targets)
			joiner.add(str);
		joinBuilder.append(joiner.toString()).append(' ');
		return this;
	}
	
	/***
	 * What to subquery
	 * @param target		Selection target from table
	 * @return				subquery
	 */
	@Override
	public SQLSubquery select(char target) {
		super.select(target);
		joinBuilder.append("SELECT ").append(target).append(' ');
		return this;
	}
	
	/***
	 * Where to subquery
	 * @param tableName		Selection destination/subquery
	 * @return				subquery
	 */
	@Override
	public SQLSubquery from(String tableName) {
		super.from(tableName);
		joinBuilder.append("FROM ").append(tableName).append(' ');
		return this;
	}
	
	/***
	 * Where to query
	 * @param subquery		Selection destination (subquery)
	 * @return				query
	 */
	@Override
	public SQLSubquery fromSubquery(String subquery) {
		super.fromSubquery(subquery);
		joinBuilder.append("FROM (").append(subquery).append(") ");
		return this;
	}
	
	/***
	 * Where to query
	 * @param subquery		Selection destination (subquery)
	 * @return				query
	 */
	@Override
	public SQLSubquery fromSubquery(SQLSubquery subquery) {
		super.fromSubquery(subquery);
		joinBuilder.append("FROM (").append(subquery.create()).append(") ");
		return this;
	}
	
	/***
	 * How to subquery
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				subquery
	 */
	@Override
	public SQLSubquery where(String condition) {
		super.where(condition);
		return this;
	}
	
	/***
	 * How to subquery
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				subquery
	 */
	@Override
	public SQLSubquery where(SQLCondition condition) {
		super.where(condition);
		return this;
	}
	
	/***
	 * What to join
	 * @param tableName		Join table left
	 * @return				subquery
	 */
	public SQLSubquery whereTable(String tableName) {
		joinBuilder.append(tableName).append(' ');
		return this;
	}
	
	/***
	 * What to join
	 * @param tableName		Join table left
	 * @return				subquery
	 */
	public SQLSubquery whereTable(SQLSubquery tableSubquery) {
		joinBuilder.append("(").append(tableSubquery.create()).append(") ");
		return this;
	}
	
	/***
	 * What to join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery joinsTable(String targetTableName) {
		isJoinStmt = true;
		joinBuilder.append("JOIN ").append(targetTableName).append(' ');
		return this;
	}
	
	/***
	 * What to join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery joinsTable(SQLSubquery targetTableSubquery) {
		isJoinStmt = true;
		joinBuilder.append("JOIN ").append(targetTableSubquery.create()).append(' ');
		return this;
	}
	
	/***
	 * What to left join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery leftJoinsTable(String targetTableName) {
		isJoinStmt = true;
		joinBuilder.append("LEFT JOIN ").append(targetTableName).append(' ');
		return this;
	}
	
	/***
	 * What to left join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery leftJoinsTable(SQLSubquery targetTableSubquery) {
		isJoinStmt = true;
		joinBuilder.append("LEFT JOIN ").append(targetTableSubquery.create()).append(' ');
		return this;
	}
	
	/***
	 * What to right join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery rightJoinsTable(String targetTableName) {
		isJoinStmt = true;
		joinBuilder.append("RIGHT JOIN ").append(targetTableName).append(' ');
		return this;
	}
	
	/***
	 * What to right join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery rightJoinsTable(SQLSubquery targetTableSubquery) {
		isJoinStmt = true;
		joinBuilder.append("RIGHT JOIN ").append(targetTableSubquery.create()).append(' ');
		return this;
	}
	
	/***
	 * What to outer join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery outerJoinsTable(String targetTableName) {
		isJoinStmt = true;
		joinBuilder.append("OUTER JOIN ").append(targetTableName).append(' ');
		return this;
	}
	
	/***
	 * What to outer join to
	 * @param tableName		Join table right
	 * @return				subquery
	 */
	public SQLSubquery outerJoinsTable(SQLSubquery targetTableSubquery) {
		isJoinStmt = true;
		joinBuilder.append("OUTER JOIN ").append(targetTableSubquery.create()).append(' ');
		return this;
	}
	
	/***
	 * What to join on
	 * @param attribute		Join attribute
	 * @return				subquery
	 */
	public SQLSubquery onAttribute(String tableName, String attributeName) {
		joinBuilder.append("ON ").append(tableName).append('.').append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * How to order
	 * @param attributeName	Selection ordering
	 * @param ascending		order direction
	 * @return				subquery
	 */
	@Override
	public SQLSubquery orderBy(String attributeName, boolean ascending) {
		super.orderBy(attributeName, ascending);
		joinBuilder.append("ORDER BY ").append(attributeName).append(ascending ? " " : " DESC ");
		return this;
	}
	
	/***
	 * How to order
	 * @param attributeName	Selection ordering
	 * @param ascending		order direction
	 * @return				subquery
	 */
	@Override
	public SQLSubquery orderBy(char attributeName, boolean ascending) {
		super.orderBy(attributeName, ascending);
		joinBuilder.append("ORDER BY ").append(attributeName).append(ascending ? " " : " DESC ");
		return this;
	}
	
	/***
	 * How to group
	 * @param attributeName	Selection grouping
	 * @param ascending		order direction
	 * @return				subquery
	 */
	@Override
	public SQLSubquery groupBy(String attributeName) {
		super.groupBy(attributeName);
		joinBuilder.append("GROUP BY ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * How to group
	 * @param attributeName	Selection grouping
	 * @param ascending		order direction
	 * @return				subquery
	 */
	@Override
	public SQLSubquery groupBy(char attributeName) {
		super.groupBy(attributeName);
		joinBuilder.append("GROUP BY ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Rename the table when returning
	 * @param newTableName		New table name
	 * @return					subquery
	 */
	public SQLSubquery as(String newTableName) {
		super.builder.insert(0, " (").append(") AS ").append(newTableName);
		joinBuilder.insert(0, " (").append(") AS ").append(newTableName);
		return this;
	}
	
	/***
	 * Rename the table when returning
	 * @param newTableName		New table name
	 * @return					subquery
	 */
	public SQLSubquery as(char newTableName) {
		super.builder.insert(0, " (").append(") AS ").append(newTableName);
		joinBuilder.insert(0, " (").append(") AS ").append(newTableName);
		return this;
	}
	
	/***
	 * Reset query
	 * @return				query
	 */
	@Override
	public SQLSubquery clear() {
		super.clear();
		joinBuilder = new StringBuilder();
		return this;
	}
	
	/***
	 * Return the final query
	 * @return query
	 */
	@Override
	public String create() {
		return toString();
	}
	
	/***
	 * Return the final subquery
	 */
	@Override
	public String toString() {
		return (isJoinStmt 
				? joinBuilder.toString()
				: super.builder.toString()).trim();
	}
	
}
