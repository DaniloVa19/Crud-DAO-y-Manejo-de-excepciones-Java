package com.iudigital.exceptions.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
        private static final String URL="jdbc:postgresql://localhost:5432/db_funcionario";
    private static final String USER="admin";
    private static final String PASSWORD="admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
