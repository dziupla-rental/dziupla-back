package shop.dziupla.spring.login.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.DriverLicense;
import shop.dziupla.spring.login.payload.response.DriverLicenseDTO;
import shop.dziupla.spring.login.repository.ClientRepository;
import shop.dziupla.spring.login.repository.DriverLicenseRepository;

@Mapper(componentModel = "spring")
public abstract class DriverLicenseMapper {
    @Autowired protected ClientRepository repository;

    @Mapping(target = "clientId", source = "client.id")
    public abstract DriverLicenseDTO driverLicenseToDriverLicenseDTO(DriverLicense entity);
    @Mapping(target = "client", expression = "java(repository.getReferenceById(dto.getClientId()))")
    //@Mapping(target = "licenseCategory", expression = "java()")
    public abstract DriverLicense driverLicenseDTOToDriverLicense(DriverLicenseDTO dto);
}
