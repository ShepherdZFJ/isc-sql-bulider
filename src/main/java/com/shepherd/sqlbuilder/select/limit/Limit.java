package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.Context;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:46
 */
public class Limit {

    private final Context context;

    public Limit(Context context, int start, int size) {
        this.context = limit(context, start, size);
    }


    private Context limit(Context context, int start, int size) {
        return new LimiterFactory()
                .create(context.getDatabaseTypeEnum())
                .limit(context, start, size);
    }

    public String sql() {
        return context.sql();
    }



}
