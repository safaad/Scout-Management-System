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
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../GUI/fram.fxml"));
        pane.getChildren().add(pane1);
    }
}
