package Controllers.DeanRemoving;

import Driver.Main;
import Model.DataBaseConnection;
import Model.Dean;
import Model.Leaders;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RemoveLeaderController {

    @FXML
    public RadioButton yes;
    public RadioButton no;
    public TextField id;

    @FXML
    public Label error;
    public Label done ;


    @FXML
    public void Submit(ActionEvent e) throws Exception {
        if(id.getText().isEmpty()){
            done.setVisible(false);
            error.setVisible(true);
            return;
        }
        Connection con = DataBaseConnection.getConnection();
        String qury ="select * from Person where pid = "+ id.getText();
        PreparedStatement preparedStmt = con.prepareStatement(qury);
        ResultSet resultSet = preparedStmt.executeQuery();
        if(resultSet.next()==false){
            done.setVisible(false);
            error.setVisible(true);
            return;
        }

        qury ="DELETE FROM Person where pid = " + id.getText();
        preparedStmt = con.prepareStatement(qury);
        preparedStmt.execute();

        for(int i=0;i<Main.Leaders.size();i++){
            if(Main.Leaders.get(i).getId().equals(id.getText())){
                Main.Leaders.remove(i);
                break;
            }
        }

        if(yes.isSelected()==true){
            qury ="DELETE FROM Members where lid = " + id.getText();
            preparedStmt = con.prepareStatement(qury);
            preparedStmt.execute();
            for(int i=0;i< Main.Members.size() ; i++){
                if(Main.Members.get(i).getLeader().getId().equals(id.getText())){
                    Main.Members.remove(i);
                }
            }
            done.setVisible(true);
            error.setVisible(false);
            return;
        }
        else {
            qury ="UPDATE FROM Members Set lid = " + Dean.getDean().getId() +" where lid = " + id.getText() ;
            preparedStmt = con.prepareStatement(qury);
            preparedStmt.execute();
            for(int i=0;i< Main.Members.size() ; i++){
                if(Main.Members.get(i).getLeader().getId().equals(id.getText())){
                    Main.Members.get(i).setLeader(Dean.getDean());
                }
            }
            done.setVisible(true);
            error.setVisible(false);
            return;
        }
    }


}
