package shop.dziupla.spring.login.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.endpoints.request.ReqRentalModify;
import shop.dziupla.spring.endpoints.response.RespBasic;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rental")
public class RentalController {
    // TODO autoryzacja
    @GetMapping("/modify")
    public RespBasic detailsAccess(@Valid @RequestBody ReqRentalModify request) {

        RespBasic output = new RespBasic("OK", "");
        // request has the same fields as RespEmoployeeDetails + action
        switch (request.getAction()) {
            case "add": // TODO dodawanie nowego najmu
                break;
            case "remove": // TODO usuwanie najmu
                break;
            case "modify": // TODO modyfikowanie najmu
                break;
            default:
                output.setStatus("Error");
                output.setError("'%s' is not a valid action for a rental".formatted(request.getAction()));
        }
        return output;
    }
}
