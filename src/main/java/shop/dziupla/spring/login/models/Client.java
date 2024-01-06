package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_id", referencedColumnName = "id")
    CompanyInfo companyInfo;    // null if client is an individual client, not company

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public CompanyInfo getCompanyInfo() { return companyInfo; }
    public void setCompanyInfo(CompanyInfo companyInfo) { this.companyInfo = companyInfo; }
}
