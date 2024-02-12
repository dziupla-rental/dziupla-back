package shop.dziupla.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dziupla.spring.endpoints.response.RespStatistics;
import shop.dziupla.spring.login.payload.response.StatisticsDTO;
import shop.dziupla.spring.login.security.services.EmployeeService;
import shop.dziupla.spring.login.security.services.StatisticsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/statistics")
// TODO dostęp tylko dla właściciela
public class StatisticsController {
    @Autowired
    StatisticsService service;
    @GetMapping("")
    public ResponseEntity<StatisticsDTO> getStatistics() {


    }
}
