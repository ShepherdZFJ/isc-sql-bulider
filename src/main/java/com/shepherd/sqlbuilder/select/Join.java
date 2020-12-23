package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.limit.Limit;

import java.sql.SQLException;
import java.util.List;

public abstract class Join {
	private Context context;

	Join(Context context) {
		this.context = context;
		context.appendLine(expression());
	}

	Join(Context context, String condition) {
		this(context);
		context.appendLine(condition);
	}

	public OrderBy orderBy() {
		return new OrderBy(context);
	}

	public Where where() {
		return new Where(context);
	}

	public Where where(String condition) {
		return new Where(context, condition);
	}

	public Limit limit(int start, int size) {
		return new Limit(context, start, size);
	}


	protected abstract String expression();


	public String getSql() {
		return context.getSql();
	}
}
