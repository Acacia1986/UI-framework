package acacia.jdbc.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by miaomiao on 6/20/2017.
 */
public class JDBCPractiseForMySQL {

    //Connection to local mysql
    public Connection connectToMysql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/acaciatest?user=root&password=99999");
        System.out.println("Connection to mysql successful!");
        return  connection;
    }





}
