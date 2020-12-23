package com.shepherd.sqlbuilder.builder;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.Database;
import com.shepherd.sqlbuilder.select.Select;

public class QueryBuilder {
	private final Context context;

	public QueryBuilder(Database database, DataSource dataSource)
		throws SQLException {
		this(database, dataSource.getConnection());
	}

	public QueryBuilder(Database database, Connection connection) {
		this.context = new Context(database, connection);
	}

	public Select select() {
		return new Select(context);
	}

	public String getSql() {
		return context.getSql();
	}
}
