package Controllers.Views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Views {
    @FXML
    AnchorPane dpane,lpane;


    @FXML
    public void dviewMeeting(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/MeetingView.fxml"));
        dpane.getChildren().setAll(pane1);
    }

    public void dviewStock(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/StockView.fxml"));
        dpane.getChildren().setAll(pane1);

    }

    public void viewLeaders(javafx.event.ActionEvent event) throws IOException {

        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/LeaderView.fxml"));
        dpane.getChildren().setAll(pane1);
    }

    public void viewMembersDean(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/memberViewDean.fxml"));
        dpane.getChildren().setAll(pane1);

    }

    public void viewStock(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/StockView.fxml"));
        lpane.getChildren().setAll(pane1);

    }

    public void viewMembersLeader(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/LeaderView/memberViewLeader.fxml"));
        lpane.getChildren().setAll(pane1);

    }

    public void viewMeeting(javafx.event.ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/MeetingView.fxml"));
        lpane.getChildren().setAll(pane1);

    }
}
