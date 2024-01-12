package shop.dziupla.spring.login.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.User;

import java.time.LocalTime;

public class EmployeeDTO {

    private Long id;
    private Office office;

    private double salary;

    private LocalTime shiftStart;

    private LocalTime shiftEnd;

    @JsonIgnore
    private User user;

    private String email;

    public EmployeeDTO(){}
    public EmployeeDTO(Long id, Office office, double salary, LocalTime shiftStart, LocalTime shiftEnd, User user){
        this.id = id;
        this.office = office;
        this.salary = salary;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.user = user;
        this.email = user.getEmail();
    }
    public Long getId() {   return id;  }
    public void setId(Long id){ this.id = id;   }

    public Office getOffice() {return office;}
    public void setOffice(Office office) {this.office = office;}

    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}

    public LocalTime getShiftStart() {return shiftStart;}
    public void setShiftStart(LocalTime shiftStart) {this.shiftStart = shiftStart;}

    public LocalTime getShiftEnd() {return shiftEnd;}
    public void setShiftEnd(LocalTime shiftEnd) {this.shiftEnd = shiftEnd;}

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
