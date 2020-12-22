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
    private List<Column> columns;
}
