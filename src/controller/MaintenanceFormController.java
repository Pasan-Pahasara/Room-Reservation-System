package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import model.RoomsMaintenance;
import view.tm.RoomsMaintenanceTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MaintenanceFormController {
    public AnchorPane maintenanceContext;
    public TableView tblRooms;
    public TableColumn colRoomNo;
    public TableColumn colAvailability;
    public TableColumn colButton;
    public JFXTextField txtRoomNo;
    public JFXTextField txtAvailability;

    public static ArrayList<RoomsMaintenance> roomList = new ArrayList();
    public JFXComboBox cmbAvailability;

    public void initialize(){
        colRoomNo.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colButton.setCellValueFactory(new PropertyValueFactory<>("available"));

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        obList1.add("Yes");
        obList1.add("No");

        cmbAvailability.setItems(obList1);

        loadAllRooms();
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ReceptionHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)maintenanceContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)maintenanceContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void saveOnAction(ActionEvent actionEvent) {
        RoomsMaintenance room = new RoomsMaintenance(txtRoomNo.getText(), cmbAvailability.getValue().toString());
        if (ifExist(room)) {
            //if (roomList.add(room)) {
            roomList.add(room);
                loadAllRooms();
                Alert alert1=new Alert(Alert.AlertType.CONFIRMATION, "Done", ButtonType.FINISH);
                alert1.setHeaderText(null);
                alert1.showAndWait();
            /*} else {
                Alert alert2=new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.CLOSE);
                alert2.setHeaderText(null);
                alert2.showAndWait();
            }*/
        }else{
            Alert alert3=new Alert(Alert.AlertType.WARNING,"Already In Maintenance",ButtonType.OK);
            alert3.setHeaderText(null);
            alert3.showAndWait();
        }
    }

    private boolean ifExist(RoomsMaintenance room) {
        for (RoomsMaintenance r:roomList) {
            if (r.getId().equalsIgnoreCase(room.getId())){
                return false;
            }
        }
        return true;
    }

    private void loadAllRooms() {
        ObservableList<RoomsMaintenanceTM> tmObservableList= FXCollections.observableArrayList();
        for (RoomsMaintenance r:roomList) {
            Button available = new Button("Make Available");
            tmObservableList.add(
                    new RoomsMaintenanceTM(r.getId(),r.getAvailability(),available)
            );
            available.setOnAction((e)->{
                roomList.remove(r);
                loadAllRooms();
            });
        }
        tblRooms.setItems(tmObservableList);
    }

    public void refreshOnAction(ActionEvent actionEvent) {

    }
}
