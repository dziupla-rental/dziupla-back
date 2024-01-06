package shop.dziupla.spring.login.controllers;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shop.dziupla.spring.endpoints.request.ReqClientModify;
import shop.dziupla.spring.endpoints.response.RespBasic;
import shop.dziupla.spring.endpoints.response.RespClientDetails;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {
    // TODO uprawnienia dla ról
    // TODO integracja z modelem danych
    @GetMapping("/details")
    public RespClientDetails getDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        RespClientDetails response = new RespClientDetails();
        String username = auth.getName();
        // TODO wyszukać dane dla klienta przypisanego do danego użytkownika
        response.setFirst_name(username); // when testing in postman you might have to singout and signin again for this to work

        return response;
    }

    @GetMapping("/modify")
    public RespBasic modifyClient(@Valid @RequestBody ReqClientModify request) {

        RespBasic response = new RespBasic("OK", "");
        switch (request.getAction()) {
            case "add": // TODO dodawanie nowego pracownika
                break;
            case "remove": // TODO usuwanie pracownika
                break;
            case "modify": // TODO modyfikowanie pracownika
                break;
            default:
                response.setStatus("Error");
                response.setError("'%s' is not a valid action for a client".formatted(request.getAction()));
        }

        return response;
    }
}


