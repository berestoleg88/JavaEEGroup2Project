package org.example.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

public class OracleDAOFactory extends DAOFactory {
   //public static final String DRIVER = "oracle.jdbc.OracleDriver";
   //public static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    @Override
    public StudentDAO getStudentDAO() {
        return new OracleStudentDAO();
    }

    public static Connection createConnection() {

        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        hashtable.put(Context.PROVIDER_URL, "t3://localhost:7001");
        Context context = null;
        Connection connection = null;
        try {
            context = new InitialContext(hashtable);
            DataSource dataSource = (DataSource) context.lookup("DataSourceGroup2");
            //Class.forName(DRIVER);
            //connection = DriverManager.getConnection(DB_URL, "oleh", "parolyaNet0");
            connection = dataSource.getConnection();
            if (!connection.isClosed()) {
                System.out.println("Connected successfully!");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
