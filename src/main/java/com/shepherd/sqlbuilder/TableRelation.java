package com.shepherd.sqlbuilder;

import lombok.Builder;
import lombok.Data;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 10:58
 */
@Data
@Builder
public class TableRelation {
    private String centerTable;
    private String linkTable;
    private Integer joinType;
    private String compareType;
    private String centerColumn;
    private String linkColumn;
}
