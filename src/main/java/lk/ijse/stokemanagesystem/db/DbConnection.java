package lk.ijse.stokemanagesystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private static Connection con;

    private DbConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://lo1calhost:3306/kade", "root", "1234");
    }

    public static DbConnection getInstance() throws SQLException {
        return (null == dbConnection) ? dbConnection = new DbConnection() : dbConnection;
    }

    public Connection getConnection(){
        return con;
    }

}
