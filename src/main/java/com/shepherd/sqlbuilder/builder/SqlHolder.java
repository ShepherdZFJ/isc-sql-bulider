package com.shepherd.sqlbuilder.builder;

import com.shepherd.sqlbuilder.*;
import com.shepherd.sqlbuilder.Utils.SqlStringUtil;
import com.shepherd.sqlbuilder.select.From;
import com.shepherd.sqlbuilder.select.Select;
import com.shepherd.sqlbuilder.select.Where;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 21:14
 */
public class SqlHolder {
    private static Logger log = LoggerFactory.getLogger(SqlBuilder.class);


    public static String getSql(EntityRelation entityRelation) {
        try {
            Connection connection = new MemoryDatabase().getConnection();
            QueryBuilder queryBuilder = new QueryBuilder(Database.HSQLDB, connection);
            if (entityRelation == null) {
                return null;
            }
            Select select = queryBuilder.select();
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
            Where where = from.where();
            if (StringUtils.isNotBlank(entityRelation.getFilter())) {
                where.and(entityRelation.getFilter());
            }
            if (entityRelation.getGroupBys() != null && entityRelation.getGroupBys().size() != 0) {
                where.groupBy(entityRelation.getGroupBys());
            }
            if (entityRelation.getOrderBys() != null && entityRelation.getOrderBys().size() != 0) {
                where.orderBy(entityRelation.getOrderBys());
            }
            if (entityRelation.getLimit() != null) {
                where.limit(entityRelation.getLimit().getStart(), entityRelation.getLimit().getEnd());
            }
            return queryBuilder.getSql();



        } catch (Exception e) {
            log.error("sql builder error", e);
        }
        return null;


    }
}
