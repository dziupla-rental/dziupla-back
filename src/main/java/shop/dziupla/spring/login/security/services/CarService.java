package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.CarMapper;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.repository.CarRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;
import shop.dziupla.spring.login.repository.RentalRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository repository;
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    CarMapper mapper;

    public List<CarDTO> getAllCars(){
        List<CarDTO> list = new ArrayList<>();
        for( Car c : repository.findAll()){
            list.add(mapper.carToCarDTO(c));
        }
        return list;
    }

    public CarDTO getCarById(long id){
        return mapper.carToCarDTO(repository.getReferenceById(id));
    }
    public CarDTO addCar(CarDTO car){
        if(car.getId() != null)throw new IllegalArgumentException();
        return mapper.carToCarDTO(repository.save(mapper.carDTOToCar(car)));
    }
    public List<CarDTO> getServicedCars() {
        List<CarDTO> list = new ArrayList<>();
        for (Car c : repository.findAll()) {
            if (!c.isTechnicalStatus()) {
                list.add(mapper.carToCarDTO(c));
            }
        }
        return list;
    }
    public List<CarDTO> getFunctionalCars() {
        List<CarDTO> list = new ArrayList<>();
        for (Car c : repository.findAll()) {
            if (c.isTechnicalStatus()) {
                list.add(mapper.carToCarDTO(c));
            }
        }
        return list;
    }
    public List<CarDTO> getCarsByOffice(long officeId) {
        if(!officeRepository.existsById(officeId)) throw new EntityNotFoundException();
        List<CarDTO> list = new ArrayList<>();
        for (Car c : repository.findAll()) {
            if(c.getOffice()==null){
                continue;
            }
            if (c.getOffice().getId()==officeId) {
                list.add(mapper.carToCarDTO(c));
            }
        }
        return list;
    }
    public List<CarDTO> getCarsByOffice(String location) {
        if(!officeRepository.existsByLocation(location)) throw new EntityNotFoundException();
        List<CarDTO> list = new ArrayList<>();
        for (Car c : repository.findAll()) {
            if(c.getOffice()==null){
                continue;
            }
            if (c.getOffice().getLocation().equals(location)) {
                list.add(mapper.carToCarDTO(c));
            }
        }
        return list;
    }
    public List<CarDTO> getCarsDoubleFiltered(String location) {
        if(location == null)throw new NullPointerException();
        if(!officeRepository.existsByLocation(location)) throw new EntityNotFoundException();
        List<CarDTO> list = new ArrayList<>();
        for (Car c : repository.findAll()) {
            if(c.getOffice()==null){
                continue;
            }
            if (c.getOffice().getLocation().equals(location)) {
                list.add(mapper.carToCarDTO(c));
            }
        }
        return list;
    }
    public List<CarDTO> getCarsDoubleFilteredId(Long id) {
        if(id == null)throw new NullPointerException();
        if(!officeRepository.existsById(id)) throw new EntityNotFoundException();
        List<CarDTO> list = new ArrayList<>();
        for (Car c : repository.findAll()) {
            if(c.getOffice()==null){
                continue;
            }
            if (c.getOffice().getId().equals(id)) {
                list.add(mapper.carToCarDTO(c));
            }
        }
        return list;
    }
    public void deleteCarById(Long id){
        if(id == null)throw new NullPointerException();
        if(!repository.existsById(id)) throw new EntityNotFoundException();
        repository.deleteById(id);
    }
    public CarDTO updateCar(CarDTO car){
        if(car == null)throw new NullPointerException();
        if(car.getId() == null)throw new IllegalArgumentException();
        if(!repository.existsById(car.getId())) throw new EntityNotFoundException();
        Car carDAO = repository.getReferenceById(car.getId());
        mapper.updateCarFromDTO(car, carDAO);
        return mapper.carToCarDTO(repository.save(carDAO));
    }

    public List<CarDTO> getAvailableByDateAndLocation(Long officeId, LocalDate startDate, LocalDate endDate){
        if(startDate.isAfter(endDate)) throw new IllegalArgumentException();
        Office office = officeRepository.getReferenceById(officeId);
        var carsByOffice = repository.getCarsByOffice(office);
        var result = new ArrayList<CarDTO>();
        for(var car : carsByOffice) {
            var date = startDate;
            result.add(mapper.carToCarDTO(car));
            while (!date.isAfter(endDate)) {
                if(!rentalRepository.existsByDateBetweenStartAndEnd(car.getId(), date)){
                    result.remove(result.size() -1);
                    break;
                }
                date = date.plusDays(1);
            }
        }

       return result;
    }
}
