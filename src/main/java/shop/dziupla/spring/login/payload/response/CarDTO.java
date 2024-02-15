package shop.dziupla.spring.login.payload.response;

//import shop.dziupla.spring.login.models.*;

public class CarDTO {

    private Long id;

    private float cost;

    private float deposit;

    private int insuranceNumber;

    private boolean available;


    private String licenceCategory;

    private String model;


    private OfficeDTO office;

    private Long officeId;

    private int seatNumber;

    private boolean technicalStatus;


    private String carType;


    private String fuelType;

    public CarDTO() {
    }

    private PhotoDTO photo;

    private String photoURL;

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

    public String getLicence() { return licenceCategory; }

    public void setLicence(String licenceCategory) {
        this.licenceCategory = licenceCategory;
    }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public OfficeDTO getOffice() { return office; }

    public void setOffice(OfficeDTO office) { this.office = office; }

    public Long getOfficeId(){ return this.officeId; }
    public void setOfficeId(Long officeId) { this.officeId = officeId; }
    public int getSeatNumber() { return seatNumber; }

    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public boolean isTechnicalStatus() { return technicalStatus; }

    public void setTechnicalStatus(boolean technicalStatus) { this.technicalStatus = technicalStatus; }

    public String getType() { return carType; }

    public void setType(String cartype) { this.carType = carType; }

    public String getFuelType() { return fuelType; }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public PhotoDTO getPhoto() { return photo; }

    public void setPhoto(PhotoDTO photo) { this.photo = photo; }

    public String getPhotoURL() { return photoURL; }

    public void setPhotoURL(String photoURL) { this.photoURL = photoURL; }

}
