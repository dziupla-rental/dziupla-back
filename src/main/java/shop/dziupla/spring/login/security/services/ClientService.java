package shop.dziupla.spring.login.security.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import shop.dziupla.spring.login.mappers.ClientMapper;
import shop.dziupla.spring.login.models.DAO.Client;
import shop.dziupla.spring.login.models.DAO.User;
import shop.dziupla.spring.login.payload.response.ClientDTO;
import shop.dziupla.spring.login.repository.ClientRepository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;
    @Autowired
    ClientMapper mapper;

    public ClientService() {}

    public ClientDTO getLoggedClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null)
            throw new NullPointerException();

        if (authentication.isAuthenticated() /*&& authentication.getPrincipal() instanceof UserDetailsImpl*/) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            Long id = userDetails.getId();
            Client client = repository.findByUserId(id);

            return mapper.clientToClientDTO(client);
        }
        return null;
    }

    public ClientDTO getClientById(Long id) throws NullPointerException, EntityNotFoundException {
        if(id == null)
            throw new NullPointerException();

        Client result = repository.getReferenceById(id);
        return mapper.clientToClientDTO(result);
    }

    public List<ClientDTO> getAllClients() {
        var result = new ArrayList<ClientDTO>();

        for(Client client : repository.findAll()){
            result.add(mapper.clientToClientDTO(client));
        }
        return result;
    }

    public ClientDTO addClient(ClientDTO clientDTO) {
        if(clientDTO.getId() != null)
            return null;

        Client result = repository.save(
                mapper.clientDTOToClient(clientDTO));

        return mapper.clientToClientDTO(result);
    }

    public void deleteClient(Long id) throws NullPointerException, EntityNotFoundException {
        if(!repository.existsById(id))
            throw new EntityNotFoundException();

        repository.deleteById(id);
    }

    public ClientDTO updateClient(ClientDTO clientDTO) throws NullPointerException, EntityNotFoundException {
        Long id = clientDTO.getId();

        if(!repository.existsById(id))
            throw new EntityNotFoundException();
        if(clientDTO.getUser() != null)
            throw new IllegalArgumentException();

        Client client = repository.getReferenceById(id);
        mapper.updateClientFromDto(clientDTO, client);

        return mapper.clientToClientDTO(repository.save(client));
    }
}
