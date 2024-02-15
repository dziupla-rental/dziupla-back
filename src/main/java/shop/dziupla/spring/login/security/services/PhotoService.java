package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.PhotoMapper;
import shop.dziupla.spring.login.models.DAO.Photo;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.payload.response.PhotoDTO;
import shop.dziupla.spring.login.repository.PhotoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository repository;
    @Autowired
    PhotoMapper mapper;

    public List<PhotoDTO> getAllPhotos(){
        List<PhotoDTO> list = new ArrayList<>();
        for( Photo p : repository.findAll()){
            list.add(mapper.photoToPhotoDTO(p));
        }
        return list;
    }

    public PhotoDTO getPhotoById(long id){
        return mapper.photoToPhotoDTO(repository.getReferenceById(id));
    }
    public PhotoDTO addPhoto(PhotoDTO photoDTO){
        if(photoDTO.getId() != null)throw new IllegalArgumentException();
        return mapper.photoToPhotoDTO(repository.save(mapper.photoDTOToPhoto(photoDTO)));
    }
    public void deletePhotoById(Long id){
        if(id == null)throw new NullPointerException();
        if(!repository.existsById(id)) throw new EntityNotFoundException();
        repository.deleteById(id);
    }
    public PhotoDTO updatePhoto(PhotoDTO photoDTO){
        if(photoDTO == null)throw new NullPointerException();
        if(photoDTO.getId() == null)throw new IllegalArgumentException();
        if(!repository.existsById(photoDTO.getId())) throw new EntityNotFoundException();
        Photo photoDAO = repository.getReferenceById(photoDTO.getId());
        mapper.updatePhotoFromDTO(photoDTO, photoDAO);
        return mapper.photoToPhotoDTO(repository.save(photoDAO));
    }

}