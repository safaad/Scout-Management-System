package Controllers;

import Model.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class changepass {

    Connection con = DataBaseConnection.getConnection();

    @FXML public TextField b1;
    @FXML public PasswordField b2;
    @FXML public PasswordField b3;
    @FXML public Label t1;

    @FXML
    public void submit(ActionEvent event) throws Exception{
        if(b1.getText().isEmpty() || b2.getText().isEmpty() || b3.getText().isEmpty()){
            t1.setVisible(true);
            return;
        }
        if(!b2.getText().equals(b3.getText())){
            t1.setVisible(true);
            return;
        }
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Person where pid="+DataBaseConnection.ID);
        resultSet.next();
        if( resultSet.getString("pass").equals(b1.getText())){
            String query = " update Person set pass ="+b2.getText()+"  where pid="+DataBaseConnection.ID;
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
            Stage S =(Stage)((Node) event.getSource()).getScene().getWindow();
            S.close();
        }else{
            t1.setVisible(true);
            return;
        }
    }

}
