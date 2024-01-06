package shop.dziupla.spring.endpoints.response;

import shop.dziupla.spring.endpoints.response.entries.CarListEntry;

public class RespCarDetails extends CarListEntry{
    boolean technical_status;
    long insurance_number;
    String license;

    public RespCarDetails() {
    }

    public RespCarDetails(String model, long id, String type, double cost, double deposit, boolean availability, int seat_number, String fuel_type, String image_url, String office, boolean technical_status, long insurance_number, String license) {
        super(model, id, type, cost, deposit, availability, seat_number, fuel_type, image_url, office);
        this.technical_status = technical_status;
        this.insurance_number = insurance_number;
        this.license = license;
    }

    public boolean isTechnical_status() {
        return technical_status;
    }

    public void setTechnical_status(boolean technical_status) {
        this.technical_status = technical_status;
    }

    public long getInsurance_number() {
        return insurance_number;
    }

    public void setInsurance_number(long insurance_number) {
        this.insurance_number = insurance_number;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
