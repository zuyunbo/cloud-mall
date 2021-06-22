package com.example.litgeneratemaster.coon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractConnection {

    private static final Log log = LogFactory.getLog(AbstractConnection.class);

    protected ConnectionPool dataSource;

    void setProperties() {
        InputStream resourceAsStream = MysqlConnectionPool.class.getClassLoader().getResourceAsStream(
                "application.yml");
        Properties prop = new Properties();
        try {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource = new MysqlConnectionPool(prop, prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
    }


    public ConnectionPool dataSource() {
        return dataSource;
    }
}
