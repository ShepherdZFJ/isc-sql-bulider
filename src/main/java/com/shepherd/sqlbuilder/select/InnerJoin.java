package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;

class InnerJoin extends Join {

	InnerJoin(Context context, String condition) {
		super(context, condition);
	}

	InnerJoin(Context context) {
		super(context);
	}

	@Override
	protected String expression() {
		return "INNER JOIN";
	}
}
