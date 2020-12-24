package com.shepherd.sqlbuilder.select.where;


import com.shepherd.sqlbuilder.Context;

public class OrCondition extends Condition {

	OrCondition(Context context) {
		super(context);
	}

	@Override
	protected String getPrefix() {
		return "OR";
	}
}
