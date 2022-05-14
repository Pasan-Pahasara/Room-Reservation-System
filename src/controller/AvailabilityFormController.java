package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import db.IncomeDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.RoomsMaintenance;
import view.tm.AvailabilityTM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class AvailabilityFormController extends MaintenanceFormController {
    public AnchorPane availabilityContext;
    public TableView tblAvailability;
    public TableColumn colId;
    public TableColumn colAvailable;
    public JFXComboBox<String> cmbRoom;
    public JFXComboBox cmbMealPackage;
    public JFXComboBox cmbMealName;
    public Text label2;
    public Text label3;
    public Label roomCost;
    public Label mealPackageCost;
    public Label fullCost;
    public JFXDatePicker d2;
    public JFXDatePicker d1;
    public JFXButton btnRefresh;
    public JFXButton btnBooking;


    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory("roomNumber"));
        colAvailable.setCellValueFactory(new PropertyValueFactory("roomAvailability"));


        btnRefresh.setDisable(true);
        btnBooking.setDisable(true);

        cmbMealPackage.getItems().addAll("Local Meals", "Chinese Meals", "French Meals");
        cmbMealPackage.getSelectionModel().select(0);

        ObservableList<String> obList2 = FXCollections.observableArrayList();
        obList2.add("Single Room");
        obList2.add("Double Room");
        obList2.add("Triple Room");
        obList2.add("Quad Room");

        cmbRoom.setItems(obList2);

        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm ");
                    Calendar cal = Calendar.getInstance();

                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);

                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        label2.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", minute) + " " + state);
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        label3.setText(formatter.format(date));

        loadAllAvailability();
    }

    private void loadAllAvailability() {
        ObservableList ob = FXCollections.observableArrayList();
        for (RoomsMaintenance r : MaintenanceFormController.roomList) {
            AvailabilityTM tm = new AvailabilityTM(r.getId(), r.getAvailability());
            ob.add(tm);
        }
        tblAvailability.setItems(ob);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ReceptionHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) availabilityContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void bookingOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/GuestDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) availabilityContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void paymentNowOnAction(ActionEvent actionEvent) {
        LocalDate date2 = d2.getValue();
        for (int i = 0; i < IncomeDb.monthIncome.size(); i++) {
            try {
                if ((i + 1) == date2.getMonthValue()) {
                    double earlyIncome = IncomeDb.monthIncome.get(i).getIncome();
                    IncomeDb.monthIncome.get(i).setIncome(Math.abs(earlyIncome + Double.parseDouble(fullCost.getText())));
                }
            } catch (NullPointerException e) {

            }
        }
    }

    public void paymentAfterOnAction(ActionEvent actionEvent) {

    }

    private void enableRefreshButton() {
        try {
            if (!cmbRoom.getValue().equals("") && !d1.getValue().toString().equals("") && !d2.getValue().toString().equals("")) {
                btnRefresh.setDisable(false);
            }
        } catch (NullPointerException e) {
        }
    }

    private void enableBookingButton() {
        try {
            if (!cmbRoom.getValue().equals("") && !d1.getValue().toString().equals("") && !d2.getValue().toString().equals("")) {
                btnBooking.setDisable(false);
            }
        } catch (NullPointerException e) {
        }
    }

    public void refresh(ActionEvent actionEvent) {
        addRooms();
        addMeals();

        LocalDate date1 = LocalDate.now();
        LocalDate date2 = d2.getValue();

        int range = date2.getDayOfMonth() - date1.getDayOfMonth();

        double rc1 = Double.parseDouble(roomCost.getText());
        double mp1 = Double.parseDouble(mealPackageCost.getText());
        double cost = ((rc1 + mp1) * range);
        String str = String.valueOf(cost);
        fullCost.setText(str);
        date1.getMonthValue();
        date1.getYear();
        date1.getMonth();

        enableBookingButton();
    }

    private void addMeals() {
        if (cmbMealPackage.getValue().toString().equals("Local Meals")) {
            cmbMealName.getItems().addAll("Pizza", "Kottu", "Chicken Rice");
            cmbMealName.getSelectionModel().select(0);
            if (cmbMealName.getValue().equals("Pizza")) {
                mealPackageCost.setText("999.00");
            }
            if (cmbMealName.getValue().equals("Kottu")) {
                mealPackageCost.setText("500.00");
            } else if (cmbMealName.getValue().equals("Chicken Rice")) {
                mealPackageCost.setText("680.00");
            }
        } else if (cmbMealPackage.getValue().toString().equals("Chinese Meals")) {
            cmbMealName.getItems().addAll("Spring Rolls", "Dumplings", "Wonton");
            cmbMealName.getSelectionModel().select(0);
            if (cmbMealName.getValue().equals("Spring Rolls")) {
                mealPackageCost.setText("1000.00");
            } else if (cmbMealName.getValue().equals("Dumplings")) {
                mealPackageCost.setText("850.00");
            } else if (cmbMealName.getValue().equals("Wonton")) {
                mealPackageCost.setText("550.00");
            }
        } else if (cmbMealPackage.getValue().toString().equals("French Meals")) {
            cmbMealName.getItems().addAll("Burger", "Shawarma", "Prawns");
            cmbMealName.getSelectionModel().select(0);
            if (cmbMealName.getValue().equals("Burger")) {
                mealPackageCost.setText("390.00");
            } else if (cmbMealName.getValue().equals("Shawarma")) {
                mealPackageCost.setText("999.00");
            } else if (cmbMealName.getValue().equals("Prawns")) {
                mealPackageCost.setText("690.00");
            }
        }
    }

    public void addRooms() {
        if (cmbRoom.getValue().equals("Single Room")) {
            roomCost.setText("3000.00");
        }
        if (cmbRoom.getValue().equals("Double Room")) {
            roomCost.setText("5000.00");
        }
        if (cmbRoom.getValue().equals("Triple Room")) {
            roomCost.setText("9000.00");
        }
        if (cmbRoom.getValue().equals("Quad Room")) {
            roomCost.setText("25000.00");
        }

    }

    public void mealNameClick(MouseEvent mouseEvent) {
        cmbMealName.getItems().clear();
        addMeals();
    }

    public void selectMealPackOnAction(ActionEvent actionEvent) {
        cmbMealPackage.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                cmbMealName.getItems().clear();
                addMeals();
            }
        });
    }

    public void roomTypeOnAction(ActionEvent actionEvent) {
        cmbRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                addRooms();
            }
        });

        enableRefreshButton();
    }

    public void d1SelectOnAction(ActionEvent actionEvent) {
        enableRefreshButton();
    }

    public void d2SelectOnAction(ActionEvent actionEvent) {
        enableRefreshButton();
    }
}
