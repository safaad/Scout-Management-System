package Controllers.Views;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Leaders;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Model.Member;
import javafx.stage.Stage;


public class MemberView {

    @FXML
    public AnchorPane frame;

    @FXML
    public Label good;
    public Label bad;
    public Label excel;
    @FXML
     Label name;
    @FXML
     Label email;
    public Label ranks;

    @FXML
    public ImageView bronze;
    public ImageView silver;
    public ImageView gold;

    @FXML
    public void viewRankPane(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/MemberView/rankView.fxml"));
        frame.getChildren().setAll(pane1);
        String mid = DataBaseConnection.ID;
        Member m = Main.findMember(mid);
        String s = (m.getRank());
        ranks=(Label) pane1.getChildren().get(1);
        ranks.setText(s);
    }

    @FXML
    public void viewLeaderPane(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/MemberView/leaderMember.fxml"));
        frame.getChildren().setAll(pane1);
        String mid = DataBaseConnection.ID;
        Member m = Main.findMember(mid);
        Leaders l = m.getLeader();
        name = (Label) pane1.getChildren().get(2);
        email = (Label) pane1.getChildren().get(1);
        name.setText(l.getFullname());
        email.setText(l.getEmail());
    }

    @FXML
    public void viewEvalPane(ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/MemberView/evalView.fxml"));
        frame.getChildren().setAll(pane1);
        String mid = DataBaseConnection.ID;
        Member m = Main.findMember(mid);
        String evaluation = m.getEvaluation();
        if (evaluation.equals("0") || evaluation.equals("1") || evaluation.equals("2")) {
            bronze=(ImageView)pane1.getChildren().get(2);
            bronze.setVisible(true);
            bad=(Label)pane1.getChildren().get(3);
            bad.setVisible(true);
        }else if (evaluation.equals("3") || evaluation.equals("4")) {
            good=(Label)pane1.getChildren().get(5);
            silver=(ImageView)pane1.getChildren().get(4);
            good.setVisible(true);
            silver.setVisible(true);
        }else {
            excel=(Label)pane1.getChildren().get(1);
            gold=(ImageView)pane1.getChildren().get(0);
            excel.setVisible(true);
            gold.setVisible(true);
        }
    }

    @FXML
    public void logout (ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../GUI/Login.fxml"));
        Stage S = (Stage) ((Node) event.getSource()).getScene().getWindow();
        S.setScene(new Scene(root));
        S.show();
    }

}


