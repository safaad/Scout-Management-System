package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static String username = "Dean" ;
    public static String password = "Dean" ;
    public static String ID="0";

    public static Connection getConnection () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMSdb", username, password);
            System.out.println("Connected");
            return connection;
        }catch (Exception e){
            System.out.println("No connection");
            return null;
        }
    }

}
