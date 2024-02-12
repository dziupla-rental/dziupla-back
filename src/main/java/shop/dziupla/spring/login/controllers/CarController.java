package shop.dziupla.spring.login.controllers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.login.payload.response.CarDTO;
import shop.dziupla.spring.login.payload.response.OfficeDTO;
import shop.dziupla.spring.login.security.services.CarService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService service;
    // TODO autoryzacja wybranyuch ról
    // TODO podpięcie do modelu danych
    @GetMapping("")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return new ResponseEntity<>(service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") Long id) {
        try{
            return id==null?
                    new ResponseEntity<>(HttpStatus.BAD_REQUEST):
                    new ResponseEntity<>(service.getCarById(id), HttpStatus.OK);
        }
        catch (EntityNotFoundException enfe){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO car) {
        try{
            return new ResponseEntity<>(service.addCar(car), HttpStatus.OK);
        }
        catch (IllegalArgumentException | NullPointerException iae){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole(" + ERole(0) + ")")
    public ResponseEntity<HttpStatus> deleteCarById (@PathVariable("id") Long id){
        try{
            service.deleteCarById(id);
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
    public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO car) {
        try{
            var result = service.updateCar(car);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(NullPointerException | IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(EntityExistsException ex){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }
    ////////////////////SERVICED////////////
    @GetMapping("/service")
    public ResponseEntity<List<CarDTO>> getServicedCars() {
        return service.getServicedCars().isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
            :new ResponseEntity<>(service.getServicedCars(), HttpStatus.OK);

    }
    ////////////////////FUNCTIONAL//////////
    @GetMapping("/functional")
    public ResponseEntity<List<CarDTO>> getFunctionalCars() {
        return service.getFunctionalCars().isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(service.getFunctionalCars(), HttpStatus.OK);

    }
    /////////////////BY//OFFICE//ID/////////
    @GetMapping("/carByOfficeId/{id}")
    public ResponseEntity<List<CarDTO>> getCarsByOfficeId(@PathVariable("id") Long id) {
        return service.getCarsByOffice(id).isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(service.getCarsByOffice(id), HttpStatus.OK);

    }
    /////////////////BY//OFFICE//STRING/////
    @GetMapping("/carByOffice/{office}")
    public ResponseEntity<List<CarDTO>> getCarsByOffice(@PathVariable("office") String office) {
        return service.getCarsByOffice(office).isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(service.getCarsByOffice(office), HttpStatus.OK);

    }
    @GetMapping("/carByOffice/{office}/functional")
    public ResponseEntity<List<CarDTO>> getCarsDoubleFiltered(@PathVariable("office") String office) {
        return service.getCarsDoubleFiltered(office).isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(service.getCarsDoubleFiltered(office), HttpStatus.OK);

    }
    @GetMapping("/carByOfficeId/{id}/functional")
    public ResponseEntity<List<CarDTO>> getCarsDoubleFilteredId(@PathVariable("id") Long id) {
        return service.getCarsDoubleFilteredId(id).isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(service.getCarsDoubleFilteredId(id), HttpStatus.OK);

    }
}