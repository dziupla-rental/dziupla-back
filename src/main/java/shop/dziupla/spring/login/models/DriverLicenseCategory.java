package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import shop.dziupla.spring.login.models.Enums.EDriverLicenseCategory;

@Entity
@Table(name = "driverLicenseCategory")
public class DriverLicenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EDriverLicenseCategory category;

    public DriverLicenseCategory() {

    }

    public DriverLicenseCategory(EDriverLicenseCategory category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EDriverLicenseCategory getCategory() {
        return category;
    }

    public void setCategory(EDriverLicenseCategory name) {
        this.category = category;
    }
}