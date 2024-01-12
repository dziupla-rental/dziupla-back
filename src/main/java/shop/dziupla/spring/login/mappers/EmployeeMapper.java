package shop.dziupla.spring.login.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(EmployeeDTO dto, @MappingTarget Employee entity);
}
