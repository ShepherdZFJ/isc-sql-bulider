package com.shepherd.sqlbuilder.select.limit;

import com.shepherd.sqlbuilder.Database;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 9:52
 */
public class LimiterFactory {
    Limiter create(Database database) {
        switch (database) {
            case HSQLDB:
                return new HSQLDBLimiter();
            case ORACLE:
                return new OracleLimiter();
            default:
                return new DefaultLimiter();
        }
    }
}
