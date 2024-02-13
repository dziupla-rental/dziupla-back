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
import shop.dziupla.spring.login.security.services.RentalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService service;
    @Autowired
    RentalService rentalService;

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

    @GetMapping("/available/{id}")
    public ResponseEntity<Boolean> isCarAvailableById(@PathVariable("id") Long id, @RequestParam(name = "date") String sDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate date = LocalDate.parse(sDate, formatter);
            return new ResponseEntity<>(rentalService.isCarAvailable(id, date), HttpStatus.OK);
        }
        catch (NullPointerException | IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}