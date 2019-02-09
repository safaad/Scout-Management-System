package Controllers.Views;

import Driver.Main;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberViewLeader implements Initializable {
    @FXML
    TableView<Member> tableMemb;
    private static ObservableList<Member> data= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Leaders l = DataBaseModel.findLeader(DataBaseConnection.ID , Main.Leaders);
        TableColumn pid=new TableColumn("Id");
        TableColumn name=new TableColumn("Name");
        TableColumn email=new TableColumn("Email");
        TableColumn phone=new TableColumn("Phone");

        TableColumn rank=new TableColumn("Rank");
        TableColumn evaluation=new TableColumn("Evaluation");
        TableColumn birthdate=new TableColumn("BirthDate");

        rank.setCellValueFactory(new PropertyValueFactory<Member,String>("rank"));
        evaluation.setCellValueFactory(new PropertyValueFactory<Member,String>("evaluation"));
        pid.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Person,String>("fullname"));
        email.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));
        birthdate.setCellValueFactory(new PropertyValueFactory<Person,String>("birthdate"));
            for(Member m:l.getMemberList())
                data.add(m);
        tableMemb.setItems(data);
        tableMemb.getColumns().addAll(pid,name,email,birthdate,phone,rank,evaluation);

    }
}
