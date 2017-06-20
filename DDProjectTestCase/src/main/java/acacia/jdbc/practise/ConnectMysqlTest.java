package acacia.jdbc.practise;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by miaomiao on 6/20/2017.
 */
public class ConnectMysqlTest {

    @Test
    public void test_1() throws SQLException, ClassNotFoundException {
        JDBCPractiseForMySQL jdbcPractiseForMySQL = new JDBCPractiseForMySQL();
        Connection connection = jdbcPractiseForMySQL.connectToMysql();
        //Create table with connection
       Statement statement = connection.createStatement();
        String sql_create_table = "CREATE TABLE TEST_1(QA_ID INT NOT NULL AUTO_INCREMENT,QA_NAME VARCHAR(100) NOT NULL,PRIMARY KEY(QA_ID))ENGINE=InnoDB DEFAULT CHARSET=UTF8;";
        int successOrNot = statement.executeUpdate(sql_create_table);
        System.out.println("Create table successful or not: " + successOrNot);
        //Insert values into table
        String sql_insert_values = "INSERT INTO TEST_1(QA_NAME) VALUES ('MiaoMiao');";
        int sucOrNot = statement.executeUpdate(sql_insert_values);
        System.out.println("Insert into table successful or not: " + sucOrNot);
        //Select all values
        String sql_select_values = "select * from test_1";
        ResultSet resultSet = statement.executeQuery(sql_select_values);
        System.out.println("Row are: " + resultSet.getRow());
//        for (int i = 0; i < resultSet.getRow(); i++) {
//            System.out.println(resultSet.getInt(i) + "\t" + resultSet.getString(i+1));
//
//        }
       System.out.println("QA_id\tQA_name");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
        }





    }
}
