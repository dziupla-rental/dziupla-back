package shop.dziupla.spring.login.controllers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.login.payload.response.OfficeDTO;
import shop.dziupla.spring.login.security.services.OfficeService;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/office")
public class OfficeController {

    // TODO autoryzacja tylko dla wybranych ról
    @Autowired
    OfficeService service;
    @GetMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OfficeDTO>> getAllOffices() {
       return new ResponseEntity<>(service.getAllOffices(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OfficeDTO> getOfficeById(@PathVariable("id") Long id) {
        try{
            var result = service.getOfficeById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(NullPointerException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OfficeDTO> createOffice(@RequestBody OfficeDTO office){

        try{
            var result = service.createOffice(office);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch(NullPointerException | IllegalArgumentException | OptimisticLockException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityExistsException ex){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteOfficeById (@PathVariable("id") Long id){
        try{
            service.deleteOfficeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(NullPointerException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OfficeDTO> updateOffice(@RequestBody OfficeDTO office){
        try{
                var result = service.updateOffice(office);
                return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(NullPointerException | IllegalArgumentException | OptimisticLockException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(EntityExistsException ex){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

}


