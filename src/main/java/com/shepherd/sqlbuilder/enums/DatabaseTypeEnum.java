package com.shepherd.sqlbuilder.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/24 11:26
 */
@Getter
public enum DatabaseTypeEnum {

    MYSQL(0, "MySQL", "com.mysql.jdbc.Driver", "jdbc:mysql://%s:%s?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&useSSL=false"),//,
    ORACLE(1, "ORACLE", "oracle.jdbc.OracleDriver", "jdbc:oracle:thin:@//%s:%s/%s"),
    CLICKHOUSE(2, "CLICKHOUSE", "ru.yandex.clickhouse.ClickHouseDriver", "jdbc:clickhouse://%s:%s?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&useSSL=false");

    private Integer code;

    private String name;

    /**
     * 驱动类
     */
    private String driverClass;
    /**
     * 连接地址
     */
    private String url;


    DatabaseTypeEnum(Integer code, String name, String driverClass, String url) {
        this.code = code;
        this.name = name;
        this.driverClass = driverClass;
        this.url = url;
    }

    public static DatabaseTypeEnum getType(Integer code) {
        return Stream.of(DatabaseTypeEnum.values()).filter(bean -> bean.getCode().equals(code)).findFirst().orElse(null);
    }
}
