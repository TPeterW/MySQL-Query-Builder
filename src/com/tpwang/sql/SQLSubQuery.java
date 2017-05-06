package com.tpwang.sql;

public class SQLSubquery {
	
	private SQLQuery query;
	
	private boolean hasNewName = false;
	private String newName = null;
	
	public SQLSubquery() {
		this.query = new SQLQuery();
	}
	
	// TODO: add other commands
	
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
				.append('(').append(query.create()).append(')')
				.append(hasNewName ? "as " + newName : "")
				.toString();
	}
	
}
