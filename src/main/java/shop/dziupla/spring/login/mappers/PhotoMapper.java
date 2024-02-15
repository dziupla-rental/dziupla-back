package shop.dziupla.spring.login.mappers;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import shop.dziupla.spring.login.models.DAO.Photo;
import shop.dziupla.spring.login.payload.response.PhotoDTO;
import shop.dziupla.spring.login.repository.PhotoRepository;

@Mapper(componentModel = "spring")
public abstract class PhotoMapper {
    @Autowired
    PhotoRepository photoRepository;

    @Mapping(target = "url" , source = "url")
    public abstract PhotoDTO photoToPhotoDTO(Photo photo);


    public abstract Photo photoDTOToPhoto(PhotoDTO photoDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updatePhotoFromDTO(PhotoDTO photoDTO, @MappingTarget Photo photo);
}
