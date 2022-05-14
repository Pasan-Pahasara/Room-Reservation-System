package model;

public class Customer {
    private String id;
    private String name;
    private String nic;
    private String contact;
    private String email;
    private String address;
    private String checkIn;/*CTRL+SHIFT+ALT+T*/

    /*ALT+INSERT*/
    public Customer() {
    }

    public Customer(String id, String name, String nic, String contact, String email, String address, String checkIn) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.checkIn = checkIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", checkIn='" + checkIn + '\'' +
                '}';
    }
}
