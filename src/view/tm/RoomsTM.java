package view.tm;

import javafx.scene.control.Button;

public class RoomsTM {
    private String id;
    private String types;
    private String charges;
    private String offers;
    private Button delete;

    public RoomsTM(String mealNo, String mealsTypes, String mealName, String mealTime, String mealPrice, Button btn) {
    }

    public RoomsTM(String id, String types, String charges, String offers, Button delete) {
        this.id = id;
        this.types = types;
        this.charges = charges;
        this.offers = offers;
        this.delete = delete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "RoomsTM{" +
                "id='" + id + '\'' +
                ", types='" + types + '\'' +
                ", charges='" + charges + '\'' +
                ", offers='" + offers + '\'' +
                ", delete=" + delete +
                '}';
    }
}
