package shop.dziupla.spring.endpoints.request;

import shop.dziupla.spring.endpoints.response.RespCarDetails;

public class ReqCarModify extends RespCarDetails {
    String action;

    public ReqCarModify() {
    }

    public ReqCarModify(String model, long id, String type, double cost, double deposit, boolean availability, int seat_number, String fuel_type, String image_url, String office, boolean technical_status, long insurance_number, String license, String action) {
        super(model, id, type, cost, deposit, availability, seat_number, fuel_type, image_url, office, technical_status, insurance_number, license);
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
