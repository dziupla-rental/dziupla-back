package shop.dziupla.spring.login.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.List;

public class DriverLicenseDTO {

    private Long id;
    //private @JsonIgnore ClientDTO client;
    private @JsonIgnore Long clientId;
    private String licenseCategory;
    private Long licenseNumber;
    private LocalDate expirationDate;

    public DriverLicenseDTO() {}

    public DriverLicenseDTO(Long id, /*ClientDTO client,*/ String licenseCategory, Long licenseNumber, LocalDate expirationDate, Long clientId) {
        this.id = id;
        //this.client = client;
        this.licenseCategory = licenseCategory;
        this.licenseNumber = licenseNumber;
        this.expirationDate = expirationDate;
        this.clientId = clientId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    //public ClientDTO getClient() { return client; }
    //public void setClient(ClientDTO client) { this.client = client; }

    public String getLicenseCategory() { return licenseCategory; }
    public void setLicenseCategory(String licenseCategory) { this.licenseCategory = licenseCategory; }

    public Long getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(Long licenseNumber) { this.licenseNumber = licenseNumber; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    public Long getClientId() { return this.clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
}

