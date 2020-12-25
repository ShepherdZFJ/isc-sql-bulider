package com.shepherd.sqlbuilder;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 11:33
 */
@Data
@Builder
public class ConditionDTO {
    private String name;
    private String compareType;
    private List<ConditionDTO> conditionList;
    private List<String> parameters;
    private Object value;
}
