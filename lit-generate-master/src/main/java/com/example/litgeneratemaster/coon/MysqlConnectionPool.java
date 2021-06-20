package com.example.litgeneratemaster.coon;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * mysql 连接池
 * 2021
 */
public class MysqlConnectionPool extends AbstractConnection implements ConnectionPool {

    private Properties driverProperties;
    private String url;
    private String username;
    private String password;
    public Connection conn = null;


    public MysqlConnectionPool() {
    }

    public MysqlConnectionPool(Properties driverProperties, String url, String username, String password) {
        this.driverProperties = driverProperties;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.doGetConnection(this.username, this.password);
    }

    private Connection doGetConnection(String username, String password) throws SQLException {
        Properties props = new Properties();
        if (this.driverProperties != null) {
            props.putAll(this.driverProperties);
        }

        if (username != null) {
            props.setProperty("user", username);
        }

        if (password != null) {
            props.setProperty("password", password);
        }

        return this.doGetConnection(props);
    }

    private Connection doGetConnection(Properties properties) throws SQLException {
        return conn = DriverManager.getConnection(this.url, properties);
    }


}
