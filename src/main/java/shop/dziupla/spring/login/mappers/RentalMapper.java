package shop.dziupla.spring.login.mappers;

import jakarta.persistence.EntityNotFoundException;
import org.javatuples.Pair;
import org.mapstruct.*;

import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.Rental;
import shop.dziupla.spring.login.models.Enums.EAddition;
import shop.dziupla.spring.login.payload.response.RentalDTO;
import shop.dziupla.spring.login.models.DAO.Client;
import shop.dziupla.spring.login.repository.CarRepository;
import shop.dziupla.spring.login.repository.ClientRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;

@Mapper(componentModel = "spring", uses = {OfficeMapper.class,
        CarMapper.class }, imports = Pair.class)
public abstract class RentalMapper {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OfficeRepository officeRepository;


    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "cost", source = "rental", qualifiedByName = "calculateCost1")
    public abstract RentalDTO rentalToRentalDTO(Rental rental);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "getClientById")
    @Mapping(target = "car", source = "carId", qualifiedByName = "getCarById")
    @Mapping(target = "originOffice", source = "originOfficeId", qualifiedByName = "getOfficeById1")
    @Mapping(target = "destinationOffice", source = "destinationOfficeId", qualifiedByName = "getOfficeById1")
    @Mapping(target = "cost", source = "rentalDTO", qualifiedByName = "calculateCost")
    public abstract Rental rentalDTOToRental(RentalDTO rentalDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "client", source = "clientId", qualifiedByName = "getClientById")
    @Mapping(target = "car", source = "carId", qualifiedByName = "getCarById")
    @Mapping(target = "originOffice", source = "originOfficeId", qualifiedByName = "getOfficeById1")
    @Mapping(target = "destinationOffice", source = "destinationOfficeId", qualifiedByName = "getOfficeById1")
    //@Mapping(target = "cost", source = "dto", qualifiedByName = "calculateCost")
    //@Mapping(target = "cost", expression = "java((dto.getCost() != null ? calculateCost(dto) : entity.getCost()))")
    @Mapping(target = "cost", expression = "java(updateCost(new Pair<RentalDTO, Rental>(dto, entity)))")
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

    @Named("calculateCost")
    Float calculateCost(RentalDTO rental){
        try {
            Float result = carRepository.getReferenceById(rental.getCarId()).getCost();
            for (var add : rental.getAdditions()) {
                result += EAddition.valueOf(add).getPrice();
            }
            return result;
        }
        catch(Exception ex){
            return null;
        }

    }

    @Named("calculateCost1")
    Float calculateCost1(Rental rental){
        Float result = carRepository.getReferenceById(rental.getCar().getId()).getCost();
        for(var add : rental.getAdditions()){
            result += add.getPrice();
        }
        return result;
    }

    @Named("updateCost")
    Float updateCost(Pair<RentalDTO, Rental> pair){
        try {
            RentalDTO tempDto = pair.getValue0();
            Rental tempEnitty = pair.getValue1();
            float result = tempEnitty.getCar().getCost();

            if(tempDto.getCarId() != null) {
                result = carRepository.getReferenceById(tempDto.getCarId()).getCost();

                if(tempDto.getAdditions() != null) {
                    for (var add : tempDto.getAdditions()) {
                        result += EAddition.valueOf(add).getPrice();
                    }
                    return result;
                }
                else {
                    for (var add : tempEnitty.getAdditions()) {
                        result += add.getPrice();
                    }
                    return result;
                }
            }

            if(tempDto.getAdditions() != null) {
                for (var add : tempDto.getAdditions()) {
                    result += EAddition.valueOf(add).getPrice();
                }
                return result;
            }
            else {
                for (var add : tempEnitty.getAdditions()) {
                    result += add.getPrice();
                }
                return result;
            }
        }
        catch(Exception ex){
            return null;
        }

    }
}
