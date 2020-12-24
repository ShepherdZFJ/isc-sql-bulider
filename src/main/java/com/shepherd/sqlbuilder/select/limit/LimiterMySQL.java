package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.Context;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:56
 */
public class LimiterMySQL implements Limiter {

    @Override
    public Context limit(Context context, int start, int size) {
        context.appendLine("LIMIT " + size);
        context.appendSpace("OFFSET " + start);
        return context;
    }
}
