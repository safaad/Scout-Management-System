package Controllers.DeanUpdating;

import Model.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateframeController {

    @FXML
    public TextField id;

    @FXML
    public AnchorPane pane2;

    @FXML
    public void Seacher (ActionEvent e ) throws Exception {
        int i;
        if(id.getText().isEmpty()){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/error.fxml"));
            pane2.getChildren().setAll(pane);
            return;
        }
        try {
            i=Integer.parseInt(id.getText());
        } catch (Exception e1){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/error.fxml"));
            pane2.getChildren().setAll(pane);
            return;
        }
        if(i<1000){
            Connection con = DataBaseConnection.getConnection();
            String qury ="select * from Items where itid = "+id.getText();
            PreparedStatement preparedStmt = con.prepareStatement(qury);
            ResultSet resultSet = preparedStmt.executeQuery();
            if(resultSet.next()==false){
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/error.fxml"));
                pane2.getChildren().setAll(pane);
                return;
            }
            DataBaseConnection.setID2(id.getText());
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/UpdateIteam.fxml"));
            pane2.getChildren().setAll(pane);
            return;
        }
        if(i>=1000 && i<2000){
            DataBaseConnection.setID2(id.getText());
            Connection con = DataBaseConnection.getConnection();
            String qury ="select * from Person where pid = "+id.getText();
            PreparedStatement preparedStmt = con.prepareStatement(qury);
            ResultSet resultSet = preparedStmt.executeQuery();
            if(resultSet.next()==false){
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/error.fxml"));
                pane2.getChildren().setAll(pane);
                return;
            }
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/UpdateLeader.fxml"));
            pane2.getChildren().setAll(pane);
        }
        if(i>2000){
            Connection con = DataBaseConnection.getConnection();
            String qury ="select * from Members where mid = "+id.getText();
            PreparedStatement preparedStmt = con.prepareStatement(qury);
            ResultSet resultSet = preparedStmt.executeQuery();
            if(resultSet.next()==false){
                AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/error.fxml"));
                pane2.getChildren().setAll(pane);
                return;
            }
            DataBaseConnection.setID2(id.getText());
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanUpdate/UpdateMember.fxml"));
            pane2.getChildren().setAll(pane);
            return;
        }
    }
}
