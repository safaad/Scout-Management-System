package Controllers.DeanUpdating;

import Model.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UpdateMemberController {

    @FXML
    public TextField name;
    public TextField phone;
    public TextField date;
    public TextField email;
    public TextField id;
    public TextField rank;

    @FXML
    public Label error;
    public Label done;

    @FXML
    public void fill () throws Exception{
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Members where mid = "+ DataBaseConnection.getID2();
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        resultSet.next();
        name.setText(resultSet.getString("mname"));
        phone.setText(resultSet.getString("phone"));
        date.setText(resultSet.getString("birthdate"));
        email.setText(resultSet.getString("email"));
        id.setText(resultSet.getString("lid"));
        rank.setText(resultSet.getString("rank"));
    }

    @FXML
    public void submit() throws Exception{
        if(name.getText().isEmpty() || phone.getText().isEmpty() || date.getText().isEmpty() || email.getText().isEmpty() || id.getText().isEmpty()
        || rank.getText().isEmpty()){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        try {
            Integer.parseInt(phone.getText());
            Integer.parseInt(id.getText());
        }catch (Exception e){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        Connection con = DataBaseConnection.getConnection();
        String qury ="UPDATE Members Set mname = '" + name.getText() +"' , phone = "+phone.getText() +" , birthdate = '"+date.getText()+"' ," +
                "email = '"+email.getText()+"' , lid = "+id.getText()+" , rank = '"+ rank.getText() +"' where mid = " + DataBaseConnection.getID2() ;
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        preparedStmt.execute();
        error.setVisible(false);
        done.setVisible(true);
        return;
    }
}
