package Controllers.Views;

import Driver.Main;
import Model.Leaders;
import Model.Member;
import Model.Person;
import Model.Secretary;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderView implements Initializable {
    @FXML
    TableView<Person> tableLeader;
    private static ObservableList<Person> data= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableLeader.getItems().clear();
        tableLeader.getColumns().clear();
        TableColumn pid=new TableColumn("Id");
        TableColumn name=new TableColumn("Name");
        TableColumn email=new TableColumn("Email");
        TableColumn phone=new TableColumn("Phone");
        TableColumn birthdate=new TableColumn("BirthDate");
        pid.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Person,String>("fullname"));
        email.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));
        birthdate.setCellValueFactory(new PropertyValueFactory<Person,String>("birthdate"));
        for(Leaders l : Main.Leaders)
            data.add(l);
        for(Secretary s: Main.Secretary)
            data.add(s);
        tableLeader.setItems(data);
        tableLeader.getColumns().addAll(pid,name,email,phone,birthdate);
    }
}
