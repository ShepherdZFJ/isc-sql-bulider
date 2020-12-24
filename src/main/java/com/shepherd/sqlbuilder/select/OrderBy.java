package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.limit.Limit;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderBy {
	private Context context;

	private OrderByType order;

	private boolean terminated = false;

	private final List<String> columns = new ArrayList<>();

	public OrderBy(Context context) {
		this.context = context;
		this.order = OrderByType.ASC;
		context.appendLine("ORDER BY");
	}

	public OrderBy(Context context, String... columns) {
		this(context);
		this.columns.addAll(Arrays.asList(columns));
	}

	public OrderBy(Context context, List<String> columns) {
		this(context);
		this.columns.addAll(columns);
		terminate();
	}

	OrderBy(Context context, OrderByType order, String... columns) {
		this(context, columns);
		this.order = order;
	}

	public OrderBy column(String column) {
		return column(column, OrderByType.ASC);
	}

	public OrderBy columns(String... columns) {
		this.columns.addAll(Arrays.asList(columns));
		this.order = OrderByType.ASC;
		return this;
	}

	public OrderBy columns(OrderByType order, String... columns) {
		columns(columns);
		this.order = order;
		return this;
	}

	public OrderBy column(String column, OrderByType order) {
		if (order == null) {
			return column(column);
		}

		columns.add(column);
		this.order = order;
		return this;
	}

	public Limit limit(int start, int size) {
		terminate();
		return new Limit(context, start, size);
	}


	public String sql() {
		terminate();
		return context.sql();
	}

	private void terminate() {
		if (!terminated) {
			context.appendSpace(StringUtils.join(columns, ", "));
		}
	}
}
