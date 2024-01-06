package shop.dziupla.spring.login.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.endpoints.request.ReqCarList;
import shop.dziupla.spring.endpoints.request.ReqCarModify;
import shop.dziupla.spring.endpoints.request.ReqID;
import shop.dziupla.spring.endpoints.response.RespBasic;
import shop.dziupla.spring.endpoints.response.RespCarDetails;
import shop.dziupla.spring.endpoints.response.RespCarList;
import shop.dziupla.spring.endpoints.response.RespEmployeeList;
import shop.dziupla.spring.endpoints.response.entries.CarListEntry;
import shop.dziupla.spring.endpoints.response.entries.EmployeeListEntry;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/car")
public class CarController {
    // TODO zabezpieczenia
    // TODO podpięcie do modelu
    @GetMapping("/list")
    public RespCarList listAccess(@Valid @RequestBody ReqCarList request) {
        RespCarList response = new RespCarList();
        response.setCar_types(new String[]{"SEDAN", "HATCHBACK"});
        response.setFuel_types(new String[]{"BENZYNA", "DIESEL"});
        // TODO wybrać auta spełniające poniższe warunki i wstawić do response
//        request.getOffice();
//        request.getAvailable_start();
//        request.getAvailable_end();

        response.setCars(new CarListEntry[]{
                new CarListEntry(
                        "Toyota Yaris",
                        12,
                        "HATCHBACK",
                        200,
                        300,
                        true,
                        4,
                        "DIESEL",
                        "http...",
                        "Katowice"),
                new CarListEntry(
                        "Polonez",
                        13,
                        "SEDAN",
                        2002,
                        3300,
                        false,
                        100,
                        "BENZYNA",
                        "http...",
                        "Warszawa"),
        });

        return response;

    }
    @GetMapping("/details")
    public RespCarDetails detailsAccess(@Valid @RequestBody ReqID request){
        request.getId();
        RespCarDetails response=  new RespCarDetails();
        return response;
    }
    @GetMapping("/modify")
    public RespBasic modifyAccess(@Valid @RequestBody ReqCarModify request) {
        RespBasic response = new RespBasic("OK", "");
        switch (request.getAction()){
            case "add": // TODO dodawanie nowego pojazdu
                break;
            case "remove": // TODO usuwanie pojazdu
                break;
            case "modify": // TODO modyfikowanie pojazdu
                break;
            default:
                response.setStatus("Error");
                response.setError("'%s' is not a valid action for an employee".formatted(request.getAction()));
        }
        return response;
    }
}
