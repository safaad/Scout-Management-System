package Controllers.Secretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SecretaryController {
    @FXML
    Pane secPane;
    @FXML
    public void openCreation(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/Meeting/meeting.fxml"));
        secPane.getChildren().setAll(pane);
    }
    @FXML
    public void seeEvaluation(ActionEvent event) throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/memberViewDean.fxml"));
        secPane.getChildren().setAll(pane);
    }

    @FXML
    public void logout (ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/Login.fxml"));
        Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
        S.setScene(new Scene(root));
        S.show();
    }

    @FXML
    public void viewMeeting(ActionEvent event) throws Exception{
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/MeetingView.fxml"));
        secPane.getChildren().setAll(pane1);
    }
    @FXML
    public void messageClick(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/Messages.fxml"));
        secPane.getChildren().setAll(pane1);

    }
        public void changePass(ActionEvent event) {
    }
}
