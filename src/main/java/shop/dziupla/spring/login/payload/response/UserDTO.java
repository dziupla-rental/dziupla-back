package shop.dziupla.spring.login.payload.response;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String role;

    public UserDTO(Long id, String username, String email, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return role;
    }
}
