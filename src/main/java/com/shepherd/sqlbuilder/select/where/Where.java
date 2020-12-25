package com.shepherd.sqlbuilder.select.where;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.*;
import com.shepherd.sqlbuilder.select.limit.Limit;

import java.util.List;

public class Where extends Condition {

	public Where(Context context) {
		super(context);
		add("1 = 1");
	}

	public Where(Context context, String condition) {
		super(context);
		add(condition);
	}

	public GroupBy groupBy() {
		return new GroupBy(context);
	}

	public GroupBy groupBy(String... columns) {
		return new GroupBy(context, columns);
	}

	public GroupBy groupBy(List<String> columns) {
		return new GroupBy(context, columns);
	}

	public OrderBy orderBy() {
		return new OrderBy(context);
	}

	public OrderBy orderBy(String... columns) {
		return new OrderBy(context, columns);
	}

	public OrderBy orderBy(List<String> columns) {
		return new OrderBy(context, columns);
	}


	public Where and(Object condition) {
		new AndCondition(context).add(condition);
		return this;
	}


	public Where or(List<Object> conditions) {
		new OrCondition(context).add(conditions);
		return this;
	}

	public Where or(Object condition) {
		new OrCondition(context).add(condition);
		return this;
	}


	public Limit limit(int start, int size) {
		return new Limit(context, start, size);
	}


	@Override
	protected String getPrefix() {
		return "WHERE";
	}


	public String sql() {
		return context.sql();
	}
}
