package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import shop.dziupla.spring.login.models.Enums.EDriverLicenseCategory;

import java.time.LocalDate;

@Entity
@Table(name = "driver_licenses", uniqueConstraints = {
        @UniqueConstraint(columnNames = "licenseNumber")
})
public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private EDriverLicenseCategory licenseCategory;

    private Long licenseNumber;

    private LocalDate expirationDate;

    public DriverLicense() {}

    public DriverLicense(Client client, EDriverLicenseCategory licenseCategory, Long licenseNumber, LocalDate expirationDate) {
        this.client = client;
        this.licenseCategory = licenseCategory;
        this.licenseNumber = licenseNumber;
        this.expirationDate = expirationDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public EDriverLicenseCategory getLicenseCategory() { return licenseCategory; }
    public void setLicenseCategory(EDriverLicenseCategory licenseCategory) { this.licenseCategory = licenseCategory; }

    public Long getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(Long licenseNumber) { this.licenseNumber = licenseNumber; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
}
