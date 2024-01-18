package shop.dziupla.spring.login.payload.response;

import ch.qos.logback.core.joran.spi.DefaultClass;

public class CompanyInfoDTO {
    private Long id;
    private String name;
    private int NIP;
    
    public CompanyInfoDTO() {}
    public CompanyInfoDTO(Long id, String name, int NIP) {
        this.id = id;
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
