package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.RentalMapper;
import shop.dziupla.spring.login.models.DAO.Rental;
import shop.dziupla.spring.login.payload.response.RentalDTO;
import shop.dziupla.spring.login.repository.ClientRepository;
import shop.dziupla.spring.login.repository.RentalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository repository;
    @Autowired
    RentalMapper mapper;
    @Autowired
    ClientRepository clientRepository;

    public RentalService() {}

    public List<RentalDTO> getAllRentals() {
        var result = new ArrayList<RentalDTO>();

        for(var rental : repository.findAll()) {
            result.add(mapper.rentalToRentalDTO(rental));
        }
        return  result;
    }

    public RentalDTO getRentalById(Long id) throws NullPointerException, EntityNotFoundException {
        if(id == null)
            throw new NullPointerException();

        Rental result = repository.getReferenceById(id);
        return mapper.rentalToRentalDTO(result);
    }

    public List<RentalDTO> getRentalsByClientId(Long clientId) throws EntityNotFoundException, NullPointerException {
        if(!clientRepository.existsById(clientId))
            throw new EntityNotFoundException();

        var result = new ArrayList<RentalDTO>();

        for(var rental : repository.findAllByClientId(clientId)) {
            result.add(mapper.rentalToRentalDTO(rental));
        }
        return  result;
    }

    public RentalDTO addRental(RentalDTO rentalDTO) throws IllegalArgumentException, NullPointerException {
        if(rentalDTO.getId() != null)
            throw new IllegalArgumentException();

        Rental result = repository.save(
                mapper.rentalDTOToRental(rentalDTO));

        return mapper.rentalToRentalDTO(result);
    }

    public void deleteRentalById(Long id) throws EntityNotFoundException, NullPointerException {
        if(!repository.existsById(id))
            throw new EntityNotFoundException();

        repository.deleteById(id);
    }

    public RentalDTO updateRental(RentalDTO rentalDTO) throws EntityNotFoundException, NullPointerException {
        Long id = rentalDTO.getId();

        Rental rental = repository.getReferenceById(id);
        mapper.updateRentalFromDTO(rentalDTO, rental);

        return mapper.rentalToRentalDTO(repository.save(rental));
    }

    public Boolean isCarAvailable(Long carId, LocalDate date) {
        return repository.existsByDateBetweenStartAndEnd(carId, date);
    }

    public Boolean isCarAvailableInScope(Long carId, LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if(!repository.existsByDateBetweenStartAndEnd(carId, date))
                return false;
        }
        return true;
    }
}
