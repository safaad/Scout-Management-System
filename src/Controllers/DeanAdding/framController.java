package Controllers.DeanAdding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;


public class framController {

    @FXML
    AnchorPane pane2;

    @FXML
    public void AddLeader(ActionEvent event ) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanAdding/AddLeader.fxml"));
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    public void AddMember(ActionEvent event ) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanAdding/AddMember.fxml"));
        pane2.getChildren().setAll(pane1);
    }

    @FXML
    public void AddItem(ActionEvent event ) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanAdding/AddItem.fxml"));
        pane2.getChildren().setAll(pane1);
    }
}
