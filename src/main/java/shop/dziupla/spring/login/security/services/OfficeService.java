package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.OfficeMapper;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.payload.response.OfficeDTO;
import shop.dziupla.spring.login.repository.OfficeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeService {
    @Autowired
    OfficeRepository repository;

    @Autowired
    OfficeMapper mapper;

    public OfficeDTO DAOtoDTO (Office office){
        return new OfficeDTO(office.getId(), office.getLocation());
    }
    public Office DTOtoDAO(OfficeDTO office){
        return new Office(office.getLocation());
    }
    public List<OfficeDTO> getAllOffices(){
        var result = new ArrayList<OfficeDTO>();
        for(var office : repository.findAll()){
            result.add(DAOtoDTO(office));
        }
        return result;
    }
    public OfficeDTO getOfficeById(Long id){
        if(id == null)throw new NullPointerException();
        return DAOtoDTO(repository.getReferenceById(id));
    }

    public OfficeDTO createOffice(OfficeDTO office){
        if(repository.existsByLocation(office.getLocation())) throw new EntityExistsException();
        if(office.getId() != null || office.getLocation() == null)throw new IllegalArgumentException();
        return DAOtoDTO(repository.save(DTOtoDAO(office)));
    }

    public void deleteOfficeById(Long id){
        if(id == null)throw new NullPointerException();
        if(!repository.existsById(id)) throw new EntityNotFoundException();
        repository.deleteById(id);
    }

    public OfficeDTO updateOffice(OfficeDTO office){
        if(office == null)throw new NullPointerException();
        if(repository.existsByLocation(office.getLocation())) throw new EntityExistsException();
        if(office.getId() == null)throw new IllegalArgumentException();
        if(!repository.existsById(office.getId())) throw new EntityNotFoundException();
        Office officeDAO = repository.getReferenceById(office.getId());
        mapper.updateCustomerFromDto(office, officeDAO);
        return DAOtoDTO(repository.save(officeDAO));

    }

}
