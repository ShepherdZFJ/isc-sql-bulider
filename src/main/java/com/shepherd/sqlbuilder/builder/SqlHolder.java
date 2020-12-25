package com.shepherd.sqlbuilder.builder;

import com.shepherd.sqlbuilder.*;
import com.shepherd.sqlbuilder.Utils.SqlStringUtil;
import com.shepherd.sqlbuilder.enums.DatabaseTypeEnum;
import com.shepherd.sqlbuilder.enums.JoinTypeEnum;
import com.shepherd.sqlbuilder.select.From;
import com.shepherd.sqlbuilder.select.Select;
import com.shepherd.sqlbuilder.select.where.*;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 21:14
 */
public class SqlHolder {
    private static Logger log = LoggerFactory.getLogger(SqlBuilder.class);

    public static String getSql(EntityRelation entityRelation) {
        try {
            DatabaseTypeEnum databaseTypeEnum = DatabaseTypeEnum.getType(entityRelation.getDataSource().getType());
            SqlBuilder sqlBuilder = new SqlBuilder(databaseTypeEnum);
            if (entityRelation == null) {
                return null;
            }
            Select select = sqlBuilder.select();
            if (entityRelation.getColumns() == null && entityRelation.getColumns().size() == 0) {
                select = select.all();
            } else {
                for (Column column : entityRelation.getColumns()) {
                    select.column(SqlStringUtil.handleColumn(column));
                }
            }
            From from = select.from();
            Table table = entityRelation.getTable();
            from.tables(table.getNames());
            if (table.getTableRelations() != null && table.getTableRelations().size() != 0) {
                for (TableRelation tableRelation : table.getTableRelations()) {
                    from.join(JoinTypeEnum.getType(tableRelation.getJoinType()), SqlStringUtil.handleJoin(tableRelation));
                }
            }
            Where where = from.where();
            if (StringUtils.isNotBlank(entityRelation.getFilter())) {
                where.and(entityRelation.getFilter());
            }
            if (entityRelation.getConditions() != null && entityRelation.getConditions().size() != 0) {
                for(ConditionDTO conditionDTO : entityRelation.getConditions()) {
                    if (conditionDTO.getConditionList() != null && conditionDTO.getConditionList().size() != 0) {
                        List<String> conditions = new ArrayList<>();
                        conditionDTO.getConditionList().forEach(conditionDTO1 -> {
                            String condition = SqlStringUtil.handCondition(conditionDTO1);
                            conditions.add(condition);
                        });
                        where.or(conditions);
                    } else {
                        where.and(SqlStringUtil.handCondition(conditionDTO));
                    }
                }
            }
            if (entityRelation.getGroupBys() != null && entityRelation.getGroupBys().size() != 0) {
                where.groupBy(entityRelation.getGroupBys());
            }
            if (entityRelation.getOrderBys() != null && entityRelation.getOrderBys().size() != 0) {
                where.orderBy(entityRelation.getOrderBys());
            }
            if (entityRelation.getLimit() != null) {
                where.limit(entityRelation.getLimit().getStart(), entityRelation.getLimit().getSize());
            }
            return sqlBuilder.sql();



        } catch (Exception e) {
            log.error("sql builder error", e);
        }
        return null;


    }
}
