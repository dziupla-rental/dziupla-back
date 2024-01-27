package shop.dziupla.spring.login.payload.response;

import shop.dziupla.spring.login.models.*;

public class CarDTO {

    private Long id;


    private float cost;


    private float deposit;


    private int insuranceNumber;


    private boolean available;



    private EDriverLicenseCategory licenceCategory;


    private String model;



    private Office office;



    private int seatNumber;


    private boolean technicalStatus;



    private ECarType carType;



    private EFuelType fuelType;

    public CarDTO() {
    }

    private Photo photo;


    public CarDTO(Long id, ECarType carType, float cost, float deposit, EFuelType fuelType, int insuranceNumber, EDriverLicenseCategory licenceCategory,  String model, int seatNumber, Office office, Photo photo, boolean technicalStatus, boolean available) {//new cars technicalStatus true by default and is available by deafault
        this.id=id;
        this.carType = carType;
        this.cost = cost;
        this.deposit = deposit;
        this.fuelType = fuelType;
        this.insuranceNumber = insuranceNumber;
        this.licenceCategory = licenceCategory;
        this.model = model;
        this.seatNumber = seatNumber;
        this.office = office;
        this.photo = photo;
        this.technicalStatus = technicalStatus;
        this.available = available;
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

    public Office getOfficeId() { return office; }

    public void setOfficeId(Office office) { this.office = office; }

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
