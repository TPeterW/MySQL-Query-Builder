package com.tpwang.sql;

import java.util.StringJoiner;

public class SQLInsertion {

	private StringBuilder builder = null;		// main builder
	private StringJoiner joiner = null;			// main joiner
	
	/***
	 * Constructor
	 */
	public SQLInsertion() {
		builder = new StringBuilder().append("INSERT ");
	}
	
	/***
	 * Which table to insert into
	 * @param tableName		table name
	 * @return				insert
	 */
	public SQLInsertion intoTable(String tableName) {
		builder.append("INTO ").append(tableName).append(' ');
		return this;
	}
	
	/***
	 * Which columns to insert into
	 * @param columns		column names
	 * @return				insert
	 */
	public SQLInsertion intoColumns(String... columns) {
		builder.append('(');
		StringJoiner valueJoiner = new StringJoiner(", ");
		for (String col : columns) {
			valueJoiner.add('`' + col + '`');
		}
		builder.append(valueJoiner.toString()).append(") ");
		return this;
	}
	
	/***
	 * Which columns to insert into
	 * @param columns		column names
	 * @return				insert
	 */
	public SQLInsertion intoColumns(String columns) {
		builder.append('(').append(columns).append(") ");
		return this;
	}
	
	/***
	 * What values to insert
	 * @param values		values
	 * @return				insert
	 */
	public SQLInsertion withValues(String... values) {
		if (joiner == null)
			joiner = new StringJoiner(", ");
		
		StringBuilder valueBuilder = new StringBuilder();
		StringJoiner valueJoiner = new StringJoiner(",");
		valueBuilder.append('(');
		for (String val : values) {
			valueJoiner.add('\"' + val + '\"');
		}
		valueBuilder.append(valueJoiner.toString());
		valueBuilder.append(')');
		
		joiner.add(valueBuilder.toString());
		
		return this;
	}
	
	/***
	 * What values to insert
	 * - This is to let you insert integers and other types in improve performance
	 * - make sure your values match the number of columns you supplied before 
	 * @param values		values
	 * @return				insert
	 */
	public SQLInsertion withValues(String values) {
		if (joiner == null)
			joiner = new StringJoiner(", ");
		joiner.add('(' + values + ')');
		return this;
	}
	
	/***
	 * Return the final query
	 * @return 				query string
	 */
	public String create() {
		return toString();
	}
	
	/***
	 * Return the final query
	 */
	@Override
	public String toString() {
		return builder
				.append((joiner == null) ? "" : "VALUES " + joiner.toString())
				.toString().trim();
	}
	
}
