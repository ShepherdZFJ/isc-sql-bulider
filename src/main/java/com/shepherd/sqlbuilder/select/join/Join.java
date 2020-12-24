package com.shepherd.sqlbuilder.select.join;




import com.shepherd.sqlbuilder.Context;
import com.shepherd.sqlbuilder.select.OrderBy;
import com.shepherd.sqlbuilder.select.where.*;
import com.shepherd.sqlbuilder.select.limit.Limit;

public  class Join {
	private Context context;

	public Join(Context context, String condition) {
		this.context = join(context, condition);
	}

	private Context join(Context context, String condition) {
		return new JoinFactory()
				.create(context.getJoinTypeEnum())
				.join(context, condition);
	}


	public OrderBy orderBy() {
		return new OrderBy(context);
	}

	public Where where() {
		return new Where(context);
	}

	public Where where(String condition) {
		return new Where(context, condition);
	}

	public Limit limit(int start, int size) {
		return new Limit(context, start, size);
	}




	public String sql() {
		return context.sql();
	}
}
