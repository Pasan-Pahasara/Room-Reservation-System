package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReceptionHomeFormController {
    public AnchorPane receptionContext;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)receptionContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void reserveRoomOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AvailabilityForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)receptionContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void markMaintenanceOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MaintenanceForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)receptionContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
