package Controllers.Views;

import Model.DataBaseConnection;
import Model.Person;
import Model.Stock;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StockView implements Initializable {
    @FXML
    TableView<Stock> tableStock;
    private static ObservableList<Stock> data= FXCollections.observableArrayList();
    Connection con = DataBaseConnection.getConnection();
    @FXML
    TableColumn itid,iname,qty;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data.clear();
        itid.setCellValueFactory(new PropertyValueFactory<Stock,String>("itid"));
        iname.setCellValueFactory(new PropertyValueFactory<Stock,String>("iname"));
        qty.setCellValueFactory(new PropertyValueFactory<Stock,String>("quantity"));

        Statement statement = null;
        String query ="select * from items";
        try {
            statement = con.createStatement();
            ResultSet resultSet =statement.executeQuery(query);
            while(resultSet.next()){
                Stock s=new Stock(resultSet.getString("itid"),resultSet.getString("iname"),resultSet.getString("quantity"));
                data.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableStock.setItems(data);
    }
}
