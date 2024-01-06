package shop.dziupla.spring.login.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dziupla.spring.endpoints.response.RespStatistics;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/statistics")
// TODO dostęp tylko dla właściciela
public class StatisticsController {
    @GetMapping("/list")
    public RespStatistics listAccess() {
        RespStatistics response = new RespStatistics();
        // TODO zebrać statystyki i ustawić w response
        return response;
    }
}
