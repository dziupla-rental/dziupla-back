package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import shop.dziupla.spring.login.models.Enums.EAddition;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rentals",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "protocolNumber")
})
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    //@NotNull
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    //@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_office_id", referencedColumnName = "id")
    private Office originOffice;

    //@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_office_id", referencedColumnName = "id")
    private Office destinationOffice;

    @NotNull
    private Long protocolNumber;

    private LocalDate startDate;

    private LocalDate endDate;

    @ElementCollection(targetClass = EAddition.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "rental_additions")
    @Column(name = "addition")
    private List<EAddition> additions;

    public Rental() {}
    public Rental(Car car, Client client, Office originOffice, Office destinationOffice, Long protocolNumber,
                  LocalDate startDate, LocalDate endDate, List<EAddition> additions) {
        this.car = car;
        this.client = client;
        this.originOffice = originOffice;
        this.destinationOffice = destinationOffice;
        this.protocolNumber = protocolNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additions = additions;
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

    public Long getProtocolNumber() { return protocolNumber; }
    public void setProtocolNumber(Long protocolNumber) { this.protocolNumber = protocolNumber; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate start) { this.startDate = start; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate end) { this.endDate = end; }

    public List<EAddition> getAdditions() { return additions; }
    public void setAdditions(List<EAddition> additions) { this.additions = additions; }
}
