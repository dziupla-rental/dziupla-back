package shop.dziupla.spring.endpoints.request;

import jakarta.validation.constraints.NotBlank;

public class ReqRentalModify {
    long car_id;
    @NotBlank
    String rent_from;
    @NotBlank
    String rent_to;
    @NotBlank
    String action;

    public ReqRentalModify(long car_id, String rent_from, String rent_to, String action) {
        this.car_id = car_id;
        this.rent_from = rent_from;
        this.rent_to = rent_to;
        this.action = action;
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    public String getRent_from() {
        return rent_from;
    }

    public void setRent_from(String rent_from) {
        this.rent_from = rent_from;
    }

    public String getRent_to() {
        return rent_to;
    }

    public void setRent_to(String rent_to) {
        this.rent_to = rent_to;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
