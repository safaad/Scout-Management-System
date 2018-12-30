package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

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

}
