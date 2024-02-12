package shop.dziupla.spring.login.payload.response;

public class StatisticsDTO {
    private long carCount;
    private long rentedCars;
    private long servicedCars;
    private long availableCars;
    private long clientCount;
    private long officeCount;
    private long employeeCount;
    public StatisticsDTO(){

    }

    public long getCarCount() {
        return carCount;
    }

    public void setCarCount(long carCount) {
        this.carCount = carCount;
    }

    public long getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(long rentedCars) {
        this.rentedCars = rentedCars;
    }

    public long getServicedCars() {
        return servicedCars;
    }

    public void setServicedCars(long servicedCars) {
        this.servicedCars = servicedCars;
    }

    public long getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(long availableCars) {
        this.availableCars = availableCars;
    }

    public long getClientCount() {
        return clientCount;
    }

    public void setClientCount(long clientCount) {
        this.clientCount = clientCount;
    }

    public long getOfficeCount() {
        return officeCount;
    }

    public void setOfficeCount(long officeCount) {
        this.officeCount = officeCount;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}
