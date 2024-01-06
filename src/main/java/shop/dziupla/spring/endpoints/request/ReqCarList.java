package shop.dziupla.spring.endpoints.request;

import jakarta.validation.constraints.NotBlank;

public class ReqCarList {
    @NotBlank
    String office;
    @NotBlank
    String available_start;
    @NotBlank
    String available_end;

    public ReqCarList(String office, String available_start, String available_end) {
        this.office = office;
        this.available_start = available_start;
        this.available_end = available_end;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getAvailable_start() {
        return available_start;
    }

    public void setAvailable_start(String available_start) {
        this.available_start = available_start;
    }

    public String getAvailable_end() {
        return available_end;
    }

    public void setAvailable_end(String available_end) {
        this.available_end = available_end;
    }
}
