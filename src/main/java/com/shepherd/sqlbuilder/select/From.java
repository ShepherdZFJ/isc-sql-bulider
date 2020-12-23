package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.limit.Limit;
import org.apache.commons.lang.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class From  {
	private Context context;

	private boolean terminated = false;

	private final List<String> tables = new ArrayList<>();

	From(Context context) {
		this.context = context;
		this.context.appendLine("FROM ");
	}

	public From table(String table) {
		tables.add(table);
		return this;
	}

	public From tables(String... tables) {
		this.tables.addAll(Arrays.asList(tables));
		return this;
	}

	public From tables(List<String> tables) {
		this.tables.addAll(tables);
		return this;
	}

	public From select(String selectQuery, String alias) {
		this.tables.add("(" + selectQuery + ") " + alias);
		return this;
	}

	public Where where() {
		terminate();
		return new Where(context);
	}

	public Where where(String condition) {
		terminate();
		return new Where(context, condition);
	}

	public String getSql() {
		terminate();
		return context.getSql();
	}

	private void terminate() {
		if (!terminated) {
			this.context.appendSpace(StringUtils.join(tables, ", " ));
			terminated = true;
		}
	}
}
