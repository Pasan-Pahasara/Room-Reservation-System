package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import model.Rooms;
import view.tm.RoomsTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class RoomsManagementFormController {
    public AnchorPane roomsManagementContext;
    public TableView<RoomsTM> tblRooms;
    public TableColumn colId;
    public TableColumn colType;
    public TableColumn colCharges;
    public TableColumn colOffers;
    public TableColumn colDelete;
    public JFXTextField txtId;
    public JFXTextField txtCharges;
    public JFXButton btnSave;
    public JFXComboBox cmbRoomTypes;
    public JFXComboBox cmbAvailableOffers;

    static ArrayList<Rooms> roomsArrayList = new ArrayList();

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colCharges.setCellValueFactory(new PropertyValueFactory("charges"));
        colType.setCellValueFactory(new PropertyValueFactory("types"));
        colOffers.setCellValueFactory(new PropertyValueFactory("offers"));
        colDelete.setCellValueFactory(new PropertyValueFactory("delete"));

        ObservableList<String>obList= FXCollections.observableArrayList();
        obList.add("Single Room");
        obList.add("Double Room");
        obList.add("Triple Room");
        obList.add("Quad Room");

        cmbRoomTypes.setItems(obList);

        ObservableList<String>obList1= FXCollections.observableArrayList();
        obList1.add("Yes");
        obList1.add("No");

        cmbAvailableOffers.setItems(obList1);

        loadAllRooms();
        tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(RoomsTM tm) {
        btnSave.setText("Update Customer");
        txtId.setText(tm.getId());
        cmbRoomTypes.setValue(tm.getTypes());
        cmbAvailableOffers.setValue(tm.getOffers());
        txtCharges.setText(tm.getCharges());

    }
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) roomsManagementContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveOnAction(ActionEvent actionEvent) {
try {
    Rooms rooms = new Rooms(txtId.getText(), cmbRoomTypes.getValue().toString(), txtCharges.getText(), cmbAvailableOffers.getValue().toString()) {
    };
    if (ifExist(rooms)) {
        if (roomsArrayList.add(rooms)) {

            loadAllRooms();
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Room Added", ButtonType.CLOSE);
            alert1.setHeaderText(null);
            alert1.showAndWait();
        } else {
            Alert alert2 = new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE);
            alert2.setHeaderText(null);
            alert2.showAndWait();
        }

    } else {
        Alert alert3 = new Alert(Alert.AlertType.WARNING, "Room Already In List", ButtonType.CLOSE);
        alert3.setHeaderText(null);
        alert3.showAndWait();
    }
}catch (NullPointerException e){}
    }
    public boolean ifExist(Rooms customer){
        for (Rooms r:roomsArrayList) {
            if(r.getId().equalsIgnoreCase(customer.getId())){
//                r.setTypes(cmbRoomTypes.getValue().toString());
//                r.setOffers(cmbAvailableOffers.getValue().toString());
//                r.getCharges(txtCharges.getText());
                return false;
            }
        }
        //Update
//        for (Customer tm: Database.customerTable){
//            if(tm.getId().equals(txtId.getText())){
//                tm.setName(txtName.getText());
//                tm.setNic(txtNic.getText());
//                tm.setContact(txtContact.getText());
//                tm.setEmail(txtEmail.getText());
//                tm.setAddress(txtAddress.getText());
//                tm.setCheckIn(txtCheckIn.getText());
//                loadAllCustomers();
//                //return;
//            }
//        }
        return true;
    }

    private void loadAllRooms() {
        ObservableList<RoomsTM> tmObservableList= FXCollections.observableArrayList();
        for (Rooms temp : roomsArrayList){
            Button btn=new Button("Delete");

            tmObservableList.add(new RoomsTM(temp.getId(), temp.getTypes(), temp.getCharges(),temp.getOffers(),btn));

            btn.setOnAction((e)->{
                ButtonType yes = new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert4 = new Alert(Alert.AlertType.CONFIRMATION,"Are you want to delete Customer ?",yes,no);
                alert4.setTitle("Confirmation Alert");
                alert4.setHeaderText(null);
                Optional<ButtonType> result = alert4.showAndWait();

                if(result.orElse(no)==yes) {
                    roomsArrayList.remove(temp);
                    loadAllRooms();
                }else{

                }
            });
        }
        tblRooms.setItems(tmObservableList);
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Customer");
    }
}
