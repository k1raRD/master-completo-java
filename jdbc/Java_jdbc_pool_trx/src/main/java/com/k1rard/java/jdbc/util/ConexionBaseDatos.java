package com.k1rard.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static final String URL = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin";
    private static BasicDataSource pool;

    public static BasicDataSource getPool() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASSWORD);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getPool().getConnection();
    }
}
