package shop.dziupla.spring.login.mappers;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.Role;
import shop.dziupla.spring.login.models.DAO.User;
import shop.dziupla.spring.login.models.Enums.ERole;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.payload.response.OfficeDTO;
import shop.dziupla.spring.login.repository.RoleRepository;
import shop.dziupla.spring.login.repository.UserRepository;
import shop.dziupla.spring.login.security.services.OfficeService;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    @Autowired
    OfficeService officeService;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Mapping(target = "email", expression = "java(employee.getUser().getEmail())")
    @Mapping(target = "name", expression = "java(employee.getUser().getName())")
    @Mapping(target = "lastName", expression = "java(employee.getUser().getLastname())")
    @Mapping(target = "role", expression = "java(employee.getUser().getRole().getName().toString())")
    public abstract EmployeeDTO employeeToEmployeeDTO(Employee employee);


    public abstract Employee employeeDTOToEmployee(EmployeeDTO clientDTO);

    public abstract Office officeDTOToOffice(OfficeDTO officeDTO);




    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "office", source = "officeId", qualifiedByName = "getOfficeFromId")
    @Mapping(target = "user.email", source = "email")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.lastname", source = "lastName")
    @Mapping(target = "user.role", source = "role" , qualifiedByName = "getRoleByName")
    @Mapping(target = "shiftStart", source = "shiftStart")
    @Mapping(target = "salary", source = "salary")
    @Mapping(target = "user", source = "user", qualifiedByName = "getUserByUser")
    public abstract void updateEmployeeFromDto(EmployeeDTO dto, @MappingTarget Employee entity);

    @Named("getOfficeFromId")
    Office getOfficeFromId(Long officeId){
        try{
            return officeDTOToOffice(officeService.getOfficeById(officeId));
        } catch (Exception e) {
            return null;
        }
    }

    @Named("getRoleByName")
    Role getRoleByName(String role){
        try {
            Optional<Role> result = roleRepository.findByName(ERole.valueOf(role));
            return  result.orElse(null);
        }
        catch(Exception e){
            return null;
        }
    }

    @Named("getUserByUser")
    User getUserByUser(User user){
        try{
           return userRepository.findById(user.getId()).orElse(null);
        }
        catch(Exception e){
            return null;
        }
    }


}