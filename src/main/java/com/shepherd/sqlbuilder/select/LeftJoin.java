package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;

class LeftJoin extends Join {

	LeftJoin(Context context) {
		super(context);
	}

	LeftJoin(Context context, String condition) {
		super(context, condition);
	}

	@Override
	protected String expression() {
		return "LEFT JOIN";
	}
}
