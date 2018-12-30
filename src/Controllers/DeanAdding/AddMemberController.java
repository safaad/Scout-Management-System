package Controllers.DeanAdding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddMemberController {

    @FXML TextField name;
    @FXML TextField phone;
    @FXML TextField email;
    @FXML TextField date;
    @FXML TextField id;
    @FXML Label error;
    @FXML Label added;

    @FXML
    public void submit (ActionEvent event) throws Exception {
        if(name.getText().isEmpty() || phone.getText().isEmpty() || email.getText().isEmpty() || date.getText().isEmpty() || id.getText().isEmpty()){
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
    }
}