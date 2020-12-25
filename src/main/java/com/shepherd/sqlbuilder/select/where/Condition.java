package com.shepherd.sqlbuilder.select.where;


import com.shepherd.sqlbuilder.Context;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Objects;

public abstract class Condition {
	protected final Context context;

	Condition(Context context) {
		this.context = context;
	}

	void add(Object condition) {
		if (Objects.equals("WHERE", getPrefix())) {
			context.appendLine(getPrefix()  + " " + condition);
		} else {
			context.appendSpace(getPrefix() + " " + condition);
		}
	}

	void add(List<Object> conditions) {
		context.appendSpace("(");
		for (Object condition : conditions) {
				context.appendSpace(getPrefix() + " " + condition);
			}
		context.appendSpace(")");
	}

	void add(Object condition, Object parameter) {
		if (parameter != null) {
			add(condition, new Object[] { parameter });
		}
	}

	void add(String condition, String parameter) {
		if (StringUtils.isNotBlank(parameter)) {
			add(condition, new Object[] { parameter });
		}
	}

	void add(Object condition, Object... parameters) {
		if (ArrayUtils.isNotEmpty(parameters)) {
			add(condition);
		}
	}

	void between(String columnName, Object start, Object end) {
		if (start == null) {
			if (end != null) {
				add(columnName + " <= ?", end);
			}
		} else {
			if (end == null) {
				add(columnName + " >= ?", start);
			} else {
				add(columnName + " BETWEEN ? AND ?", start, end);
			}
		}
	}

	protected abstract String getPrefix();
}
