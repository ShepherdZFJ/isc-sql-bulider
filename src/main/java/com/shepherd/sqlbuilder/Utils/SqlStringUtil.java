package com.shepherd.sqlbuilder.Utils;

import com.shepherd.sqlbuilder.Column;
import com.shepherd.sqlbuilder.ConditionDTO;
import com.shepherd.sqlbuilder.TableRelation;
import com.shepherd.sqlbuilder.select.where.Condition;
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

    public static String handleJoin(TableRelation tableRelation) {
        StringBuilder s = new StringBuilder();
        s.append(tableRelation.getLinkTable()).append(" on ").append(tableRelation.getCenterColumn())
                .append(tableRelation.getCompareType()).append(tableRelation.getLinkColumn());
        return s.toString();
    }

    public static String handCondition(ConditionDTO conditionDTO) {
        StringBuilder s = new StringBuilder();
        s.append(conditionDTO.getName()).append(conditionDTO.getCompareType()).append(conditionDTO.getValue());
        return s.toString();
    }
}
