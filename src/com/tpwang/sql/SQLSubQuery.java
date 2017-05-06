package com.tpwang.sql;

public class SQLSubquery {
	
	private SQLQuery query;
	
	private boolean hasNewName = false;
	private String newName = null;
	
	public SQLSubquery() {
		this.query = new SQLQuery();
	}
	
	/***
	 * What to subquery
	 * @param target		Selection target from table
	 * @return				builder
	 */
	public SQLSubquery select(String target) {
		query.select(target);
		return this;
	}
	
	/***
	 * What to subquery
	 * @param target		Selection target from table
	 * @return				builder
	 */
	public SQLSubquery select(char target) {
		query.select(target);
		return this;
	}
	
	/***
	 * Where to subquery
	 * @param tableName		Selection destination/subquery
	 * @return				builder
	 */
	public SQLSubquery from(String tableName) {
		query.from(tableName);
		return this;
	}
	
	/***
	 * How to subquery
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				builder
	 */
	public SQLSubquery where(String condition) {
		query.where(condition);
		return this;
	}
	
	/***
	 * How to subquery
	 * @param condition		Selection condition (manual or from Attribute)
	 * @return				builder
	 */
	public SQLSubquery where(SQLCondition condition) {
		query.where(condition);
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
		return (new StringBuilder())
				.append(query.create())
				.append(hasNewName ? "as " + newName : "")
				.toString();
	}
	
}
