package com.shepherd.sqlbuilder;

import lombok.Data;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 11:33
 */
@Data
public class ConditionDTO {
    private String name;
    private String type;
    private List<String> parameters;
}
