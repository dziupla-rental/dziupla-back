package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Client;

import java.util.Date;

@Entity
@Table(name = "rentals",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "protocolId")
})
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_office_id", referencedColumnName = "id")
    private Office originOffice;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_office_id", referencedColumnName = "id")
    private Office destinationOffice;

    private Long protocolId;

    private Date startDate;

    private Date endDate;

    public Rental() {}
    public Rental(Car car, Client client, Office originOffice, Office destinationOffice, Long protocolId, Date startDate, Date endDate) {
        this.car = car;
        this.client = client;
        this.originOffice = originOffice;
        this.destinationOffice = destinationOffice;
        this.protocolId = protocolId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Office getOriginOffice() { return originOffice; }
    public void setOriginOffice(Office originOffice) { this.originOffice = originOffice; }

    public Office getDestinationOffice() { return destinationOffice; }
    public void setDestinationOffice(Office destinationOffice) { this.destinationOffice = destinationOffice; }

    public Long getProtocolId() { return protocolId; }
    public void setProtocolId(Long protocolId) { this.protocolId = protocolId; }

    public Date getStart() { return startDate; }
    public void setStart(Date start) { this.startDate = start; }

    public Date getEnd() { return endDate; }
    public void setEnd(Date end) { this.endDate = end; }
}
