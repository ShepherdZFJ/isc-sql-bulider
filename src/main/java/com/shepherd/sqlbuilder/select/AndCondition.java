package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;

class AndCondition extends Condition {

	AndCondition(Context context) {
		super(context);
	}

	@Override
	protected String getPrefix() {
		return "AND";
	}
}
