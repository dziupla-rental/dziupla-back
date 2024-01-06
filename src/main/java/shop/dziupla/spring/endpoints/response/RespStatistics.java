package shop.dziupla.spring.endpoints.response;

public class RespStatistics {
    int cars_total;
    int cars_rented;
    int cars_service;
    int employees_total;
    int office_total;
    int clients_total;
    int[] earning_stats;

    public RespStatistics() {
    }

    public RespStatistics(int cars_total, int cars_rented, int cars_service, int employees_total, int office_total, int clients_total, int[] earning_stats) {
        this.cars_total = cars_total;
        this.cars_rented = cars_rented;
        this.cars_service = cars_service;
        this.employees_total = employees_total;
        this.office_total = office_total;
        this.clients_total = clients_total;
        this.earning_stats = earning_stats;
    }

    public int getCars_total() {
        return cars_total;
    }

    public void setCars_total(int cars_total) {
        this.cars_total = cars_total;
    }

    public int getCars_rented() {
        return cars_rented;
    }

    public void setCars_rented(int cars_rented) {
        this.cars_rented = cars_rented;
    }

    public int getCars_service() {
        return cars_service;
    }

    public void setCars_service(int cars_service) {
        this.cars_service = cars_service;
    }

    public int getEmployees_total() {
        return employees_total;
    }

    public void setEmployees_total(int employees_total) {
        this.employees_total = employees_total;
    }

    public int getOffice_total() {
        return office_total;
    }

    public void setOffice_total(int office_total) {
        this.office_total = office_total;
    }

    public int getClients_total() {
        return clients_total;
    }

    public void setClients_total(int clients_total) {
        this.clients_total = clients_total;
    }

    public int[] getEarning_stats() {
        return earning_stats;
    }

    public void setEarning_stats(int[] earning_stats) {
        this.earning_stats = earning_stats;
    }
}
