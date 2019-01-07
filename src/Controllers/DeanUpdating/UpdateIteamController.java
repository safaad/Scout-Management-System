package Controllers.DeanUpdating;

import Model.DataBaseConnection;
import Model.Dean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UpdateIteamController {

    @FXML
    public TextField name ;
    public TextField nb;

    @FXML
    public Label error;
    public Label done;


    @FXML
    public void fill() throws Exception{
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Items where itid = "+ DataBaseConnection.getID2();
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        resultSet.next();
        name.setText(resultSet.getString("iname"));
        nb.setText(resultSet.getString("quantity"));
        return;
    }

    @FXML
    public void Update() throws Exception {
        if(name.getText().isEmpty() || nb.getText().isEmpty()){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        try {
            Integer.parseInt(nb.getText());
        }catch (Exception e){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        Connection con = DataBaseConnection.getConnection();
        String qury ="UPDATE items Set iname = '" + name.getText() +"' , quantity = "+nb.getText() +" where itid = " + DataBaseConnection.getID2() ;
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        preparedStmt.execute();
        error.setVisible(false);
        done.setVisible(true);
        return;
    }
}
