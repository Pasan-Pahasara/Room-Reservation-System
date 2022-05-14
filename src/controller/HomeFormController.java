package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {
    public AnchorPane homeContext;

    public void goToLoginPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)homeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void goToAboutPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AboutForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)homeContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
