package shop.dziupla.spring.login.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

public class RentalDTO {
    private Long id;
    private Long carId;
    private Long clientId;
    private OfficeDTO originOffice;
    private OfficeDTO destinationOffice;
    private Long protocolNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> additions;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long originOfficeId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long destinationOfficeId;

    public RentalDTO() { }

    @Default
    public RentalDTO(Long id, Long carId, Long clientId, OfficeDTO originOffice, OfficeDTO destinationOffice,
                     Long protocolNumber, LocalDate startDate, LocalDate endDate, List<String> additions,
                     Long originOfficeId, Long destinationOfficeId) {
        this.id = id;
        this.carId = carId;
        this.clientId = clientId;
        this.originOffice = originOffice;
        this.destinationOffice = destinationOffice;
        this.protocolNumber = protocolNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additions = additions;
        this.originOfficeId = originOfficeId;
        this.destinationOfficeId = destinationOfficeId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCarId() { return carId; }
    public void setCarId(Long carId) { this.carId = carId; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public OfficeDTO getOriginOffice() { return originOffice; }
    public void setOriginOffice(OfficeDTO originOffice) { this.originOffice = originOffice; }

    public OfficeDTO getDestinationOffice() { return destinationOffice; }
    public void setDestinationOffice(OfficeDTO destinationOffice) { this.destinationOffice = destinationOffice; }

    public Long getProtocolNumber() { return protocolNumber; }
    public void setProtocolNumber(Long protocolNumber) { this.protocolNumber = protocolNumber; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public List<String> getAdditions() { return additions; }
    public void setAdditions(List<String> additions) { this.additions = additions; }

    public Long getOriginOfficeId() { return originOfficeId; }
    public void setOriginOfficeId(Long id) { this.originOfficeId = id; }

    public Long getDestinationOfficeId() { return destinationOfficeId; }
    public void setDestinationOfficeId(Long id) { this.destinationOfficeId = id; }
}
