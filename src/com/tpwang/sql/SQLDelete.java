package com.tpwang.sql;

public class SQLDelete {
	
	private StringBuilder builder = null;
	
	/***
	 * Constructor
	 */
	public SQLDelete() {
		builder = new StringBuilder().append("DELETE ");
	}
	
	/***
	 * Where to delete from
	 * @param tableName			Delete table name
	 * @return					delete
	 */
	public SQLDelete fromTable(String tableName) {
		builder.append("FROM ").append(tableName).append(' ');
		return this;
	}
	
	/***
	 * How to delete
	 * @param condition			Delete condition
	 * @return					delete
	 */
	public SQLDelete where(SQLCondition condition) {
		builder.append(condition.toString());
		return this;
	}
	
	/***
	 * How to delete
	 * @param condition			Delete condition
	 * @return					delete
	 */
	public SQLDelete where(String condition) {
		builder.append(condition);
		return this;
	}
	
	/***
	 * Return the final query
	 * @return					delete string
	 */
	public String create() {
		return toString();
	}
	
	/***
	 * Return the final query
	 */
	@Override
	public String toString() {
		return builder.toString().trim();
	}
}
