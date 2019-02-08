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
    public void viewMeeting(ActionEvent event){

    }
    public void messageClick(ActionEvent event) {
    }

    public void changePass(ActionEvent event) {
    }
}
