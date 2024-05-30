
package com.contactodc.gestcontact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Goita
 */
public class DatabaseUtil {
    //attributs
    private static final String URL = "jdbc:mysql://localhost:3306/gestContactDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
//charge la classe du pilote JDBC
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
//connection à la db elle retourne une instance de connection, Drivermanager
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
