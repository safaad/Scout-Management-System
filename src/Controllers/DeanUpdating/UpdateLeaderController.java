package Controllers.DeanUpdating;

import Model.DataBaseConnection;
import Model.Leaders;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateLeaderController {

    @FXML
    public TextField name;
    public TextField phone;
    public TextField date;
    public TextField email;

    @FXML
    public RadioButton leader;
    public RadioButton secretary;

    @FXML
    public Label error;
    public Label done;

    @FXML
    public void fill()throws Exception{
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Person where pid = "+ DataBaseConnection.getID2();
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        resultSet.next();
        name.setText(resultSet.getString("pname"));
        phone.setText(resultSet.getString("phone"));
        date.setText(resultSet.getString("birthdate"));
        email.setText(resultSet.getString("email"));
        if(resultSet.getString("type").equals("Leader")){
            leader.setSelected(true);
            secretary.setSelected(false);
        }else {
            leader.setSelected(false);
            secretary.setSelected(true);
        }
    }

    @FXML
    public void update () throws Exception {
        if(name.getText().isEmpty() || phone.getText().isEmpty() || email.getText().isEmpty() || date.getText().isEmpty()){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        String type ;
        if(leader.isSelected()){
            type="Leader";
        }else {
            type="Secretary";
        }
        Connection con = DataBaseConnection.getConnection();
        String qury ="UPDATE Person Set pname = '" + name.getText() +"' , email = '"+email.getText() +"' , phone = '"+phone.getText()+"'" +
                " , birthdate = '"+date.getText()+"' , type ='"+type+"'  where pid = " + DataBaseConnection.getID2() ;
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        preparedStmt.execute();
        error.setVisible(false);
        done.setVisible(true);
        return;

    }

}
