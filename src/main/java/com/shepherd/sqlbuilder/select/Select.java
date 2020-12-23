package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class Select {
	private final Context context;

	private final List<String> columns;

	public Select(Context context) {
		this.context = context;
		this.context.appendSpace("SELECT");
		columns = new LinkedList<>();
	}

	public From from() {
		this.context.appendSpace(StringUtils.join(columns, ", "));
		return new From(context);
	}

	public Select all() {
		append("*");
		return this;
	}

	public Select column(String column) {
		append(column);
		return this;
	}

	public Select columns(String... columns) {
		for (String column : columns) {
			append(column);
		}

		return this;
	}

	public Select count(String column) {
		append("COUNT(" + column + ")");
		return this;
	}

	private void append(String expression) {
		columns.add(expression);
	}


	public String getSql() {
		return context.getSql();
	}
}
