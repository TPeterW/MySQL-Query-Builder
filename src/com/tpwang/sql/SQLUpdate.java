package com.tpwang.sql;

import java.util.StringJoiner;

public class SQLUpdate {

	private StringBuilder builder = null;		// main builder
	private StringJoiner joiner = null;			// set joiner
	private String condition = null;
	
	/***
	 * Constructor
	 */
	public SQLUpdate() {
		builder = new StringBuilder().append("UPDATE ");
		joiner = new StringJoiner(", ");
	}
	
	/***
	 * Where to update
	 * @param tableName			Table to be updated
	 * @return					update
	 */
	public SQLUpdate updateTable(String tableName) {
		builder.append(tableName).append(' ');
		return this;
	}
	
	/***
	 * What to update
	 * @param attributeName		Attribute to be updated
	 * @param value				updated to
	 * @return					update
	 */
	public SQLUpdate setAttributeTo(String attributeName, String value) {
		joiner.add(new StringBuilder()
					.append(attributeName).append(" = ").append(value).toString());
		return this;
	}
	
	/***
	 * What to update
	 * @param attributeName		Attribute to be updated
	 * @param value				updated to
	 * @return					update
	 */
	public SQLUpdate setAttributeTo(String attributeName, int value) {
		joiner.add(new StringBuilder()
					.append(attributeName).append(" = ").append(value).toString());
		return this;
	}
	
	/***
	 * What to update
	 * @param attributeName		Attribute to be updated
	 * @param value				updated to
	 * @return					update
	 */
	public SQLUpdate setAttributeTo(String attributeName, char value) {
		joiner.add(new StringBuilder()
					.append(attributeName).append(" = ").append(value).toString());
		return this;
	}
	
	/***
	 * What to update
	 * @param attributeName		Attribute to be updated
	 * @param value				updated to
	 * @return					update
	 */
	public SQLUpdate setAttributeTo(String attributeName, boolean value) {
		joiner.add(new StringBuilder()
					.append(attributeName).append(" = ").append(value ? "TRUE" : "FALSE").toString());
		return this;
	}
	
	/***
	 * Where to update
	 * @param condition			Condition for update
	 * @return					update
	 */
	public SQLUpdate where(SQLCondition condition) {
		this.condition = condition.create();
		return this;
	}
	
	/***
	 * Where to update
	 * @param condition			Condition for update
	 * @return					update
	 */
	public SQLUpdate where(String condition) {
		this.condition = condition;
		return this;
	}
	
	/***
	 * Reset update
	 * @return				update
	 */
	public SQLUpdate clear() {
		builder = new StringBuilder().append("UPDATE ");
		joiner = new StringJoiner(", ");
		return this;
	}
	
	/***
	 * Return the final query
	 * @return 				update string
	 */
	public String create() {
		return toString();
	}
	
	/***
	 * Return the final query
	 */
	@Override
	public String toString() {
		return builder.append("SET ").append(joiner.toString()).append(' ')
					.append("WHERE ").append(condition)
					.toString().trim();
	}
	
}
