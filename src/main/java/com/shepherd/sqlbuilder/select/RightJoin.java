package com.shepherd.sqlbuilder.select;


import com.shepherd.sqlbuilder.Context;

class RightJoin extends Join {

	RightJoin(Context context, String condition) {
		super(context, condition);
	}

	RightJoin(Context context) {
		super(context);
	}

	@Override
	protected String expression() {
		return "RIGHT JOIN";
	}
}
