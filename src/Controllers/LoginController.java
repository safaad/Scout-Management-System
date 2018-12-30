package Controllers;

import Model.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML public TextField username;
    @FXML public TextField password;
    @FXML public Label error;
    Connection con = DataBaseConnection.getConnection();

    @FXML
    public void Login(ActionEvent event) throws Exception {
        int i;
        if(username.getText().isEmpty() || password.getText().isEmpty()){
            error.setVisible(true);
            return;
        }
        try{
            i=Integer.parseInt(username.getText());
        }catch (Exception e){
            error.setVisible(true);
            return;
        }
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Person where pid=" + username.getText() + " AND PASS=" + password.getText());
        if(resultSet.next()==false){
            error.setVisible(true);
            return;
        }
        if(!resultSet.getString("pass").equals(password.getText())){
            error.setVisible(true);
            return;
        }
        if(i<2000){
            DataBaseConnection.username="Leader";
            DataBaseConnection.password="Leader";
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Leader.fxml"));
            Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
            S.setScene(new Scene(root));
            S.show();
        }
        else{
            DataBaseConnection.username="Member";
            DataBaseConnection.password="Member";
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/Member.fxml"));
            Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
            S.setScene(new Scene(root));
            S.show();
        }
    }

}
