package shop.dziupla.spring.login.payload.response;

public class StatisticsDTO {
    private int carCount;
    private int rentedCars;
    private int servicedCars;
    private int availableCars;
    private int clientCount;
    private int officeCount;
    private int employeeCount;
    public StatisticsDTO(){

    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(int rentedCars) {
        this.rentedCars = rentedCars;
    }

    public int getServicedCars() {
        return servicedCars;
    }

    public void setServicedCars(int servicedCars) {
        this.servicedCars = servicedCars;
    }

    public int getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(int availableCars) {
        this.availableCars = availableCars;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public int getOfficeCount() {
        return officeCount;
    }

    public void setOfficeCount(int officeCount) {
        this.officeCount = officeCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
