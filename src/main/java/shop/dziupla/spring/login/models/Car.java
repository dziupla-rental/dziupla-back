package shop.dziupla.spring.login.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private float cost;

    @NotBlank
    private float deposit;

    @NotBlank
    private int insuranceNumber;

    @NotBlank
    private boolean available;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "car_licences",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "license_id"))
    private Set<DriverLicenseCategory> licences = new HashSet<>();

    @NotBlank
    private long licenseId;

    @NotBlank
    @Size(max = 120)
    private String model;

    @NotBlank
    private long officeId;

    @NotBlank
    private int seatNumber;

    @NotBlank
    private boolean technicalStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "types_of_cars",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "car_type_id"))
    private Set<CarType> types = new HashSet<>();
    public Car() {
    }
    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Photo photo;

    @NotBlank
    private long photoId;

    public Car(float cost, float deposit, int insuranceNumber, long licenseId, String model, long officeId, int seatNumber) {//new cars technicalStatus true by default and is available by deafault
       this.cost = cost;
       this.deposit = deposit;
       this.insuranceNumber = insuranceNumber;
       this.available = true;
       this.licenseId = licenseId;
       this.model = model;
       this.officeId = officeId;
       this.seatNumber = seatNumber;
       this.technicalStatus = true;
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

    public Set<DriverLicenseCategory> getLicences() { return licences; }

    public void setLicences(Set<DriverLicenseCategory> licences) {
        this.licences = licences;
    }

    public long getLicenseId() { return  licenseId; }

    public void setLicenseId(long licenseId) { this.licenseId = licenseId; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public long getOfficeId() { return officeId; }

    public void setOfficeId(long officeId) { this.officeId = officeId; }

    public int getSeatNumber() { return seatNumber; }

    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public boolean isTechnicalStatus() { return technicalStatus; }

    public void setTechnicalStatus(boolean technicalStatus) { this.technicalStatus = technicalStatus; }

    public Set<CarType> getTypes() { return types; }

    public void setTypes(Set<CarType> types) { this.types = types; }

    public Photo getPhoto() { return photo; }

    public void setPhoto(Photo photo) { this.photo = photo; }

    public long getPhotoId() { return photoId; }

    public void setPhotoId(long photoId) { this.photoId = photoId; }
}
