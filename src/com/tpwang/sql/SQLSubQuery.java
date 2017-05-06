package com.tpwang.sql;

public class SQLSubquery {
	
	private SQLQuery query;
	
	// whether to rename
	private boolean hasNewName = false;
	private String newName = null;
	
	// whether a join statement
	private boolean isJoinStmt = false;
	private StringBuilder joinBuilder = null;
	
	public SQLSubquery() {
		this.query = new SQLQuery();
		joinBuilder = new StringBuilder().append(' ');
	}
	
	/***
	 * What to subquery
	 * @param target		Selection target from table
	 * @return				subquery
	 */
	public SQLSubquery select(String target) {
		query.select(target);
		joinBuilder.append("SELECT ").append(target).append(' ');
		return this;
	}
	
	/***
	 * What to query
	 * @param target		Selection targets from table
	 * @return				query
	 */
	public SQLSubquery select(String... targets) {
		query.select(targets);
		joinBuilder.append("SELECT ");
		for (String str : targets) {
			joinBuilder.append(str);
		}
		joinBuilder.append(' ');
		return this;
	}
	
	/***
	 * What to subquery
	 * @param target		Selection target from table
	 * @return				subquery
	 */
	public SQLSubquery select(char target) {
		query.select(target);
		joinBuilder.append("SELECT ").append(target).append(' ');
		return this;
	}
	
	/***
	 * Where to subquery
	 * @param tableName		Selection destination/subquery
	 * @return				subquery
	 */
	public SQLSubquery from(String tableName) {
		query.from(tableName);
		joinBuilder.append("FROM ").append(tableName).append(' ');
		return this;
	}
	
	/***
	 * Where to query
	 * @param subquery		Selection destination (subquery)
	 * @return				query
	 */
	public SQLSubquery fromSubquery(String subquery) {
		query.fromSubquery(subquery);
		joinBuilder.append("FROM (").append(subquery).append(") ");
		return this;
	}
	
	/***
	 * Where to query
	 * @param subquery		Selection destination (subquery)
	 * @return				query
	 */
	public SQLSubquery fromSubquery(SQLSubquery subquery) {
		query.fromSubquery(subquery);
		joinBuilder.append("FROM (").append(subquery.create()).append(") ");
		return this;
	}
	
	/***
	 * How to subquery
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				subquery
	 */
	public SQLSubquery where(String condition) {
		query.where(condition);
		return this;
	}
	
	/***
	 * How to subquery
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				subquery
	 */
	public SQLSubquery where(SQLCondition condition) {
		query.where(condition);
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
		joinBuilder.append("( ").append(tableSubquery.create()).append(") ");
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
		joinBuilder.append("ON ").append('`').append(tableName).append('.').append(attributeName).append("` ");
		return this;
	}
	
	/***
	 * Rename the table when returning
	 * @param newTableName		New table name
	 * @return					subquery
	 */
	public SQLSubquery as(String newTableName) {
		hasNewName = true;
		newName = newTableName;
		return this;
	}
	
	/***
	 * Rename the table when returning
	 * @param newTableName		New table name
	 * @return					subquery
	 */
	public SQLSubquery as(char newTableName) {
		hasNewName = true;
		newName = Character.toString(newTableName);
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
	 * Return the final subquery
	 */
	public String toString() {
		return isJoinStmt 
				? joinBuilder.toString()
				: (new StringBuilder())
				.append(query.create())
				.append(hasNewName ? "as " + newName : "")
				.toString();
	}
	
}
