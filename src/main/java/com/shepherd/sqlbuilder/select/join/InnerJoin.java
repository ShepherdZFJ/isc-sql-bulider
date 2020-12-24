package com.shepherd.sqlbuilder.select.join;


import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.join.Join;

public class InnerJoin implements Joiner {

//	public InnerJoin(Context context, String condition) {
//		super(context, condition);
//	}
//
//	InnerJoin(Context context) {
//		super(context);
//	}
//
//	@Override
//	protected String expression() {
//		return "INNER JOIN";
//	}

	private static final String EXPRESSION = "INNER JOIN";



	@Override
	public Context join(Context context, String condition) {
		context.appendLine(EXPRESSION);
		context.appendSpace(condition);
		return context;
	}

}
