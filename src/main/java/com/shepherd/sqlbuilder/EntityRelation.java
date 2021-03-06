package com.shepherd.sqlbuilder;

import com.shepherd.sqlbuilder.Column;
import lombok.Data;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/22 17:09
 */
@Data
public class EntityRelation {
    private DataSource dataSource;
    private List<Column> columns;
    private Table table;
    private String filter;
    private List<ConditionDTO> conditions;
    private List<String> groupBys;
    private List<String> orderBys;
    private LimitDTO limit;

}
