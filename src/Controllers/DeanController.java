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

public class DeanController {

    @FXML
    AnchorPane pane;

    @FXML
    public void Add(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/DeanAdding/framAdd.fxml"));
        pane.getChildren().setAll(pane1);
    }

    @FXML
    public void Remove(ActionEvent event) throws Exception {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("../GUI/DeanRemoving/frameRemove.fxml"));
        pane.getChildren().setAll(pane2);
    }

    @FXML
    public void View(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/DeanView/DeanVeiw.fxml"));
        pane.getChildren().setAll(pane1);
    }

    @FXML
    public void Update(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/DeanUpdate/DeanUpdate.fxml"));
        pane.getChildren().setAll(pane1);
    }

    @FXML
    public void logout (ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Login.fxml"));
        Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
        S.setScene(new Scene(root));
        S.show();
    }

    public void messageClick(ActionEvent event) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/Messages.fxml"));
        pane.getChildren().setAll(pane1);
    }
        public void changePass(ActionEvent event) {
    }
}
