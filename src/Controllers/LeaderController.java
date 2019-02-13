package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderController {

    @FXML
    public AnchorPane LeaderPane;

    @FXML
    public void add(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/LeaderAdding/frameAddLeader.fxml"));
        LeaderPane.getChildren().setAll(pane1);
    }

    @FXML
    public void remove(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/LeaderRemoving/frameRemove.fxml"));
        LeaderPane.getChildren().setAll(pane1);
    }

    @FXML
    public void update(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/LeaderUpdate/LeaderUpdate.fxml"));
        LeaderPane.getChildren().setAll(pane1);
    }

    @FXML
    public void view(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/LeaderView/LeaderView.fxml"));
        LeaderPane.getChildren().setAll(pane1);
    }

    @FXML
    public void logout (ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
        Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
        S.setScene(new Scene(root));
        S.show();
    }

    @FXML
    public void messageClick(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/Messages.fxml"));
        LeaderPane.getChildren().setAll(pane1);
    }

    @FXML
    public void changePass(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/changepass.fxml"));
        Stage S = new Stage();
        S.setScene(new Scene(root));
        S.show();
    }
}
