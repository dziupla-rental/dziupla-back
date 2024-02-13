package shop.dziupla.spring.login.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.payload.response.StatisticsDTO;
import shop.dziupla.spring.login.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;

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
    @Autowired
    RentalRepository rentalRepository;

    public StatisticsDTO getStatistics(){
        var result = new StatisticsDTO();
        result.setCarCount(carRepository.count());
        result.setAvailableCars(carRepository.countAllByAvailable(true));
        result.setServicedCars(carRepository.countAllByTechnicalStatus(false));
        result.setRentedCars(result.getCarCount() - result.getAvailableCars() - result.getServicedCars());
        result.setEmployeeCount(employeeRepository.count());
        result.setOfficeCount(officeRepository.count());
        result.setClientCount(clientRepository.count());
        var date = LocalDate.now().minusYears(1).withDayOfMonth(1);
        ArrayList<Double> incomeList = new ArrayList<>();
        for(var x = 0; x < 12; x++){
            var results = rentalRepository.getAllByEndDateBetween(date, date.plusMonths(1));
            Double value = 0.0;
            for(var  y : results){
                if(y.getCost() != null) value += y.getCost();
            }
            incomeList.add(value);
            date = date.plusMonths(1);
        }
        result.setIncome(incomeList);
        return result;
    }
}
