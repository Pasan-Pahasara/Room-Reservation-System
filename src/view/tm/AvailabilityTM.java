package view.tm;


public class AvailabilityTM {
    private String roomNumber;
    private String roomAvailability;

    public AvailabilityTM() {
    }

    public AvailabilityTM(String roomNumber, String roomAvailability) {
        this.roomNumber = roomNumber;
        this.roomAvailability = roomAvailability;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    @Override
    public String toString() {
        return "AvailabilityTM{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomAvailability='" + roomAvailability + '\'' +
                '}';
    }
}
