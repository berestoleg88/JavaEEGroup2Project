package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDAOFactory extends DAOFactory {
   public static final String DRIVER = "oracle.jdbc.OracleDriver";
   public static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    @Override
    public StudentDAO getStudentDAO() {
        return new OracleStudentDAO();
    }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, "oleh", "parolyaNet0");
            if (!connection.isClosed()) {
                System.out.println("Connected successfully!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
