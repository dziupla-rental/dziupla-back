package shop.dziupla.spring.login.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.endpoints.request.ReqClientModify;
import shop.dziupla.spring.endpoints.response.RespBasic;
import shop.dziupla.spring.endpoints.response.RespClientDetails;
import shop.dziupla.spring.login.payload.response.ClientDTO;
import shop.dziupla.spring.login.payload.response.UserDTO;
import shop.dziupla.spring.login.security.services.ClientService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) {
        try {
            ClientDTO response = service.getClientById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<ClientDTO> getDetails() {
        try {
            ClientDTO response = service.getLoggedClient();
            if(response == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (NullPointerException | EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ClientDTO>> getClients() {
        var clients = service.getAllClients();

        if(!clients.isEmpty())
            return new ResponseEntity<>(clients, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Long id) {
        try {
            service.deleteClient(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) {
        try {
            if(clientDTO.getId() == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            if(!clientDTO.getLicenses().isEmpty()) {
                for(var license : clientDTO.getLicenses()){
                    license.setClientId(clientDTO.getId());
                }
            }

            ClientDTO updatedClient = service.updateClient(clientDTO);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        }
        catch (NullPointerException | IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/details")
//    public RespClientDetails getDetails() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        RespClientDetails response = new RespClientDetails();
//        String username = auth.getName();
//        // TODO wyszukać dane dla klienta przypisanego do danego użytkownika
//        response.setFirst_name(username); // when testing in postman you might have to singout and signin again for this to work
//
//        return response;
//    }
}


