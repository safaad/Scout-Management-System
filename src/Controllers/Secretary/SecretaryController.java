package Controllers.Secretary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class SecretaryController {

    @FXML
    public void openCreation(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/Meeting/meeting.fxml"));
        Stage s =new Stage();
        s.setScene(new Scene(root));
        s.setResizable(false);
        s.show();

    }
    @FXML
    public void seeEvaluation(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/DeanView/memberViewDean.fxml"));
        Stage s =new Stage();
        s.setScene(new Scene(root));
        s.setResizable(false);
        s.show();
    }

    @FXML
    public void logout (ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/Login.fxml"));
        Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
        S.setScene(new Scene(root));
        S.show();
    }
}
