package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Having  {
	private final Context context;

	private boolean terminated = false;

	private final List<String> conditions;

	Having(Context context) {
		this.context = context;
		this.context.appendLine("HAVING");
		conditions = new LinkedList<>();
	}

	Having(Context context, String... conditions) {
		this(context);
		this.conditions.addAll(Arrays.asList(conditions));
	}

	public Having condition(String condition) {
		conditions.add(condition);
		return this;
	}

	public Having conditions(String... conditions) {
		this.conditions.addAll(Arrays.asList(conditions));
		return this;
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

	public String sql() {
		terminate();
		return context.sql();
	}

	private void terminate() {
		if (!terminated) {
			context.appendSpace(StringUtils.join(conditions, ", "));
			terminated = true;
		}
	}
}
