package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.Context;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:48
 */
public interface Limiter {
        Context limit(Context context, int start, int size);
}
