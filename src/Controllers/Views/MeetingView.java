package Controllers.Views;

import Driver.Main;
import Model.DataBaseConnection;
import Model.DataBaseModel;
import Model.Meeting;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MeetingView implements Initializable {
    @FXML
    TableView<Meeting> tableMeeting;
    @FXML
    TableColumn obj,date;
    private static ObservableList<Meeting> data= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.clear();
        Person p = DataBaseModel.findPerson(DataBaseConnection.ID,Main.Secretary,Main.Leaders);
        obj.setCellValueFactory(new PropertyValueFactory<Meeting,String>("objective"));
        date.setCellValueFactory(new PropertyValueFactory<Person,String>("Date"));
        for(Meeting m : p.getAttendedMeetings())
            data.add(m);
        tableMeeting.setItems(data);
    }
}
