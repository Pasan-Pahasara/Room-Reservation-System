package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReceptionistLoginFormController {
    public JFXPasswordField txtPassword;
    public JFXTextField txtName;
    public Label label;
    public AnchorPane login2Context;
    public Text label2;

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginHomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) login2Context.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void logInButtonOnAction(ActionEvent actionEvent) throws IOException {
        if (txtPassword.getText().equals("1111") & txtName.getText().equalsIgnoreCase("Pasan")) {

                label.setText("Login Success");
                URL resource = getClass().getResource("../view/ReceptionHomeForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Stage window = (Stage) login2Context.getScene().getWindow();
                window.setScene(new Scene(load));
        } else {
            label.setText("Enter correct username or password");
        }
    }
    //-------------------------------------------RealTimeClock----------------------------------------------------------
    public void initialize() {
        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    //System.out.println(hour + ":" + (minute) + ":" + second);
                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        label2.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + " " + state);
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
    }
}
