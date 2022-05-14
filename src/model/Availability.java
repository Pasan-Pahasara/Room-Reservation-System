package model;

public class Availability {
    private String txtAvailable;
    private String txtNotAvailable;
    private String id;

    public Availability() {
    }

    public Availability(String txtAvailable, String txtNotAvailable, String id) {
        this.setTxtAvailable(txtAvailable);
        this.setTxtNotAvailable(txtNotAvailable);
        this.setId(id);
    }

    public String getTxtAvailable() {

        return txtAvailable;
    }

    public void setTxtAvailable(String txtAvailable) {

        this.txtAvailable = txtAvailable;
    }

    public String getTxtNotAvailable() {

        return txtNotAvailable;
    }

    public void setTxtNotAvailable(String txtNotAvailable) {

        this.txtNotAvailable = txtNotAvailable;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }
}

