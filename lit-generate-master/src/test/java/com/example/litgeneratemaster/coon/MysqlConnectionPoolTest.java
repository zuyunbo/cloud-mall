package com.example.litgeneratemaster.coon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

class MysqlConnectionPoolTest {


    @Test
    public void testSetConstructor() throws Exception {
        Connection con = null;
        MysqlConnectionPool mysqlConnectionPool = new MysqlConnectionPool();
        mysqlConnectionPool.setProperties();
        ConnectionPool connectionPool = mysqlConnectionPool.dataSource();
        con = connectionPool.getConnection();
        System.out.println(con);
    }


}