package com.shepherd.sqlbuilder.select;

import com.shepherd.sqlbuilder.Context;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GroupBy  {
	private final Context context;

	private final List<String> columns;

	private boolean terminated = false;

	public GroupBy(Context context) {
		this.context = context;
		context.appendLine("GROUP BY");
		columns = new LinkedList<>();
	}

	public GroupBy(Context context, String... columns) {
		this(context);
		this.columns.addAll(Arrays.asList(columns));
	}

	public GroupBy(Context context, List<String> columns) {
		this(context);
		this.columns.addAll(columns);
	}

	public GroupBy column(String column) {
		columns.add(column);
		return this;
	}

	public GroupBy columns(List<String> columns) {
		this.columns.addAll(columns);
		return this;
	}


	public GroupBy columns(String... columns) {
		this.columns.addAll(Arrays.asList(columns));
		return this;
	}

	public Having having() {
		terminate();
		return new Having(context);
	}

	public Having having(String condition) {
		terminate();
		return new Having(context, condition);
	}

	public OrderBy orderBy() {
		terminate();
		return new OrderBy(context);
	}

	public OrderBy orderBy(String... columns) {
		terminate();
		return new OrderBy(context, columns);
	}

	public OrderBy orderBy(OrderByType order, String... columns) {
		terminate();
		return new OrderBy(context, order, columns);
	}

	public OrderBy orderBy(String column, OrderByType order) {
		terminate();
		return new OrderBy(context, order, column);
	}
//
//	@Override
//	public <E> List<E> list(RowMapper<E> rowMapper) throws SQLException {
//		terminate();
//		return context.list(rowMapper);
//	}
//
//	@Override
//	public <E> E single(RowMapper<E> rowMapper) throws SQLException {
//		terminate();
//		return context.single(rowMapper);
//	}

	public String sql() {
		terminate();
		return context.sql();
	}

	private void terminate() {
		if (!terminated) {
			context.appendSpace(StringUtils.join(columns, ", "));
			terminated = true;
		}
	}
}
