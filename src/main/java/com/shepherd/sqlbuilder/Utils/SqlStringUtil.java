package com.shepherd.sqlbuilder.Utils;

import com.shepherd.sqlbuilder.Column;
import org.apache.commons.lang.StringUtils;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 13:35
 */
public class SqlStringUtil {
    public static String handleSqlName(String name) {
        if (StringUtils.isBlank(name)) {
            return name;
        }
        return "`" + name + "`";
    }

    public static String handleColumn(Column column) {
        StringBuilder s = new StringBuilder();
        if (StringUtils.isNotBlank(column.getTable())) {
            s.append(column.getTable()).append(".");
        }
        s.append(column.getName());
        if (StringUtils.isNotBlank(column.getAliasName())) {
            s.append(" AS ").append(handleSqlName(column.getAliasName()));
        }
        return s.toString();

    }
}
