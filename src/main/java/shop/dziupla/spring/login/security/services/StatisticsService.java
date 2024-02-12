package shop.dziupla.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.payload.response.StatisticsDTO;
import shop.dziupla.spring.login.repository.CarRepository;
import shop.dziupla.spring.login.repository.ClientRepository;
import shop.dziupla.spring.login.repository.EmployeeRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;

@Service
public class StatisticsService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    ClientRepository clientRepository;
    public StatisticsDTO getStatistics(){
        var result = new StatisticsDTO();
        result.setCarCount(carRepository.count());
        result.setAvailableCars(carRepository.countAllByAvailable(true));
        result.setServicedCars(carRepository.countAllByTechnicalStatus(false));
        result.setRentedCars(result.getCarCount() - result.getAvailableCars() - result.getServicedCars());
        result.setEmployeeCount(employeeRepository.count());
        result.setOfficeCount(officeRepository.count());
        result.setClientCount(clientRepository.count());
        return result;
    }
}
