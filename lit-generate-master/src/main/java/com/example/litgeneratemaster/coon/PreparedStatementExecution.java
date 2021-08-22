package com.example.litgeneratemaster.coon;

import com.example.litgeneratemaster.domain.ColumnData;
import com.example.litgeneratemaster.exception.SqlExecutionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementExecution implements ConnectionPool {

    private Connection connection;
    private static final String SQL = "select  column_name, column_comment, data_type from information_schema.columns where table_schema ='cloud_code1'  and table_name = 'c_user'";
    private static final Log log = LogFactory.getLog(AbstractConnection.class);

    private AbstractConnection abstractConnection = new AbstractConnection() {
        @Override
        void setProperties() {
            super.setProperties();
        }
    };

    @Override
    public Connection getConnection() throws SQLException {
        try {
            abstractConnection.setProperties();
            connection = abstractConnection.dataSource().getConnection();
            return connection;
        } catch (SQLException throwables) {
            log.info(String.format("Failed to connect ====> :  %s ", connection));
        }
        return null;
    }

    public List<ColumnData> PerformDataInitialization() throws SqlExecutionException {
        try {
            this.connection = this.getConnection();
        } catch (SQLException throwables) {
            log.info(String.format("Failed to connect ====> :  %s ", connection));
            throw new SqlExecutionException(String.format("Char match error: expect %s got %s\n",
                    throwables, throwables.getMessage()));
        }

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL);

            List<ColumnData> entityList = new ArrayList<>();


            while (resultSet.next()) {
                if ("id".equals(resultSet.getObject("column_name").toString())) {
                    continue;
                }
                // 初始化数据库字段
                Object commentObj = resultSet.getObject("column_comment");
                entityList.add(ColumnData.builder()
                        .columnName(resultSet.getObject("column_name").toString())
                        .columnType(commentObj != null ? commentObj.toString() : "")
                        .columnType(resultSet.getObject("data_type")
                                .toString()).build());
            }
            return entityList;
        } catch (SQLException throwables) {
            log.info(String.format("Failed to execute statement ====> :  %s ", connection));
        }

        return null;
    }


}
