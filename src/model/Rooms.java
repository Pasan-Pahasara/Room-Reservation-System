package model;

public class Rooms {
    private String id;
    private String types;
    private String charges;
    private String offers;

    public Rooms(String text, String txtMealPriceText, String txtMealNameText, String s, String toString) {
    }

    public Rooms(String id, String types, String charges, String offers) {
        this.id = id;
        this.types = types;
        this.charges = charges;
        this.offers = offers;
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

    @Override
    public String toString() {
        return "Rooms{" +
                "id='" + id + '\'' +
                ", types='" + types + '\'' +
                ", charges='" + charges + '\'' +
                ", offers='" + offers + '\'' +
                '}';
    }
}
