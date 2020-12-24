package com.shepherd.sqlbuilder.select.where;


import com.shepherd.sqlbuilder.Context;

public class AndCondition extends  Condition {

	AndCondition(Context context) {
		super(context);
	}

	@Override
	protected String getPrefix() {
		return "AND";
	}
}
