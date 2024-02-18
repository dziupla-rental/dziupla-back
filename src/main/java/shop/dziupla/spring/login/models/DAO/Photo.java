package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotBlank
    @Size(max = 200)
    private String url;


    public Photo() {

    }
    public Photo(String url) {
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
