package Controllers.Secretary;

import Driver.Main;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MeetingController implements Initializable {
    @FXML
    ListView<String> listview;

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
    public void refresh() throws Exception {
        sub.setDisable(false);
        date.getEditor().clear();
        title.clear();
        stxt.setVisible(false);
        stxt.setVisible(false);
        ObservableList<String> items= FXCollections.observableArrayList();
        listview.getSelectionModel().clearSelection();
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
        d=""+value.getYear()+"-"+value.getMonthValue()+"-"+value.getDayOfMonth();
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
        sub.setDisable(true);
        m=new Meeting(title.getText(),d,sec);
        String subject="Meeting on : ||"+d+"||\n with Objective: ||"+title.getText().toString()+"||";
        m.invite(invitees,subject);
        Main.Meetings.add(m);
        String query ="insert into meeting(mdate,objective) values('"+d+"','"+title.getText()+"')";
        PreparedStatement prep=con.prepareStatement(query);
        prep.execute();
        for(Person p:invitees){
            String query2="insert into messages(pid,msgFrom,msgTo,Subject) values("+p.getId()+",'"+p.getEmail()+"','"+sec.getEmail()+"','"+subject+"')";
            PreparedStatement prep2=con.prepareStatement(query2);
            prep2.execute();
        }
        query="select * from meeting where mdate= '"+d+"' and objective ='"+title.getText().toString()+"'";
        Statement prep1=con.createStatement();
        ResultSet res=prep1.executeQuery(query);
        res.next();
        String meid = res.getString(1);
        for(String line:selected){
            String[] words=line.split(";");
            query = "insert into attendmeetings values('"+words[1]+"','"+meid+"','"+ DataBaseConnection.ID + "')";
            prep=con.prepareStatement(query);
            prep.execute();
        }

        stxt.setVisible(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
