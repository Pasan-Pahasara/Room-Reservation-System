package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;
import view.tm.CustomerTM;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class GuestDetailsFormController {
    public AnchorPane guestDetailsContext;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colCheckIn;
    public TableColumn colDelete;

    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtCheckIn;
    public JFXButton btnSave;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory("checkIn"));
        colDelete.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllCustomers();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(CustomerTM tm) {
        btnSave.setText("Update Customer");
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtNic.setText(tm.getNic());
        txtContact.setText(tm.getContact());
        txtEmail.setText(tm.getEmail());
        txtAddress.setText(tm.getAddress());
        txtCheckIn.setText(tm.getCheckIn());

    }

    private void loadAllCustomers() {
        ObservableList<CustomerTM> obList = FXCollections.observableArrayList();

        for (Customer c : Database.customerTable
        ) {
            Button btn = new Button("Delete");
            CustomerTM tm = new CustomerTM(c.getId(), c.getName(), c.getNic(), c.getContact(), c.getEmail(), c.getAddress(), c.getCheckIn(), btn);
            obList.add(tm);

            btn.setOnAction((e) -> {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ButtonType.YES, ButtonType.NO);
                alert.setTitle("CONFIRMATION DIALOG");
                alert.setHeaderText(null);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {

                    Database.customerTable.remove(c);
                    obList.remove(tm);
                }
            });
        }
        tblCustomer.setItems(obList);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AvailabilityForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) guestDetailsContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(btnSave.getText().equals("Save Customer")){
            Customer c1 = new Customer(
                    txtId.getText(),
                    txtName.getText(),
                    txtNic.getText(),
                    txtContact.getText(),
                    txtEmail.getText(),
                    txtAddress.getText(),
                    txtCheckIn.getText()
            );
            Database.customerTable.add(c1);
            loadAllCustomers();
        }else {
            //Update
            for (Customer tm:Database.customerTable){
                if(tm.getId().equals(txtId.getText())){
                    tm.setName(txtName.getText());
                    tm.setNic(txtNic.getText());
                    tm.setContact(txtContact.getText());
                    tm.setEmail(txtEmail.getText());
                    tm.setAddress(txtAddress.getText());
                    tm.setCheckIn(txtCheckIn.getText());
                    loadAllCustomers();
                    //return;
                }
            }
        }
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
      btnSave.setText("Save Customer");
    }

    public void printTokenOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PrintTokenForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
