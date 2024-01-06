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
}
