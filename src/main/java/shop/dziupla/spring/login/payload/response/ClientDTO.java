package shop.dziupla.spring.login.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import shop.dziupla.spring.login.models.DAO.CompanyInfo;
import shop.dziupla.spring.login.models.DAO.Role;
import shop.dziupla.spring.login.models.DAO.User;

public class ClientDTO {
    private Long id;
    @JsonIgnore private User user;
    private String username;
    private String email;
    private String name;
    private String lastName;
    private String role;
    private CompanyInfoDTO companyInfo;

    public ClientDTO() {}
    @Default public ClientDTO(Long id, User user, CompanyInfoDTO companyInfo) {
        this.id = id;
        this.user = user;
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.name = user.getName();
        this.lastName = user.getLastname();
        this.role = user.getRole().getName().name();
        this.companyInfo = companyInfo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getUsername() { return username; }
    public void setUsername(String username) {
        user.setUsername(username);
        this.username = username;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        user.setEmail(email);
        this.email = email;
    }
    public String getName() { return name; }
    public void setName(String name) {
        user.setName(name);
        this.name = name;
    }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        user.setLastname(lastName);
        this.lastName = lastName;
    }
    public String getRole() { return role; }
    public void setRole(String role) {
        this.role = role;
    }
    public CompanyInfoDTO getCompanyInfo() { return companyInfo; }
    public void setCompanyInfo(CompanyInfoDTO companyInfo) { this.companyInfo = companyInfo; }
}
