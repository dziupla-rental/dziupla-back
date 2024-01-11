package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private EmployeeRepository repository;
    private static EmployeeService service;
    private EmployeeService(){}
    public static EmployeeService getInstance(){
        if(service == null){
            service = new EmployeeService();
        }
        return service;
    }

    public  EmployeeDTO toDTO(Employee employee){

        return new EmployeeDTO(employee.getOffice(), employee.getSalary(), employee.getShiftStart(), employee.getShiftEnd());
    }
    public  Employee toDAO(EmployeeDTO employee){

        return new Employee(employee.getOffice(), employee.getSalary(), employee.getShiftStart(), employee.getShiftEnd(), employee.getUser());
    }
    public EmployeeDTO getEmployeeById(Long id){
        if(id == null)throw new NullPointerException();
        try{
            var result = repository.getReferenceById(id);
            return toDTO(result);
        }
        catch(EntityNotFoundException ex){
            return null;
        }
    }

    public List<EmployeeDTO> getAllEmployees(){
        var result = new ArrayList<EmployeeDTO>();
        for(var employee : repository.findAll()){
            result.add(toDTO(employee));
        }
        return result;
    }
    public EmployeeDTO addEmployee(EmployeeDTO employee){
        if(employee.getId() != null){return null;}
        var result = repository.save(toDAO(employee));
        return toDTO(result);
    }
}
