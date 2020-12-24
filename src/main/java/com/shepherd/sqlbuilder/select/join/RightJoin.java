package com.shepherd.sqlbuilder.select.join;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.join.Join;

public class RightJoin implements Joiner {

//	public RightJoin(Context context, String condition) {
//		super(context, condition);
//	}
//
//	RightJoin(Context context) {
//		super(context);
//	}
//
//	@Override
//	protected String expression() {
//		return "RIGHT JOIN";
//	}

	private static final String EXPRESSION = "RIGHT JOIN";



	@Override
	public Context join(Context context, String condition) {
		context.appendLine(EXPRESSION);
		context.appendSpace(condition);
		return context;
	}

}
