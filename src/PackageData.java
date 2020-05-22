import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private Guests guests;
    private Products products;
    private ArrayList<Guests> guest;

    public PackageData(String operationType, Guests guests) {
        this.operationType = operationType;
        this.guests = guests;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(ArrayList<Guests> guest) {
        this.guest = guest;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }

    public ArrayList<Guests> getGuest() {
        return guest;
    }

    public void setGuest(ArrayList<Guests> guest) {
        this.guest = guest;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}


