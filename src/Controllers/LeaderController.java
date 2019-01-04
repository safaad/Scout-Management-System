package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

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
}
