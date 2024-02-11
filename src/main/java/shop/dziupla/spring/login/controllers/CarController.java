package shop.dziupla.spring.login.controllers;

import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.login.payload.response.CarDTO;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/car")
public class CarController {
    // TODO autoryzacja wybranyuch ról
    // TODO podpięcie do modelu danych
    @GetMapping("")
    public List<CarDTO> getAllCars(@PathVariable Boolean onlyAvailable) {

        return null;
    }

    @GetMapping("/{id}")
    public CarDTO getCarById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("")
    public CarDTO createCar(@RequestBody CarDTO car) {
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
