package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.EmployeeMapper;
import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;
    public EmployeeService(){}

    public  EmployeeDTO toDTO(Employee employee){

        return new EmployeeDTO(employee.getId(), employee.getOffice(), employee.getSalary(),
                employee.getShiftStart(), employee.getShiftEnd(), employee.getUser());
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

    public void deleteEmployee(Long id){
        try {
            if(!repository.existsById(id)) throw new EntityNotFoundException();
            repository.deleteById(id);
        }
        catch(IllegalArgumentException ex){
            throw new NullPointerException();
        }

    }

    public EmployeeDTO updateEmployee(EmployeeDTO employee){
        if(employee.getId() == null) return addEmployee(employee);
        try{
            Employee employeeDAO = repository.getReferenceById(employee.getId());
            mapper.updateCustomerFromDto(employee, employeeDAO);
            repository.save(employeeDAO);
            return toDTO(employeeDAO);
        }
        catch(EntityNotFoundException ex){
            return null;
        }
    }
}
