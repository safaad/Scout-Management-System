package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static String username = "Dean" ;
    public static String password = "Dean" ;
    public static String ID="1000";
    private static String ID2=null;

    public static String getID2() {
        return ID2;
    }

    public static void setID2(String ID2) {
        DataBaseConnection.ID2 = ID2;
    }

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
