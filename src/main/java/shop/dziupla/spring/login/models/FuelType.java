package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import shop.dziupla.spring.login.models.Enums.EFuelType;

@Entity
@Table(name = "fuelType")
public class FuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EFuelType type;

    public FuelType() {

    }

    public FuelType(EFuelType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EFuelType getType() {
        return type;
    }

    public void setType(EFuelType name) {
        this.type = type;
    }
}