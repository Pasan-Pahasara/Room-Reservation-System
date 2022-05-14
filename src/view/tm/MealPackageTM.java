package view.tm;

import javafx.scene.control.Button;

public class MealPackageTM {
    private String no;
    private String types;
    private String name;
    private String time;
    private String price;
    private Button delete;

    public MealPackageTM() {
    }

    public MealPackageTM(String no, String types, String name, String time, String price, Button delete) {
        this.no = no;
        this.types = types;
        this.name = name;
        this.time = time;
        this.price = price;
        this.delete = delete;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "MealPackageTM{" +
                "no='" + no + '\'' +
                ", types='" + types + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                ", delete=" + delete +
                '}';
    }
}
