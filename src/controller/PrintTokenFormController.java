package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;

public class PrintTokenFormController {
    public AnchorPane tokenContext;
    public Label label1;
    public Label label2;
    public Label label11;

    public void sendMailOnAction(ActionEvent actionEvent) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Are you want to Mail Send?", ButtonType.YES, ButtonType.NO);
        alert1.setHeaderText(null);
        alert1.showAndWait();
    }

    public void generateIdOnAction(ActionEvent actionEvent) {
        Random r = new Random();
        label1.setText(String.valueOf(r.nextInt(200)));
    }

    public void printTokenOnAction(ActionEvent actionEvent) {
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Are you want to Token Print?", ButtonType.YES, ButtonType.NO);
        alert2.setHeaderText(null);
        alert2.showAndWait();
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/GuestDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) tokenContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
