package Controllers.DeanAdding;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Leaders;
import Model.Secretary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddLeaderController {

    Connection con = DataBaseConnection.getConnection();

    @FXML TextField name;
    @FXML TextField phone;
    @FXML TextField email;
    @FXML TextField date;
    @FXML RadioButton dean;
    @FXML RadioButton leader;
    @FXML RadioButton secretary;
    @FXML Label error;
    @FXML Label success;

    @FXML
    public void submit(ActionEvent event) throws Exception {
        String type="";
        if(name.getText().isEmpty() || phone.getText().isEmpty() || email.getText().isEmpty() || date.getText().isEmpty() ||
                (!dean.isSelected() && !leader.isSelected() && !secretary.isSelected())){
            error.setVisible(true);
            success.setVisible(false);
            return;
        }
        try {
            Integer.parseInt(phone.getText());
        }catch (Exception e){
            error.setVisible(true);
            success.setVisible(false);
            System.out.println("1");
            return;
        }
        if(date.getText().charAt(4) != '-' || date.getText().charAt(7) != '-' || date.getText().length() != 10 ){
            error.setVisible(true);
            success.setVisible(false);
            System.out.println("2");
            return;
        }
        if(leader.isSelected()){
            type="Leader";
        }else
            type="Secretary";
        String query = " insert into Person (pname, birthdate, phone, email,deanid ,type) values ('"+name.getText()+"','"+date.getText()+"','"+phone.getText()+"','"+email.getText()+"','" +
                " "+DataBaseConnection.ID +"','"+ type +"')";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.execute();
        error.setVisible(false);
        success.setVisible(true);
        if(type.equals("Leader"))
            Main.Leaders.add(new Leaders(email.getText(),name.getText(),date.getText(),"1234",phone.getText(),Main.Leaders.get(Main.Leaders.size()-1).getId()+1,DataBaseConnection.ID));
        else
            Main.Secretary.add(new Secretary(email.getText(),name.getText(),date.getText(),"1234",phone.getText(),Main.Secretary.get(Main.Secretary.size()-1).getId(),DataBaseConnection.ID));
        name.clear();
        date.clear();
        phone.clear();
        email.clear();
    }

}
