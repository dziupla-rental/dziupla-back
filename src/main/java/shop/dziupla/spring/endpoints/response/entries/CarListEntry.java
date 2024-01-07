package shop.dziupla.spring.endpoints.response.entries;

public class CarListEntry {
    String model;
    long id;
    String type;
    double cost;
    double deposit;
    boolean availability;
    int seat_number;
    String fuel_type;
    String image_url;
    String office;

    public CarListEntry() {
    }

    public CarListEntry(String model, long id, String type, double cost, double deposit, boolean availability, int seat_number, String fuel_type, String image_url, String office) {
        this.model = model;
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.deposit = deposit;
        this.availability = availability;
        this.seat_number = seat_number;
        this.fuel_type = fuel_type;
        this.image_url = image_url;
        this.office = office;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
