package com.shepherd.sqlbuilder;

import com.shepherd.sqlbuilder.builder.SqlBuilder;
import com.shepherd.sqlbuilder.enums.DatabaseTypeEnum;
import com.shepherd.sqlbuilder.enums.JoinTypeEnum;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/22 16:38
 */
@Data
public class Context {
    private static final String NEW_LINE = System.getProperty("line.separator");

    private static final String SPACE = " ";

    private  StringBuilder sql;

    private  DatabaseTypeEnum databaseTypeEnum;

    private JoinTypeEnum joinTypeEnum;

    private final Logger log = LoggerFactory.getLogger(SqlBuilder.class);



    public Context() {
        this.sql = new StringBuilder();
    }

    public Context(DatabaseTypeEnum databaseTypeEnum) {
        this.databaseTypeEnum = databaseTypeEnum;
        this.sql = new StringBuilder();
    }



    public String sql() {
        return sql.toString();
    }


    public Context append(String expression) {
        sql.append(expression);
        return this;
    }

    public Context appendLine(String expression) {
        sql.append(NEW_LINE);
        sql.append(expression);
        sql.append(SPACE);
        return this;
    }

    public Context appendSpace(String expression) {
        sql.append(expression);
        sql.append(SPACE);
        return this;
    }


}
