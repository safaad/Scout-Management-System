package Controllers;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Message;
import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MessageController implements Initializable {
    @FXML
    ListView msglistview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person p= Main.findPerson(DataBaseConnection.ID);
        ArrayList<Message> messages=p.getInbox();
        ObservableList<String> items= FXCollections.observableArrayList();
        msglistview.getSelectionModel().clearSelection();
        for(Message m:messages)
            items.add(m.toString());

        msglistview.setItems(items);
    }
}
