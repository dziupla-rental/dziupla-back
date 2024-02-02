package shop.dziupla.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.CarMapper;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository repository;
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

}
