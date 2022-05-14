package model;

public class MealPackage {
    private String no;
    private String types;
    private String name;
    private String time;
    private String price;

    public MealPackage() {
    }

    public MealPackage(String no, String types, String name, String time, String price) {
        this.no = no;
        this.types = types;
        this.name = name;
        this.time = time;
        this.price = price;
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

    @Override
    public String toString() {
        return "MealPackage{" +
                "no='" + no + '\'' +
                ", types='" + types + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
