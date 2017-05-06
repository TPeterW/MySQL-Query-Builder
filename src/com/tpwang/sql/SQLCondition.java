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
		builder.append('`').append(attributeName).append('`');
		return this;
	}
	
	/***
	 * Condition first argument
	 * @param attributeName		First argument in condition
	 * @return					(Unfinished) condition
	 */
	public SQLCondition whereAttribute(char attributeName) {
		builder.append('`').append(attributeName).append('`');
		return this;
	}
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument/subquery in condition 
	 * @return					condition
	 */
	public SQLCondition equalsTo(String attributeValue) {
		builder.append("=\"").append(attributeValue).append("\"");
		return this;
	}
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument/subquery in condition 
	 * @return					condition
	 */
	public SQLCondition equalsTo(char attributeValue) {
		builder.append("=\"").append(attributeValue).append("\"");
		return this;
	}
	
	/***
	 * Condition second argument
	 * @param attributeValue	Second argument/subquery in condition 
	 * @return					condition
	 */
	public SQLCondition equalsTo(int attributeValue) {
		builder.append("=\"").append(attributeValue).append("\"");
		return this;
	}
	
	/***
	 * Return the final condition
	 * @return condition
	 */
	public String make() {
		return toString();
	}
	
	/***
	 * Return the final condition
	 */
	public String toString() {
		return builder.toString();
	}
}
