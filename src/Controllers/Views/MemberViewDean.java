package Controllers.Views;

import Driver.Main;
import Model.Leaders;
import Model.Person;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import Model.Member;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberViewDean implements Initializable {
    @FXML
    TableView<Member> tableMemb;
    private static ObservableList<Member> data= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn pid=new TableColumn("Id");
        TableColumn name=new TableColumn("Name");
        TableColumn email=new TableColumn("Email");
        TableColumn phone=new TableColumn("Phone");
        TableColumn lid=new TableColumn("Leader ID");
        TableColumn rank=new TableColumn("Rank");
        TableColumn evaluation=new TableColumn("Evaluation");
        TableColumn birthdate=new TableColumn("BirthDate");
        lid.setCellValueFactory(new PropertyValueFactory<Member,String>("lid"));
        rank.setCellValueFactory(new PropertyValueFactory<Member,String>("rank"));
        evaluation.setCellValueFactory(new PropertyValueFactory<Member,String>("evaluation"));
        pid.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Person,String>("fullname"));
        email.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));
        birthdate.setCellValueFactory(new PropertyValueFactory<Person,String>("birthdate"));
        for(Leaders l : Main.Leaders)
            for(Member m:l.getMemberList())
                data.add(m);
        tableMemb.setItems(data);
        tableMemb.getColumns().addAll(lid,pid,name,email,birthdate,phone,rank,evaluation);

    }
}
