package Controllers.LeaderAdding;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Leaders;
import Model.Member;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Connection;
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
//    @FXML
//    TableColumn evalCol,midCol,memCol;
    @FXML
    TableColumn<Member, String> evalCol, midCol, memCol;
    @FXML
    public void fillEvaluation(ActionEvent e)throws Exception{

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableEv.getItems().clear();
        tableEv.getColumns().clear();
        Leaders leader= Main.findLeader(lid);
        ObservableList<String> items = FXCollections.observableArrayList("1","2","3","4","5");
        midCol.setCellValueFactory(new PropertyValueFactory<Member,String>("id"));
        memCol.setCellValueFactory(new PropertyValueFactory<Member,String>("fullname"));
        evalCol.setCellValueFactory(new PropertyValueFactory<>("evaluation"));
        evalCol.setEditable(true);
        midCol.setEditable(true);
        midCol.setCellFactory(TextFieldTableCell.forTableColumn());
        evalCol.setCellFactory(ComboBoxTableCell.forTableColumn(items));
        evalCol.setOnEditCommit(event -> {
            final String newValue = event.getNewValue() != null ? event.getNewValue() : event.getOldValue();
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setEvaluation(newValue);
        });
        for(Member m :leader.getMemberList()){
            data.add(m);
        }
        tableEv.setItems(data);
        //tableEv.getColumns().addAll(midCol,memCol,evalCol);
    }
}
