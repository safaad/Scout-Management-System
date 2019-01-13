package Controllers.Views;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Leaders;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Model.Member;

public class MemberView {
    @FXML
    AnchorPane frame;
    @FXML
    Label good,bad,excel,name,email,rank;
    @FXML
    ImageView bronze,silver,gold;
    @FXML
    public void viewRankPane(javafx.event.ActionEvent event) throws Exception{
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/MemberView/rankView.fxml"));
        frame.getChildren().setAll(pane1);
        String mid=DataBaseConnection.ID;
        Member m = Main.findMember(mid);
        rank.setText(m.getRank());
    }

    public void viewLeaderPane(javafx.event.ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/MemberView/leaderMember.fxml"));
        frame.getChildren().setAll(pane1);
        String mid=DataBaseConnection.ID;
        Member m = Main.findMember(mid);
        Leaders l=m.getLeader();
        name.setText(l.getFullname());
        email.setText(l.getEmail());
    }

    public void viewEvalPane(javafx.event.ActionEvent event) throws Exception {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("../../GUI/MemberView/evalView.fxml"));
        frame.getChildren().setAll(pane1);
        String mid= DataBaseConnection.ID;
        Member m= Main.findMember(mid);
        String evaluation=m.getEvaluation();
        if(evaluation.equals("0")||evaluation.equals("1")||evaluation.equals("2")){
            bronze.setVisible(true);
            bad.setVisible(true);
        }
        if(evaluation.equals("3")||evaluation.equals("4")) {
            silver.setVisible(true);
            good.setVisible(true);
        }
        else{
            excel.setVisible(true);
            gold.setVisible(true);
        }
        }

    }


