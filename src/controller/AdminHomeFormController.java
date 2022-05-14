package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminHomeFormController {
    public AnchorPane adminContext;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)adminContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RoomsManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)adminContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void mealPackageOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MealPackageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)adminContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void incomeReportsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/IncomeReportForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage)adminContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
