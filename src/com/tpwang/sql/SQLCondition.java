package com.tpwang.sql;

public class SQLCondition {
	
	private StringBuilder builder;
	
	/***
	 * Constructor
	 */
	public SQLCondition() {
		builder = new StringBuilder();
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition whereAttribute(String attributeName) {
		builder.append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition whereAttribute(char attributeName) {
		builder.append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition andAttribute(String attributeName) {
		builder.append("AND ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition andAttribute(char attributeName) {
		builder.append("AND ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition orAttribute(String attributeName) {
		builder.append("OR ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition orAttribute(char attributeName) {
		builder.append("OR ").append(attributeName).append(' ');
		return this;
	}
	
	/***
	 * Condition second argument
	 * @param subquery			Subquery in condition
	 * @return					condition
	 */
	public SQLCondition equalsToSubquery(SQLSubquery subquery) {
		builder.append("= (").append(subquery.create()).append(") ");
		return this;
	}
	
	/***
	 * Condition second argument
	 * @param subquery			Subquery in which the target is
	 * @return					condition
	 */
	public SQLCondition inSubquery(SQLSubquery subquery) {
		builder.append("IN (").append(subquery.create()).append(") ");
		return this;
	}
	
	/***
	 * Condition second argument
	 * @param subquery			Subquery in which the target is
	 * @return					condition
	 */
	public SQLCondition notInSubquery(SQLSubquery subquery) {
		builder.append("NOT IN (").append(subquery.create()).append(") ");
		return this;
	}
	
	//-- Equals --//
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition equalsTo(String attributeValue) { builder.append("= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition equalsTo(char attributeValue) { builder.append("= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition equalsTo(int attributeValue) { builder.append("= \"").append(attributeValue).append("\" "); return this; }
	
	//-- Larger than --//
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition largerThan(String attributeValue) { builder.append("> \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition largerThan(char attributeValue) { builder.append("> \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition largerThan(int attributeValue) { builder.append("> \"").append(attributeValue).append("\" "); return this; }
	
	//-- Less than --//
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition lessThan(String attributeValue) { builder.append("< \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition lessThan(char attributeValue) { builder.append("< \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition lessThan(int attributeValue) { builder.append("< \"").append(attributeValue).append("\" "); return this; }

	//-- Larger than or equal to --//
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition largerThanOrEqualTo(String attributeValue) { builder.append(">= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition largerThanOrEqualTo(char attributeValue) { builder.append(">= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition largerThanOrEqualTo(int attributeValue) { builder.append(">= \"").append(attributeValue).append("\" "); return this; }
	
	//-- Less than or equal to --//
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition lessThanOrEqualTo(String attributeValue) { builder.append("<= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition lessThanOrEqualTo(char attributeValue) { builder.append("<= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument in condition 
	 * @return					condition
	 */
	public SQLCondition lessThanOrEqualTo(int attributeValue) { builder.append("<= \"").append(attributeValue).append("\" "); return this; }
	
	/***
	 * Return the final condition
	 * @return condition
	 */
	public String create() {
		return toString();
	}
	
	/***
	 * Return the final condition
	 */
	public String toString() {
		return builder.toString().trim();
	}
}
