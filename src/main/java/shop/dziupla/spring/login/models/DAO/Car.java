package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import shop.dziupla.spring.login.models.Enums.ECarType;
import shop.dziupla.spring.login.models.Enums.EDriverLicenseCategory;
import shop.dziupla.spring.login.models.Enums.EFuelType;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private float cost;

    @NotNull
    private float deposit;

    @NotNull
    private int insuranceNumber;

    @NotNull
    private boolean available;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EDriverLicenseCategory licenceCategory;

    @NotBlank
    @Size(max = 120)
    private String model;


    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;


    @NotNull
    private int seatNumber;

    @NotNull
    private boolean technicalStatus;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ECarType carType;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EFuelType fuelType;

    public Car() {
    }
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;


    public Car(ECarType carType, float cost, float deposit, EFuelType fuelType, int insuranceNumber, EDriverLicenseCategory licenceCategory,  String model, int seatNumber, Office office, Photo photo) {//new cars technicalStatus true by default and is available by deafault
       this.carType = carType;
       this.cost = cost;
       this.deposit = deposit;
       this.fuelType = fuelType;
       this.insuranceNumber = insuranceNumber;
       this.licenceCategory = licenceCategory;
       this.available = true;
       this.model = model;
       this.seatNumber = seatNumber;
       this.technicalStatus = true;
       this.office = office;
       this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCost() { return cost; }

    public  void setCost(float cost) { this.cost = cost; }

    public float getDeposit() { return deposit; }

    public void setDeposit(float deposit) { this.deposit = deposit; }

    public int getInsuranceNumber() { return insuranceNumber; }

    public void setInsuranceNumber(int insuranceNumber) { this.insuranceNumber = insuranceNumber; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    public EDriverLicenseCategory getLicence() { return licenceCategory; }

    public void setLicence(EDriverLicenseCategory licenceCategory) {
        this.licenceCategory = licenceCategory;
    }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public Office getOffice() { return office; }

    public void setOffice(Office office) { this.office = office; }

    public int getSeatNumber() { return seatNumber; }

    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public boolean isTechnicalStatus() { return technicalStatus; }

    public void setTechnicalStatus(boolean technicalStatus) { this.technicalStatus = technicalStatus; }

    public ECarType getType() { return carType; }

    public void setType(ECarType type) { this.carType = carType; }

    public EFuelType getFuelType() { return fuelType; }

    public void setFuelType(EFuelType fuelType) { this.fuelType = fuelType; }

    public Photo getPhoto() { return photo; }

    public void setPhoto(Photo photo) { this.photo = photo; }

}
