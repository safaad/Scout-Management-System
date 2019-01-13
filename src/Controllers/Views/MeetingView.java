package Controllers.Views;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Meeting;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MeetingView implements Initializable {
    @FXML
    TableView<Meeting> tableMeeting;
    private static ObservableList<Meeting> data= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person p = Main.findPerson(DataBaseConnection.ID);
        TableColumn meid,obj,date;
        meid=new TableColumn("Meeting Id");
        meid.setCellValueFactory(new PropertyValueFactory<Meeting,String>("meid"));
        obj=new TableColumn("Objective");
        obj.setCellValueFactory(new PropertyValueFactory<Meeting,String>("objective"));
        date=new TableColumn("Meeting Date");
        date.setCellValueFactory(new PropertyValueFactory<Person,String>("Date"));
        for(Meeting m : p.getAttendedMeetings())
            data.add(m);
        tableMeeting.setItems(data);
        tableMeeting.getColumns().addAll(meid,obj,date);
    }
}
