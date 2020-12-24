package com.shepherd.sqlbuilder.builder;

import com.shepherd.sqlbuilder.*;
import com.shepherd.sqlbuilder.enums.DatabaseTypeEnum;
import com.shepherd.sqlbuilder.select.Select;


/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 11:42
 */

public class SqlBuilder {
    private final Context context;

    public SqlBuilder(DatabaseTypeEnum databaseTypeEnum) {
        this.context = new Context(databaseTypeEnum);
    }
    public Select select() {
        return new Select(context);
    }

    public String sql() {
        return context.sql();
    }

}
