package com.shepherd.sqlbuilder;

import lombok.Builder;
import lombok.Data;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/22 17:10
 */
@Builder
@Data
public class Column {
    private String name;
    private String table;
    private String aliasName;
}
