package shop.dziupla.spring.login.mappers;

import org.hibernate.mapping.Component;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.Car;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.Photo;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.payload.response.OfficeDTO;
import shop.dziupla.spring.login.repository.PhotoRepository;
import shop.dziupla.spring.login.security.services.OfficeService;

@Mapper(componentModel = "spring")
public abstract class CarMapper {
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    OfficeService officeService;
    @Mapping(target = "photo", source = "photo.url")
    //@Mapping(target = "office")
    public abstract CarDTO carToCarDTO(Car car);
    @Mapping(target = "photo", source = "photo", qualifiedByName = "getPhotoByUrl")
    public abstract Car carDTOToCar(CarDTO carDTO);
    @Named("getPhotoByUrl")
    Photo getPhotoByUrl(String photo){
        try{
            return photoRepository.getPhotoByUrl(photo);
        }
        catch(Exception e){
            return null;
        }
    }
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "photo", source = "photo", qualifiedByName = "getPhotoByUrl")
    @Mapping(target = "office", source = "officeId", qualifiedByName = "getOfficeById")
    public abstract void updateCarFromDTO(CarDTO carDTO, @MappingTarget Car car);

    @Named("getOfficeById")
    Office getOfficeById(Long officeId){
        try{
            return officeDTOToOffice(officeService.getOfficeById(officeId));
        } catch (Exception e) {
            return null;
        }
    }
    public abstract Office officeDTOToOffice(OfficeDTO officeDTO);
}
