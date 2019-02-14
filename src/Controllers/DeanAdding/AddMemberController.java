package Controllers.DeanAdding;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddMemberController {

    Connection con = DataBaseConnection.getConnection();

    @FXML TextField name;
    @FXML TextField phone;
    @FXML TextField email;
    @FXML TextField date;
    @FXML TextField id;
    @FXML TextField rank;
    @FXML Label error;
    @FXML Label added;

    @FXML
    public void submit (ActionEvent event) throws Exception {
        if(name.getText().isEmpty() || phone.getText().isEmpty() || email.getText().isEmpty() || date.getText().isEmpty() ||
                id.getText().isEmpty() || rank.getText().isEmpty()){
            error.setVisible(true);
            added.setVisible(false);
            return;
        }
        try {
            Integer.parseInt(phone.getText());
        }catch (Exception e){
            error.setVisible(true);
            added.setVisible(false);
            return;
        }
        if(date.getText().charAt(4) != '-' || date.getText().charAt(7) != '-' || date.getText().length() != 10 ){
            error.setVisible(true);
            added.setVisible(false);
            return;
        }
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Person where pid=" + id.getText());
        if(resultSet.next()==false){
            error.setVisible(true);
            added.setVisible(false);
            return;
        }
        String query = " insert into members (mname, birthdate, email ,phone , lid,Members.rank , evaluation ) values ('"+name.getText()+"','"+date.getText()+"','"+phone.getText()+"','"+email.getText()+"','" +
                " "+id.getText() +"','"+ rank.getText() +"','0')";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.execute();
        error.setVisible(false);
        added.setVisible(true);
        Main.Members.add(new Member(email.getText(),name.getText(),date.getText(),"1234",phone.getText(),rank.getText(),null,null,Main.Members.get(Main.Members.size()-1).getId()+1));
        name.clear();
        email.clear();
        date.clear();
        rank.clear();
        phone.clear();
        id.clear();
    }


}