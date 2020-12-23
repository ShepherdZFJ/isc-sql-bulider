package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;

class OrCondition extends Condition {

	OrCondition(Context context) {
		super(context);
	}

	@Override
	protected String getPrefix() {
		return "OR";
	}
}
