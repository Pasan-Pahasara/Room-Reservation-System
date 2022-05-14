package view.tm;

import javafx.scene.control.Button;

public class RoomsMaintenanceTM {
    private String id;
    private String availability;

    public RoomsMaintenanceTM() {
    }

    public RoomsMaintenanceTM(String id, String availability, Button available) {
        this.id = id;
        this.availability = availability;
        this.available = available;
    }

    private Button available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Button getAvailable() {
        return available;
    }

    public void setAvailable(Button available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "RoomsMaintenanceTM{" +
                "id='" + id + '\'' +
                ", availability='" + availability + '\'' +
                ", available=" + available +
                '}';
    }
}
