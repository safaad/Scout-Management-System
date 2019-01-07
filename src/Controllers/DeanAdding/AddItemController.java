package Controllers.DeanAdding;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AddItemController {

    @FXML
    public TextField name;
    public TextField nb;

    @FXML
    public Label error;
    public Label done;

    @FXML
    public void submit (ActionEvent e) throws Exception {
        if(name.getText().isEmpty() || nb.getText().isEmpty()){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        try {
            Integer.parseInt(nb.getText());
        }catch (Exception E){
            error.setVisible(true);
            done.setVisible(false);
            return;
        }
        Connection con = DataBaseConnection.getConnection();
        String query ="insert into Items (iname,quantity) values ('"+name.getText()+"' , "+ nb.getText() +")";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.execute();

        query ="select * from Items where iname = '"+ name.getText() +"' AND quantity = "+ nb.getText();
        preparedStmt = con.prepareStatement(query);
        ResultSet resultSet = preparedStmt.executeQuery();
        resultSet.next();

        Main.Item.add(new Item(resultSet.getString("itid"),name.getText(),nb.getText()));
        error.setVisible(false);
        done.setVisible(true);

    }
}
