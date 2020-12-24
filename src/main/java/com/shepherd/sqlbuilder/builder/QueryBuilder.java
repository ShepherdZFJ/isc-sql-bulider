package com.shepherd.sqlbuilder.builder;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.Select;

public class QueryBuilder {
	private  Context context;

//	public QueryBuilder(Database database, DataSource dataSource)
//		throws SQLException {
//		this(database, dataSource.getConnection());
//	}
//
//	public QueryBuilder(Database database, Connection connection) {
//		this.context = new Context(database, connection);
//	}

	public Select select() {
		return new Select(context);
	}

	public String sql() {
		return context.sql();
	}
}
