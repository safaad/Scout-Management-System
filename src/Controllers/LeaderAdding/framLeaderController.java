package Controllers.LeaderAdding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class framLeaderController {

    @FXML
    AnchorPane pane;

    @FXML
    public void members (ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/LeaderAdding/AddMemberLeader.fxml"));
        pane.getChildren().setAll(pane1);
    }

    @FXML
    public void item (ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/LeaderAdding/AddItemLeader.fxml"));
        pane.getChildren().setAll(pane1);
    }

}
