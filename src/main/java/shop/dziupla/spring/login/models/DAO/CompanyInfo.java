package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import shop.dziupla.spring.login.payload.response.Default;

@Entity
@Table(name = "company_info",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "NIP")
        })
public class CompanyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 300)
    private String name;

    private int NIP;

    public CompanyInfo() {}
    public CompanyInfo(String name, int NIP) {
        this.name = name;
        this.NIP = NIP;
    }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public void setNIP(int NIP) { this.NIP = NIP; }
    public int getNIP() { return NIP; }
}

