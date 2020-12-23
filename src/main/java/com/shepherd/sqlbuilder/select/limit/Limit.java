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

//        @Override
//        public <E> List<E> list(RowMapper<E> rowMapper) throws SQLException {
//            return context.list(rowMapper);
//        }
//
//        @Override
//        public <E> E single(RowMapper<E> rowMapper) throws SQLException {
//            return context.single(rowMapper);
//        }

    private Context limit(Context context, int start, int size) {
        return new LimiterFactory()
                .create(context.getDatabase())
                .limit(context, start, size);
    }

    public String getSql() {
        return context.getSql();
    }



}
