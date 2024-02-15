package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.CarMapper;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.payload.response.OfficeDTO;
import shop.dziupla.spring.login.repository.CarRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;
import shop.dziupla.spring.login.repository.PhotoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository repository;
    @Autowired
    OfficeRepository officeRepository;
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
            if (c.getOffice().getLocation().equals(location) && c.isAvailable()) {
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
            if (c.getOffice().getId().equals(id) && c.isAvailable()) {
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
}
