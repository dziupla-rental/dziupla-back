package shop.dziupla.spring.endpoints.response;

import shop.dziupla.spring.endpoints.response.entries.LicenseListEntry;

public class RespClientDetails {
    String first_name;
    String last_name;
    boolean is_company;
    LicenseListEntry[] licenses;

    public RespClientDetails(String first_name, String last_name, boolean is_company, LicenseListEntry[] licenses) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_company = is_company;
        this.licenses = licenses;
    }

    public RespClientDetails() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isIs_company() {
        return is_company;
    }

    public void setIs_company(boolean is_company) {
        this.is_company = is_company;
    }

    public LicenseListEntry[] getLicenses() {
        return licenses;
    }

    public void setLicenses(LicenseListEntry[] licenses) {
        this.licenses = licenses;
    }
}
