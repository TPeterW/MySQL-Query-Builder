# SQL-Query-Builder
SQL query statement builder with natural semantics

Usage
----
### *Just chain everything together* &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ---- Chemistry

	String query1 = new SQLQuery()
			.select('*')
			.from("manuscript")
			.where(new SQLCondition()
				.whereAttribute("status")
				.equalsTo("under review")
				.andAttribute("manuscript_id")
				.inSubquery(new SQLSubquery()
						.select("manuscript_id")
						.from("feedback")))
			.create();
		
	String query2 = new SQLQuery()
			.select("manuscript_id")
			.fromSubquery(new SQLSubquery()
					.whereTable(new SQLSubquery()
							.select("manuscript.manuscript_id", "author_id")
							.from("manuscript")
							.joinsTable("feedback")
							.as('T'))
					.joinsTable("issue")
					.onAttribute("issue", "period_number"))
					.groupBy("author_id")
					.orderBy("pub_year", true)
			.create();

	String query3 = new SQLQuery()
			.select('*')
			.from("manuscript")
			.groupBy("author_id")
			.orderBy("author_id", false)
			.orderBy("status", true)
			.create();
				
	String insert1 = new SQLInsertion()
			.intoTable("rihelper")
			.intoColumns("reviewer_id", "ricode_id")
			.withValues("123456", "111111")
			.withValues("234567", "222222")
			.create();

	String update1 = new SQLUpdate()
			.updateTable("author")
			.setAttributeTo("email", "dummy_email@hotmail.com")
			.setAttributeTo("affiliation", 1)
			.where(new SQLCondition()
				.whereAttribute("author_id")
				.equalsTo(123456))
			.create();

	String delete1 = new SQLDelete()
			.fromTable("manuscript")
			.where(new SQLCondition()
				.whereAttribute("author_id")
				.equalsTo("123456"))
			.create();

	stmt.executeQuery(new SQLQuery()
			.select('*')
			.from("manuscript")
			.create());