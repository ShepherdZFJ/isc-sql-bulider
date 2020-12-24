package com.shepherd.sqlbuilder.select.join;


import com.shepherd.sqlbuilder.Context;


public class LeftJoin  implements Joiner {

	private static final String EXPRESSION = "LEFT JOIN";



	@Override
	public Context join(Context context, String condition) {
		context.appendLine(EXPRESSION);
		context.appendSpace(condition);
		return context;
	}
}
