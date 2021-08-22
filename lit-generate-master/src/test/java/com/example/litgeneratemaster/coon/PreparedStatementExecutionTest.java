package com.example.litgeneratemaster.coon;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;


class PreparedStatementExecutionTest {


    @Test
    public void testSetConstructor() throws Exception {
        Connection con = null;
        PreparedStatementExecution mysqlConnectionPool = new PreparedStatementExecution();
        mysqlConnectionPool.PerformDataInitialization();
    }

}