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
        int availableCounter = 0;
        for(var car : carRepository.findAll()){
            if(rentalRepository.existsByDateBetweenStartAndEnd(car.getId(), LocalDate.now())){
                availableCounter ++;
            }
        }
        result.setAvailableCars(availableCounter);
        result.setServicedCars(carRepository.countAllByTechnicalStatus(false));
        result.setRentedCars(result.getCarCount() - result.getAvailableCars());
        result.setEmployeeCount(employeeRepository.count());
        result.setOfficeCount(officeRepository.count());
        result.setClientCount(clientRepository.count());
        var date = LocalDate.now().minusYears(2).withDayOfMonth(1);
        ArrayList<Double> incomeList = new ArrayList<>();
        for(var x = 0; x < 24; x++){
            var results = rentalRepository.getAllByEndDateBetween(date, date.plusMonths(1));
            Double value = 0.0;
            for(var  y : results){
                if(y.getEndDate().getMonthValue() == date.getMonthValue()) {
                    if (y.getCost() != null) value += y.getCost();
                }
            }
            incomeList.add(value);
            date = date.plusMonths(1);
        }
        result.setIncome(incomeList);
        return result;
    }
}
