package com.shepherd.sqlbuilder.builder;

import com.google.common.collect.ImmutableList;
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
        DataSource dataSource = new DataSource();
        dataSource.setIp("10.30.30.25");
        dataSource.setPort("23306");
        dataSource.setDatabaseName("isc_ias");
        dataSource.setUserName("root");
        dataSource.setPassword("123456");
        dataSource.setType(0);
        entityRelation.setDataSource(dataSource);
        List<Column> columns = ImmutableList.of(
                Column.builder().name("name").table("atlas").aliasName("atlasName").build(),
                Column.builder().name("name").table("atlas_element").aliasName("atlasElementName").build(),
                Column.builder().name("name").table("project").aliasName("projectName").build(),
                Column.builder().name("name").table("material").aliasName("materialName").build()
                );

        entityRelation.setColumns(columns);
        Table table = new Table();
        List<String> tableNames = ImmutableList.of("atlas", "atlas_url");
        table.setNames(tableNames);
        List<TableRelation> tableRelations = ImmutableList.of(
                TableRelation.builder().centerTable("atlas").linkTable("atlas_element").joinType(0).
                        centerColumn("atlas.id").linkColumn("atlas_element.atlas_id").compareType("==").build(),
                TableRelation.builder().centerTable("atlas").linkTable("project").joinType(0).centerColumn("atlas.project_id").
                        linkColumn("project.id").compareType("==").build(),
                TableRelation.builder().centerTable("atlas_element").linkTable("material").joinType(0).
                        centerColumn("atlas_element.material_id").linkColumn("material.id").compareType("==").build()
        );
        table.setTableRelations(tableRelations);
        entityRelation.setTable(table);

        entityRelation.setFilter("atlas.id>2000");
        List<String> orderBy = new ArrayList<>();
        orderBy.add("atlas.id desc");
        orderBy.add("atlas_element.id asc");
        entityRelation.setOrderBys(orderBy);

        LimitDTO limitDTO = new LimitDTO();
        limitDTO.setStart(1);
        limitDTO.setSize(2000);
        entityRelation.setLimit(limitDTO);
    }

    @Test
    public void getSql() {
        String sql = SqlHolder.getSql(entityRelation);
        System.out.println(sql);
    }
}