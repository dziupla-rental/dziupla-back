package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_id", referencedColumnName = "id")
    private CompanyInfo companyInfo;    // null if client is an individual client, not company

    public Client() {}
    public Client(User user, CompanyInfo companyInfo) {
        this.user = user;
        this.companyInfo = companyInfo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public CompanyInfo getCompanyInfo() { return companyInfo; }
    public void setCompanyInfo(CompanyInfo companyInfo) { this.companyInfo = companyInfo; }
}
