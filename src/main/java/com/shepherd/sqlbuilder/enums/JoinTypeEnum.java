package com.shepherd.sqlbuilder.enums;


import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/24 13:54
 */
@Getter
public enum  JoinTypeEnum {

    LEFT_JOIN(0, "LEFT JOIN"),
    RIGHT_JOIN(1, "RIGHT JOIN"),
    INNER_JOIN(2, "INNER JOIN"),
    FULL_JOIN(3, "FULL JOIN");


    private Integer code;

    private String name;


    JoinTypeEnum(Integer code, String name ) {
        this.code = code;
        this.name = name;
    }

    public static JoinTypeEnum getType(Integer code) {
        return Stream.of(JoinTypeEnum.values()).filter(bean -> bean.getCode().equals(code)).findFirst().orElse(null);
    }
}
