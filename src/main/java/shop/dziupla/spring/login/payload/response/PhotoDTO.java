package shop.dziupla.spring.login.payload.response;

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
