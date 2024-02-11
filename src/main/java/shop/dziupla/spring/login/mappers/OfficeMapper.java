package shop.dziupla.spring.login.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.payload.response.OfficeDTO;

@Mapper(componentModel = "spring")
public interface OfficeMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(OfficeDTO dto, @MappingTarget Office entity);
}
