package controller;

import com.jfoenix.controls.JFXComboBox;
import db.IncomeDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.tm.IncomeTM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IncomeReportFormController {
    public AnchorPane incomeReportContext;
    public TableView<IncomeTM> tblIncome;
    public TableColumn colMonth;
    public TableColumn colMonthIncome;
    public TableColumn colYear;
    public TableColumn colYearIncome;
    public JFXComboBox cmbMonth;
    public JFXComboBox cmbYear;
    public Text label2;
    public Text label3;

    public void initialize() {
        ObservableList <String> obList1 = FXCollections.observableArrayList();
        obList1.add("January");
        cmbMonth.getSelectionModel().select(0);

        cmbMonth.setItems(obList1);

        ObservableList<String> obList2 = FXCollections.observableArrayList();
        obList2.add("2021");
        cmbYear.getSelectionModel().select(0);

        cmbYear.setItems(obList2);

        loadAllIncome();

        //////////////////////////////////////////////////////////////////////////////////////////////////////
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
        colMonth.setCellValueFactory(new PropertyValueFactory("month"));
        colMonthIncome.setCellValueFactory(new PropertyValueFactory("income"));
        Date date = new Date();
        label3.setText(formatter.format(date));
        loadAllIncome();
    }

    private void loadAllIncome() {
        ObservableList observableList= FXCollections.observableArrayList();
        for (IncomeTM tm: IncomeDb.monthIncome) {
            observableList.add(tm);
        }
        tblIncome.setItems(observableList);
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) incomeReportContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void refreshOnAction(ActionEvent actionEvent) {
        loadAllIncome();
    }
}
