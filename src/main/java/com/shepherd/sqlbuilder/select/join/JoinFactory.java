package com.shepherd.sqlbuilder.select.join;

import com.shepherd.sqlbuilder.enums.JoinTypeEnum;
import com.shepherd.sqlbuilder.select.limit.DefaultLimiter;
import com.shepherd.sqlbuilder.select.limit.LimiterOracle;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/24 16:03
 */
public class JoinFactory {

    Joiner create(JoinTypeEnum joinTypeEnum) {
        switch (joinTypeEnum) {
            case LEFT_JOIN:
                return new LeftJoin();
            case RIGHT_JOIN:
                return new RightJoin();
            case INNER_JOIN:
                return new InnerJoin();
            case FULL_JOIN:
                return null;
            default:
                return null;

        }

    }
}
