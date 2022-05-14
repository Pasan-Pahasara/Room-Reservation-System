package model;

public class RoomsMaintenance {
    private String id;
    private String availability;

    public RoomsMaintenance() {
    }

    public RoomsMaintenance(String id, String availability) {
        this.id = id;
        this.availability = availability;
    }

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

    @Override
    public String toString() {
        return "RoomsMaintenance{" +
                "id='" + id + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
