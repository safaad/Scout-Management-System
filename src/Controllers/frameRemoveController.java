package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class frameRemoveController {

    @FXML
    AnchorPane pane2;

    @FXML
    public void leader(ActionEvent event ) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("../GUI/DeanRemoving/RemoveLeader.fxml"));
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    public void member(ActionEvent event ) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("../GUI/DeanRemoving/RemoveMember.fxml"));
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    public void item(ActionEvent event ) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("../GUI/DeanRemoving/RemoveItem.fxml"));
        pane2.getChildren().setAll(pane1);
    }
}
