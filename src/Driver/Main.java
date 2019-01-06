package Driver;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Member> Members = new ArrayList<>();
    public static ArrayList<Person> Leaders = new ArrayList<>();
    public static ArrayList<Item> Item = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Dean.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            Fill(Members, Leaders, Item);
        }catch (Exception e){
            System.out.println("Error while reading from the database");
        }
        launch(args);
    }

    public static void Fill (ArrayList<Member> Member, ArrayList<Person> Leader ,ArrayList<Item> Item) throws Exception{
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Person where deanid = pid";
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            String email = resultSet.getString("email");
            String name = resultSet.getString("pname");
            String phone = resultSet.getString("phone");
            String birthdate = resultSet.getString("birthdate");
            String pid = resultSet.getString("pid");
            String pass = resultSet.getString("pass");
            Dean.getDean(email,name,birthdate,pass,phone,pid);
        }

        qury ="select * from Person where deanid <> pid";
        preparedStmt = con.prepareStatement(qury);
        resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            String email = resultSet.getString("email");
            String name = resultSet.getString("pname");
            String phone = resultSet.getString("phone");
            String birthdate = resultSet.getString("birthdate");
            String pid = resultSet.getString("pid");
            String pass = resultSet.getString("pass");
            String deanid = resultSet.getString("deanid");
            String type = resultSet.getString("type");
            Leaders.add(PersonFactory.getPerson(Dean.getDean(),type,email, name,birthdate,pass, phone, pid));
        }
        Dean.getDean().setLeaderList(Leaders);


        while(resultSet.next()){
            String email = resultSet.getString("email");
            String name = resultSet.getString("mname");
            String phone = resultSet.getString("phone");
            String rank = resultSet.getString("rank");
            String birthdate = resultSet.getString("birthdate");
            String mid = resultSet.getString("mid");
            String pass = resultSet.getString("pass");
            String evaluation = resultSet.getString("evaluation");

        }

    }
}
