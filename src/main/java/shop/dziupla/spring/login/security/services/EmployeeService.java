package shop.dziupla.spring.login.security.services;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.EmployeeMapper;
import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.repository.EmployeeRepository;
import shop.dziupla.spring.login.repository.OfficeRepository;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
@Service
public class EmployeeService {
    @Autowired EmployeeRepository repository;
    @Autowired ModelMapper mapper;

    @Autowired EmployeeMapper empMapper;
    @Autowired OfficeRepository officeRepository;

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> result = new ArrayList<>();
        for(var employee : repository.findAll()){
            result.add(empMapper.employeeToEmployeeDTO(employee));
        }
        return result;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employee){
        if(employee.getId() != null || employee.getUser() == null)throw new IllegalArgumentException();
        return empMapper.employeeToEmployeeDTO(repository.save(empMapper.employeeDTOToEmployee(employee)));
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employee){
        if(employee.getId() == null)throw new IllegalArgumentException();
        if(!repository.existsById(employee.getId()))throw new EntityNotFoundException();
        Employee employeeDAO = repository.getReferenceById(employee.getId());
        empMapper.updateEmployeeFromDto(employee, employeeDAO);
//        if(employee.getOfficeId() != null && officeRepository.existsById(employee.getOfficeId()))
//        {
//            employeeDAO.setOffice(officeRepository.findById(employee.getOfficeId())
//                    .orElseThrow(() -> new RuntimeException("Error: Office is not found.")));
//        }
        return empMapper.employeeToEmployeeDTO(repository.save(employeeDAO));
    }

    public void deleteEmployeeById(Long id){
        if(id == null)throw new NullPointerException();
        if(!repository.existsById(id)) throw new EntityNotFoundException();
        repository.deleteById(id);
    }

    public EmployeeDTO getEmployeeById(Long id){
        if(id == null)throw new NullPointerException();
        return empMapper.employeeToEmployeeDTO(repository.getReferenceById(id));
    }

}
