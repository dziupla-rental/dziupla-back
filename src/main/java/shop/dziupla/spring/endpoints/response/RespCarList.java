package shop.dziupla.spring.endpoints.response;

import shop.dziupla.spring.endpoints.response.entries.CarListEntry;

public class RespCarList {
    String[] car_types;
    String[] fuel_types;
    CarListEntry[] cars;

    public RespCarList() {
    }

    public RespCarList(String[] car_types, String[] fuel_types, CarListEntry[] cars) {
        this.car_types = car_types;
        this.fuel_types = fuel_types;
        this.cars = cars;
    }

    public String[] getCar_types() {
        return car_types;
    }

    public void setCar_types(String[] car_types) {
        this.car_types = car_types;
    }

    public String[] getFuel_types() {
        return fuel_types;
    }

    public void setFuel_types(String[] fuel_types) {
        this.fuel_types = fuel_types;
    }

    public CarListEntry[] getCars() {
        return cars;
    }

    public void setCars(CarListEntry[] cars) {
        this.cars = cars;
    }
}
