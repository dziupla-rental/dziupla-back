package shop.dziupla.spring.login.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.login.payload.response.EmployeeDTO;
import shop.dziupla.spring.login.security.services.EmployeeService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    // TODO autoryzacja tylko dla wybranych ról
    @Autowired
    EmployeeService service;
    @GetMapping("")
   //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDTO> getEmployeById(@PathVariable("id") Long id) {
       try {
            var result = service.getEmployeeById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
       }
       catch(NullPointerException ex){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
       catch(EntityNotFoundException ex){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteEmployeeById (@PathVariable("id") Long id){
        try{
            service.deleteEmployeeById(id);
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
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee){
       try{
           var result = service.updateEmployee(employee);
           return new ResponseEntity<>(result, HttpStatus.OK);
       }
       catch(EntityNotFoundException ex){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       catch(IllegalArgumentException ex){
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }
       catch(RuntimeException ex){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }

}
