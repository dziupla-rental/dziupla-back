package shop.dziupla.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.models.Car;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository repository;

    public List<CarDTO> getAllCars(){
        List<CarDTO> list = new ArrayList<>();
        for( Car c : repository.findAll()){
            list.add(DAOtoDTO(c));
        }
        return list;
    }

    public CarDTO getCarById(long id){
        return repository.findById(id).isEmpty() ?  DAOtoDTO(repository.findById(id).get()) : null;
    }
    public Car DTOtoDAO(CarDTO carDTO){
        Car car = new Car();
        if(carDTO.getId()!=null){
            car.setId(carDTO.getId());
        }
        if(carDTO.getType()!=null){
            car.setType(carDTO.getType());
        }
        car.setCost(carDTO.getCost());
        car.setDeposit(carDTO.getDeposit());
        if(carDTO.getFuelType()!=null){
            car.setFuelType(carDTO.getFuelType());
        }
        car.setInsuranceNumber(carDTO.getInsuranceNumber());
        if(carDTO.getLicence()!=null){
            car.setLicence(carDTO.getLicence());
        }
        if(carDTO.getModel()!=null){
            car.setModel(carDTO.getModel());
        }
        car.setSeatNumber(carDTO.getSeatNumber());
        if(carDTO.getOfficeId()!=null){
            car.setOfficeId(carDTO.getOfficeId());
        }
        if(carDTO.getPhoto()!=null){
            car.setPhoto(carDTO.getPhoto());
        }
        car.setTechnicalStatus(carDTO.isTechnicalStatus());
        car.setAvailable(carDTO.isAvailable());
        return car;
    }
    public CarDTO DAOtoDTO(Car car){
        return new CarDTO(car.getId(),car.getType(),car.getCost(),car.getDeposit(),car.getFuelType(),car.getInsuranceNumber(),car.getLicence(),car.getModel(),car.getSeatNumber(),car.getOfficeId(),car.getPhoto(),car.isTechnicalStatus(),car.isAvailable());
    }
}
