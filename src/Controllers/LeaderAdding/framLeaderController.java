package Controllers.LeaderAdding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class framLeaderController {

       @FXML
    AnchorPane pane;

    @FXML
    public void members (ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanAdding/AddMember.fxml"));
        pane.getChildren().setAll(pane1);
    }

    @FXML
    public void item (ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/DeanAdding/AddItem.fxml"));
        pane.getChildren().setAll(pane1);
    }
    @FXML
    public void addEvaluation(ActionEvent e)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/LeaderAdding/LeaderEvaluation.fxml"));
        Stage s =new Stage();
        s.setScene(new Scene(root));
        s.setResizable(false);
        s.show();
    }

}
