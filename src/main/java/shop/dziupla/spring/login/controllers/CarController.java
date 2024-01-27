package shop.dziupla.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.login.payload.response.CarDTO;
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
        return id==null? new ResponseEntity<>(HttpStatus.BAD_REQUEST):service.getCarById(id)==null?new ResponseEntity<>(HttpStatus.NOT_FOUND):new ResponseEntity<>(service.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public CarDTO createCar(@RequestBody CarDTO car) {
        //service.saveCar();
        //zmapować na DAO
        //dodać do bazy przez serwis
        //serwis dodaje do car ID
        //return service.insert(car)
        return null;
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole(" + ERole(0) + ")")
    public void deleteCarById(@PathVariable("id") Long id) {

    }

    @PutMapping("")
    public CarDTO updateCar(@RequestBody CarDTO car) {
        //check id car has set is
        //if no same as post
        //if yes do update
        return null;
    }


}