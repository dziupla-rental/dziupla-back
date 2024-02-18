package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import shop.dziupla.spring.login.payload.response.Default;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_info_id", referencedColumnName = "id")
    private CompanyInfo companyInfo;    // null if is an individual client

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DriverLicense> licenses;

    public Client() {}
    public @Default Client(User user, CompanyInfo companyInfo, List<DriverLicense> licenses) {
        this.user = user;
        this.companyInfo = companyInfo;
        this.licenses = licenses;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public CompanyInfo getCompanyInfo() { return companyInfo; }
    public void setCompanyInfo(CompanyInfo companyInfo) { this.companyInfo = companyInfo; }
    public List<DriverLicense> getLicenses() { return licenses; }
    public void setLicenses(List<DriverLicense> licenses) { this.licenses = licenses; }
}
