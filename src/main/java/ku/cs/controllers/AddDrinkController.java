package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ku.cs.models.Menu;
import ku.cs.models.MenuList;
import ku.cs.models.User;
import ku.cs.models.UserList;
import ku.cs.servicesDB.Database;
import ku.cs.servicesDB.Menu_DBConnection;
import ku.cs.servicesDB.User_DBConnect;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddDrinkController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextArea descField;

    @FXML
    private Button noSweetBtn;

    @FXML
    private Button lessSweetBtn;

    @FXML
    private Button extraSweetBtn;

    public Menu menu = new Menu("0","0",0f,"0","0","normal","drink") ;

    MenuList menuList;

    Database<Menu, MenuList> database;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    @FXML
    public void initialize() {
        clearTextField();
        database = new Menu_DBConnection();
        menuList = new MenuList();
        String query = "SELECT * FROM menu";
        menuList = database.readDatabase(query);
    }

    @FXML
    private void handleNoSweetnessBtn(ActionEvent event) throws IOException {
        menu.setMn_option("no");
        noSweetBtn.setStyle("-fx-background-color: #632f15");
        lessSweetBtn.setStyle("-fx-background-color: #b68e78");
        extraSweetBtn.setStyle("-fx-background-color: #b68e78");
    }

    @FXML
    private void handleLessSweetnessBtn(ActionEvent event) throws IOException {
        menu.setMn_option("less");
        lessSweetBtn.setStyle("-fx-background-color: #632f15");
        noSweetBtn.setStyle("-fx-background-color: #b68e78");
        extraSweetBtn.setStyle("-fx-background-color: #b68e78");
    }

    @FXML
    private void handleExtraSweetnessBtn(ActionEvent event) throws IOException {
        menu.setMn_option("extra");
        extraSweetBtn.setStyle("-fx-background-color: #632f15");
        lessSweetBtn.setStyle("-fx-background-color: #b68e78");
        noSweetBtn.setStyle("-fx-background-color: #b68e78");
    }

    @FXML
    private void handleFreshMilkBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void handleAlmondMilkBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void handleOatMilkBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void handleBackBtn(ActionEvent event) throws IOException {

    }

    @FXML
    private void handleAddBtn(ActionEvent event) throws IOException {
        String nameStr = nameField.getText();
        String priceStr = priceField.getText();
        String descStr = descField.getText();

        menu.setMn_name(nameStr);
        menu.setMn_price(Float.valueOf(priceStr));
        menu.setMn_img("test");
        menu.setM_type("drink");
        menu.setMn_status("sell");

        if (nameField.equals("") || priceField.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("กรุณากรอกข้อมูลให้ครบถ้วน");

            alert.showAndWait();

        } else {
            menu.setMn_Id(menuList);
            database.insertDatabase(menu);
            System.out.println(menu.getMn_Id() + "," + menu.getMn_name() + "," + menu.getMn_option());
        }
    }

    private void clearTextField() {
        nameField.setText("");
        priceField.setText("");
        descField.setText("");
    }
}
