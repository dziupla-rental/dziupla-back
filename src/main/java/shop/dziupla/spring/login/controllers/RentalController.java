package shop.dziupla.spring.login.controllers;

import jakarta.persistence.Access;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.endpoints.request.ReqRentalModify;
import shop.dziupla.spring.endpoints.response.RespBasic;
import shop.dziupla.spring.login.payload.response.RentalDTO;
import shop.dziupla.spring.login.security.services.RentalService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rental")
public class RentalController {
    @Autowired
    RentalService service;

    @GetMapping("")
    public ResponseEntity<List<RentalDTO>> getAllRentals() {
        var rentals = service.getAllRentals();

        if(!rentals.isEmpty())
            return new ResponseEntity<>(rentals, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<RentalDTO>> getAllRentalsByClientId(@PathVariable("id") Long clientId) {
        try{
            var rentals = service.getRentalsByClientId(clientId);

            if(!rentals.isEmpty())
                return new ResponseEntity<>(rentals, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRentalById(@PathVariable("id") Long id) {
        try {
            RentalDTO response = service.getRentalById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<RentalDTO> addRental(@RequestBody RentalDTO request) {
        try {
            var response = service.addRental(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (IllegalArgumentException | NullPointerException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("")
    public ResponseEntity<RentalDTO> updateRental(@RequestBody RentalDTO request) {
        try {
            if(request.getId() == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            RentalDTO response = service.updateRental(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (NullPointerException | IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRental(@PathVariable("id") Long id) {
        try {
            service.deleteRentalById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
