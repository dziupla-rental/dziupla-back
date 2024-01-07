package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String location;

    public Office(){

    }
    public Office(String location){
        this.location = location;
    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}
}

