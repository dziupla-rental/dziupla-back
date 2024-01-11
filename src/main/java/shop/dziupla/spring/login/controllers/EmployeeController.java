package shop.dziupla.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        var result = service.getAllEmployees();
        if(result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDTO> getEmployeById(@PathVariable("id") Long id) {
        try {
            var result = service.getEmployeeById(id);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(NullPointerException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee){
        try{
            var result = service.addEmployee(employee);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(IllegalArgumentException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public void deleteEmployeeById (@PathVariable("id") Long id){

    }
    @PutMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee){
            return null;
    }

}
