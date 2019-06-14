package ru.yandex.fixcolor.test.userdb.dao.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbPool {
    private static final String DS_NAME = "jdbc/users_db";
    private static final DbPool pool;
    static {
        try {
            pool = new DbPool();
        } catch (Exception ex) {
            throw new RuntimeException("Some errors occurred during DB initialization! Application will not work corrctly!", ex);
        }
    }
    public static DbPool getPool() {
        return pool;
    }

    private DataSource dataSource;

    private DbPool() throws NamingException {
        Context context = new InitialContext();
        Context root = (Context)context.lookup("java:/comp/env");
        dataSource = (DataSource)root.lookup(DS_NAME);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
