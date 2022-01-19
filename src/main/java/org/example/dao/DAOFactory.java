package org.example.dao;

public abstract class DAOFactory {

    public abstract StudentDAO getStudentDAO();

    public static DAOFactory getDAOFactory (DBType dbType) {
        switch (dbType) {
            case ORACLE:
                return new OracleDAOFactory();
            case MYSQL:
                return null;
            default:
                return null;
        }
    }
}
