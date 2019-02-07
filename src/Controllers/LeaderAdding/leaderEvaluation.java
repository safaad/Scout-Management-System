package Controllers.LeaderAdding;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Leaders;
import Model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class leaderEvaluation implements Initializable {
    private static ObservableList<Member> data= FXCollections.observableArrayList();
    Connection con = DataBaseConnection.getConnection();
    private static String lid=DataBaseConnection.ID;
    @FXML
    TableView<Member> tableEv;
    @FXML
    Label stxt,mtxt;
    @FXML
    Button sub;
    @FXML
    TableColumn<Member, Rating> evalCol;
    @FXML
    TableColumn<Member, String> midCol;
    @FXML
    TableColumn<Member, String> memCol;
    @FXML
    public void fillEvaluation(ActionEvent e)throws Exception{
        PreparedStatement statement ;
        ObservableList<Member> rowsData = FXCollections.observableArrayList(tableEv.getItems());
        for(Member m : rowsData){
            String mid=m.getId();
            int evaluation= (int) m.getRating().getRating();
            Main.findMember(mid).setEvaluation(evaluation);
            String query="UPDATE members set evaluation = "+evaluation+" WHERE mid = '"+mid+"'";
            statement=con.prepareStatement(query);
            statement.execute();
        }
        stxt.setVisible(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableEv.getItems().clear();
        tableEv.getColumns().clear();
        Leaders leader= Main.findLeader(lid);
        midCol.setCellValueFactory(new PropertyValueFactory<Member,String>("id"));
        memCol.setCellValueFactory(new PropertyValueFactory<Member,String>("fullname"));
        evalCol.setCellValueFactory(new PropertyValueFactory<Member, Rating>("rating"));
        data.clear();
        for(Member m :leader.getMemberList()){
            data.add(m);
        }
        tableEv.getColumns().addAll(midCol,memCol, evalCol);
        tableEv.setItems(data);

    }
}
