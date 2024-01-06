package shop.dziupla.spring.login.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

@Entity
@Table(name = "driverlicenses", uniqueConstraints = {
        @UniqueConstraint(columnNames = "licenseNumber")
})
public class DriverLicenseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ElementCollection(targetClass = EDriverLicenseCategory.class)
    @CollectionTable(name = "driver_license_categories", joinColumns = @JoinColumn(name = "driver_license_info_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "license_category")
    private List<EDriverLicenseCategory> licenseCategories;

    private Long licenseNumber;
    private Date expirationDate;

    public DriverLicenseInfo() {}

    public DriverLicenseInfo(Client client, List<EDriverLicenseCategory> licenseCategories, Long licenseNumber, Date expirationDate) {
        this.client = client;
        this.licenseCategories = licenseCategories;
        this.licenseNumber = licenseNumber;
        this.expirationDate = expirationDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<EDriverLicenseCategory> getLicenseCategories() { return licenseCategories; }
    public void setLicenseCategories(List<EDriverLicenseCategory> licenseCategories) { this.licenseCategories = licenseCategories; }

    public Long getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(Long licenseNumber) { this.licenseNumber = licenseNumber; }

    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }
}
