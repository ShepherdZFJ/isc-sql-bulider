package com.shepherd.sqlbuilder.select.join;

import com.shepherd.sqlbuilder.Context;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/24 17:35
 */
public interface Joiner {

    Context join(Context context, String condition);
}
