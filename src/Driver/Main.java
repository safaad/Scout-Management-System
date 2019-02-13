package Driver;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Member> Members = new ArrayList<Member>();
    public static ArrayList<Leaders> Leaders = new ArrayList<Leaders>();
    public static ArrayList<Secretary> Secretary = new ArrayList<Secretary>();
    public static ArrayList<Item> Item = new ArrayList<Item>();
    public static ArrayList<Meeting> Meetings=new ArrayList<Meeting>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
        primaryStage.setTitle("Scout Management System");
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            DataBaseModel.Fill(Members, Leaders, Item, Meetings , Secretary);
            for(Meeting m:Meetings)
                System.out.println(m.getMeid());
        }catch (Exception e){
            System.out.println("Error while reading from the database");
        }
        launch(args);
    }

}
