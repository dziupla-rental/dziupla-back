package shop.dziupla.spring.login.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.endpoints.request.ReqID;
import shop.dziupla.spring.endpoints.request.ReqEmployeeModify;
import shop.dziupla.spring.endpoints.response.RespBasic;
import shop.dziupla.spring.endpoints.response.entries.EmployeeListEntry;
import shop.dziupla.spring.endpoints.response.RespEmployeeDetails;
import shop.dziupla.spring.endpoints.response.RespEmployeeList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    // TODO autoryzacja tylko dla wybranych ról
    // TODO połączenie z rzeczywistym modelem danych
    @GetMapping("/list")
    public RespEmployeeList listAccess() {
        return new RespEmployeeList(
                new String[]{"Warszawa", "Kraków"},
                new String[]{"Mechanik"},
                new EmployeeListEntry[]{
                        new EmployeeListEntry(1, "Janusz Kowalski"),
                }
        );
    }

    @GetMapping("/details")
    public RespEmployeeDetails detailsAccess(@Valid @RequestBody ReqID request) {
        //   request.getId(); // TODO wyszukanie pracownika z id
        RespEmployeeDetails response = new RespEmployeeDetails();
        response.setFirst_name("Jan");
        response.setLast_name("Kowalski");
        response.setId(request.getId());
        // itd ...
        return response;
    }

    @GetMapping("/modify")
    public RespBasic detailsAccess(@Valid @RequestBody ReqEmployeeModify request) {

        RespBasic response = new RespBasic("OK", "");
        // request has the same fields as RespEmoployeeDetails + action
        switch (request.getAction()) {
            case "add": // TODO dodawanie nowego pracownika
                break;
            case "remove": // TODO usuwanie pracownika
                break;
            case "modify": // TODO modyfikowanie pracownika
                break;
            default:
                response.setStatus("Error");
                response.setError("'%s' is not a valid action for an employee".formatted(request.getAction()));
        }
        return response;
    }
}
