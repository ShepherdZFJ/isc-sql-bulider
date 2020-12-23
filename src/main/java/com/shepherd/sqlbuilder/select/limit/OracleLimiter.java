package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.Context;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:54
 */
public class OracleLimiter implements Limiter {

    @Override
    public Context limit(Context context, int start, int size) {
        Context c = new Context(context);
        c.appendLine("SELECT");
        c.appendLine("data.*");
        c.appendLine("FROM");
        c.appendLine("(");
        c.appendLine("SELECT");
        c.appendLine("ord_data.*,");
        c.appendLine("rownum AS rnum");
        c.appendLine("FROM");
        c.appendLine("(");
        c.appendLine(context.toString());
        c.appendLine(")");
        c.appendLine("ord_data");
        c.appendLine(")");
        c.appendLine("data");
        c.appendLine("WHERE");
        c.appendLine("rnum BETWEEN ? AND ?");
        c.addParameters(start);
        c.addParameters(start + size);
        return c;
    }
}