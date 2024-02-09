package shop.dziupla.spring.login.mappers;

import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.Rental;
import shop.dziupla.spring.login.payload.response.RentalDTO;
import shop.dziupla.spring.login.models.DAO.Client;
import shop.dziupla.spring.login.repository.CarRepository;
import shop.dziupla.spring.login.repository.ClientRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;

@Mapper(componentModel = "spring", uses = {OfficeMapper.class,
        CarMapper.class
})
public abstract class RentalMapper {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OfficeRepository officeRepository;

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "carId", source = "car.id")
    public abstract RentalDTO rentalToRentalDTO(Rental rental);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "getClientById")
    @Mapping(target = "car", source = "carId", qualifiedByName = "getCarById")
    @Mapping(target = "originOffice", source = "originOfficeId", qualifiedByName = "getOfficeById1")
    @Mapping(target = "destinationOffice", source = "destinationOfficeId", qualifiedByName = "getOfficeById1")
    public abstract Rental rentalDTOToRental(RentalDTO rentalDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "client", source = "clientId", qualifiedByName = "getClientById")
    @Mapping(target = "car", source = "carId", qualifiedByName = "getCarById")
    @Mapping(target = "originOffice", source = "originOfficeId", qualifiedByName = "getOfficeById1")
    @Mapping(target = "destinationOffice", source = "destinationOfficeId", qualifiedByName = "getOfficeById1")
    public abstract void updateRentalFromDTO(RentalDTO dto, @MappingTarget Rental entity);

    @Named("getClientById")
    Client getClientById(Long clientId) {
        try {
            return clientRepository.getReferenceById(clientId);
        }
        catch (EntityNotFoundException | IllegalArgumentException ex){
            return null;
        }
    }

    @Named("getCarById")
    Car getCarById(Long carId) {
        try {
            return carRepository.getReferenceById(carId);
        }
        catch (EntityNotFoundException | IllegalArgumentException ex){
            return null;
        }
    }
    @Named("getOfficeById1")
    Office getOfficeById(Long officeId) {
        try {
            return officeRepository.getReferenceById(officeId);
        }
        catch (EntityNotFoundException | IllegalArgumentException ex){
            return null;
        }
    }
}
