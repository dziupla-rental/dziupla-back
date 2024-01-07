package shop.dziupla.spring.endpoints.response.entries;

public class LicenseListEntry {
    String expiration_date;
    String category;
    long license_number;

    public LicenseListEntry(String expiration_date, String category, long license_number) {
        this.expiration_date = expiration_date;
        this.category = category;
        this.license_number = license_number;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getLicense_number() {
        return license_number;
    }

    public void setLicense_number(long license_number) {
        this.license_number = license_number;
    }
}
