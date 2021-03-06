package Controllers.DeanRemoving;

import Model.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RemoveItemController {

    @FXML
    public Label error;
    public Label done;

    @FXML
    public TextField id;

    @FXML
    public void submit(ActionEvent e ) throws Exception {
        if(id.getText().isEmpty()){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        try{
            Integer.parseInt(id.getText());
        }catch (Exception E){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Items where itid = "+id.getText();
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        if(resultSet.next()==false){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        qury ="DELETE FROM Items where itid =" + id.getText();
        preparedStmt = con.prepareStatement(qury);
        preparedStmt.execute();
        error.setVisible(false);
        done.setVisible(true);
        return;
    }
}
