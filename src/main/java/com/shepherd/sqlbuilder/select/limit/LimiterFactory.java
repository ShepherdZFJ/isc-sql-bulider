package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.enums.DatabaseTypeEnum;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:52
 */
public class LimiterFactory {
    Limiter create(DatabaseTypeEnum databaseTypeEnum) {
        switch (databaseTypeEnum) {
            case MYSQL:
                return new LimiterMySQL();
            case ORACLE:
                return new LimiterOracle();
            default:
                return new DefaultLimiter();
        }
    }
}
