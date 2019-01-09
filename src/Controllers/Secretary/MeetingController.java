package Controllers.Secretary;

import Driver.Main;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;

public class MeetingController {
    @FXML
    ListView<String> listview=new ListView<String>();

    @FXML
    Label stxt;
    @FXML
    Button sub;
    @FXML
    TextField title;
    @FXML
    DatePicker date;
    @FXML
    Label etxt;
    @FXML
    public void show (ActionEvent e ) throws Exception {

        ObservableList<String> items= FXCollections.observableArrayList();
        items.add("Dean ;"+Dean.getDean().getId()+";" + Dean.getDean().getFullname());
        for(Leaders l : Main.Leaders){
            items.add("Leader;" +l.getId()+";"+ l.getFullname());
        }
        for(Secretary s:Main.Secretary){
            items.add("Secretary ;"+s.getId()+";"+s.getFullname());
        }
        listview.setItems(items);
        listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void createMeeting(ActionEvent e) throws Exception{
        Connection con = DataBaseConnection.getConnection();
        Meeting m;
        ArrayList<Person> invitees =new ArrayList<Person>();
        ObservableList<String> selected=listview.getSelectionModel().getSelectedItems();
        Secretary sec=null;
        LocalDate value=date.getValue();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String obj,d;

        if(title.getText().isEmpty() || date.getValue()== null || selected.isEmpty() ){
            etxt.setVisible(true);
            return;
        }
        d=value.format(formatter);
        for(Secretary s:Main.Secretary){
            if(s.getId().equals(DataBaseConnection.ID)){
                sec=s;
                break;
            }
        }
        for(String line:selected){
            String[] words=line.split(";");
            boolean f1=false;
            if(Dean.getDean().getId().equals(words[1]))
                invitees.add(Dean.getDean());
            for(Leaders l:Main.Leaders){
                if(l.getId().equals(words[1])){
                    invitees.add(l);
                    f1=true;
                    break;
                }
            }
            if(!f1){
                for(Secretary s : Main.Secretary)
                    if(s.getId().equals(words[1]))
                        invitees.add(s);

            }
            f1=false;
        }
        m=new Meeting(title.getText(),d,sec);
        m.invite(invitees);
        Main.Meetings.add(m);
        String query ="insert into meeting(mdate,objective) values('"+d+"','"+title.getText()+"')";
        PreparedStatement prep=con.prepareStatement(query);
        prep.execute();
        query="select meid from meeting where mdate = "+d+" and objective = "+title.getText();
        prep=con.prepareStatement(query);
        ResultSet res=prep.executeQuery();
        String meid = res.getString("meid");
        for(String line:selected){
            String[] words=line.split(";");
            query = "insert into attendmeetings values('"+words[1]+"','"+meid+"','"+ DataBaseConnection.ID + "')";
            prep=con.prepareStatement(query);
            prep.execute();
        }
        sub.setDisable(true);
        stxt.setVisible(true);

    }

    @FXML
    public void cancel(ActionEvent e) throws Exception {
        Stage S = (Stage) ((Node) e.getSource()).getScene().getWindow();
        S.close();
    }

}
