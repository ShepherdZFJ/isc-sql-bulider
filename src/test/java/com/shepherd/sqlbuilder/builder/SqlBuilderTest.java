package com.shepherd.sqlbuilder.builder;

import com.shepherd.sqlbuilder.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 14:43
 */
public class SqlBuilderTest {
    private EntityRelation entityRelation;

    @Before
    public void hand() {
        entityRelation = new EntityRelation();
        List<Column> columns = new ArrayList<>();
        Column column = new Column();
        column.setName("name");
        column.setTable("atlas");
        column.setAliasName("atlasName");
        columns.add(column);
        Column column1 = new Column();
        column1.setName("name");
        column1.setTable("atlas_element");
        column1.setAliasName("atlasElementName");
        columns.add(column1);
        Column column2 = new Column();
        column2.setName("name");
        column2.setTable("project");
        column2.setAliasName("projectName");
        columns.add(column2);
        Column column3 = new Column();
        column3.setName("name");
        column3.setTable("material");
        column3.setAliasName("materialName");
        columns.add(column3);
        entityRelation.setColumns(columns);
        Table table = new Table();
        List<String> tableNames = new ArrayList<>();
        tableNames.add("atlas");
        tableNames.add("atlas_url");
        table.setNames(tableNames);
        List<TableRelation> tableRelations = new ArrayList<>();
        TableRelation tableRelation = new TableRelation();
        tableRelation.setCenterTable("atlas");
        tableRelation.setLinkTable("atlas_element");
        tableRelation.setJoinType(1);
        tableRelation.setCenterColumn("atlas.id");
        tableRelation.setLinkColumn("atlas_element.atlas_id");
        tableRelation.setCompareType("==");
        tableRelations.add(tableRelation);

        TableRelation tableRelation1 = new TableRelation();
        tableRelation1.setCenterTable("atlas");
        tableRelation1.setLinkTable("project");
        tableRelation1.setJoinType(1);
        tableRelation1.setCenterColumn("atlas.project_id");
        tableRelation1.setLinkColumn("project.id");
        tableRelation1.setCompareType("==");
        tableRelations.add(tableRelation1);

        TableRelation tableRelation2 = new TableRelation();
        tableRelation2.setCenterTable("atlas_element");
        tableRelation2.setLinkTable("material");
        tableRelation2.setJoinType(1);
        tableRelation2.setCenterColumn("atlas_element.material_id");
        tableRelation2.setLinkColumn("material.id");
        tableRelation2.setCompareType("==");
        tableRelations.add(tableRelation2);
        table.setTableRelations(tableRelations);
        entityRelation.setTable(table);

        entityRelation.setFilter("atlas.id>2000");
        List<String> orderBy = new ArrayList<>();
        orderBy.add("atlas.id desc");
        orderBy.add("atlas_element.id asc");
        entityRelation.setOrderBys(orderBy);

        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setStart(1);
        limitDTO.setEnd(2000);
    }

    @Test
    public void getSql() {
        String sql = SqlBuilder.getSql(entityRelation);
        System.out.println(sql);
    }
}