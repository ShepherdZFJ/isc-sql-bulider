package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.enums.JoinTypeEnum;
import com.shepherd.sqlbuilder.select.join.InnerJoin;
import com.shepherd.sqlbuilder.select.join.Join;
import com.shepherd.sqlbuilder.select.join.LeftJoin;
import com.shepherd.sqlbuilder.select.join.RightJoin;
import com.shepherd.sqlbuilder.select.limit.Limit;
import com.shepherd.sqlbuilder.select.where.Where;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class From  {
	private Context context;
	private boolean terminated = false;

	private final List<String> tables = new ArrayList<>();

	From(Context context) {
		this.context = context;
		this.context.appendLine("FROM");
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


	public GroupBy groupBy() {
		terminate();
		return new GroupBy(context);
	}

	public GroupBy groupBy(String... columns) {
		terminate();
		return new GroupBy(context, columns);
	}

//	public Join lefterJoin(String condition) {
//		terminate();
//		return new LeftJoin(context, condition);
//	}
//
//	public Join rightJoin(String condition) {
//		terminate();
//		return new RightJoin(context, condition);
//	}
//
//	public Join innerJoin(String condition) {
//		terminate();
//		return new InnerJoin(context, condition);
//	}

	public Join join(JoinTypeEnum joinTypeEnum, String condition) {
		terminate();
		context.setJoinTypeEnum(joinTypeEnum);
		return new Join(context, condition);
	}

	public OrderBy orderBy() {
		terminate();
		return new OrderBy(context);
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
			this.context.appendSpace(StringUtils.join(tables, ", " ));
			terminated = true;
		}
	}
}
