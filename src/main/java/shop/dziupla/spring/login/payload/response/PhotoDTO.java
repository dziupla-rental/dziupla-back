package shop.dziupla.spring.login.payload.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import shop.dziupla.spring.login.models.DAO.Car;

public class PhotoDTO {
    private Long id;

    private String url;


    public PhotoDTO() {

    }
    public PhotoDTO(String url) {
        this.url = url;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
