package com.shepherd.sqlbuilder.select;

import com.shepherd.sqlbuilder.MemoryDatabase;
import org.junit.After;
import org.junit.Before;

import java.sql.Connection;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/23 10:19
 */
public class SelectTest {

    private Connection connection;

    @Before
    public void startConnection() throws Exception {
        connection = new MemoryDatabase().getConnection();
        connection
                .createStatement()
                .executeQuery("SET DATABASE SQL SYNTAX ORA FALSE");
    }

    @After
    public void closeConnection() throws Exception {
        connection.createStatement().execute("SHUTDOWN");

        if (!connection.isClosed()) {
            connection.close();
        }
    }


}