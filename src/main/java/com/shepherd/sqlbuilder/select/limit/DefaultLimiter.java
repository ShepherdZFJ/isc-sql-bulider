package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.Context;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:53
 */
public class DefaultLimiter implements Limiter {

    @Override
    public Context limit(Context context, int start, int size) {
        return context;
    }
}
