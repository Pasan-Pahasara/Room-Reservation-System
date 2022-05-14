package controller;

import com.jfoenix.controls.JFXButton;
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
import model.MealPackage;
import view.tm.MealPackageTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class MealPackageFormController {
    static ArrayList<MealPackage> mealsArrayList = new ArrayList();
    public AnchorPane mealPackageContext;
    public JFXComboBox cmbMealsType;
    public JFXComboBox cmbMealTime;
    public JFXTextField txtNo;
    public JFXButton btnSave;
    public JFXTextField txtName;
    public JFXTextField txtPrice;
    public TableView <MealPackageTM>tblMealPackages;
    public TableColumn colNo;
    public TableColumn colType;
    public TableColumn colName;
    public TableColumn colTime;
    public TableColumn colPrice;
    public TableColumn colDelete;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mealPackageContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void newOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Meal");
    }

    public void initialize() {
        colNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        colType.setCellValueFactory(new PropertyValueFactory<>("types"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        ObservableList<String>obList1= FXCollections.observableArrayList();
        obList1.add("Local Meals");
        obList1.add("Chinese Meals");
        obList1.add("French Meals");

        cmbMealsType.setItems(obList1);

        ObservableList<String>obList2= FXCollections.observableArrayList();
        obList2.add("Breakfast");
        obList2.add("Lunch");
        obList2.add("Dinner");

        cmbMealTime.setItems(obList2);


        loadAllMealPackage();
        tblMealPackages.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(MealPackageTM tm) {
        btnSave.setText("Update Meal");
        txtNo.setText(tm.getNo());
        cmbMealsType.setValue(tm.getTypes());
        txtName.setText(tm.getName());
        cmbMealTime.setValue(tm.getTime());
        txtPrice.setText(tm.getPrice());
    }

    private void loadAllMealPackage() {
        ObservableList<MealPackageTM> obList= FXCollections.observableArrayList();
        for (MealPackage temp : mealsArrayList){
            Button btn=new Button("Delete");

            obList.add(new MealPackageTM(temp.getNo(), temp.getTypes(), temp.getName(),temp.getTime(),temp.getPrice(),btn));

            btn.setOnAction((e)->{
                ButtonType yes = new ButtonType("Yes",ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert4 = new Alert(Alert.AlertType.CONFIRMATION,"Are you want to delete Customer ?",yes,no);
                alert4.setTitle("Confirmation Alert");
                alert4.setHeaderText(null);
                Optional<ButtonType> result = alert4.showAndWait();

                if(result.orElse(no)==yes) {
                    mealsArrayList.remove(temp);
                    loadAllMealPackage();
                }else{

                }
            });
        }
        tblMealPackages.setItems(obList);
    }

    public void saveOnAction(ActionEvent actionEvent) {
        try {
            MealPackage meals = new MealPackage(txtNo.getText(), cmbMealsType.getValue().toString(), txtName.getText(), cmbMealTime.getValue().toString(), txtPrice.getText()) {
            };
            if (ifExist(meals)) {
                if (mealsArrayList.add(meals)) {

                    loadAllMealPackage();
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
    public boolean ifExist(MealPackage customer){
        for (MealPackage r:mealsArrayList) {
            if(r.getNo().equalsIgnoreCase(customer.getNo())){
                return false;
            }
        }
        return true;
    }
}


