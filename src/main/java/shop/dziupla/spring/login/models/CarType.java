package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import shop.dziupla.spring.login.models.Enums.ECarType;

@Entity
@Table(name = "carType")
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECarType type;

    public CarType() {

    }

    public CarType(ECarType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ECarType getType() {
        return type;
    }

    public void setType(ECarType name) {
        this.type = type;
    }
}