package Classes;

public class Allotment {

    private String address;
    private double rent;
    private String area;
    private boolean available;
    private Object store_id = null;
    private Store store;

    public Allotment(String address, double rent, String area, boolean available) {
        this.address = address;
        this.rent = rent;
        this.area = area;
        this.available = available;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return this.rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Object getStore_id() {
        return this.store_id;
    }

    public void setStore_id(Object store_id) {
        this.store_id = store_id;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
