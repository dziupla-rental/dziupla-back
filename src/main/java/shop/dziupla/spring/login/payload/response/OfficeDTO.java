package shop.dziupla.spring.login.payload.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class OfficeDTO {

    private Long id;

    private String location;

    public OfficeDTO(){

    }
    public OfficeDTO(Long id, String location){
        this.id = id; this.location = location;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

}
