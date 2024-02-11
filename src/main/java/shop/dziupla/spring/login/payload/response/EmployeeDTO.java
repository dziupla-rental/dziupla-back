package shop.dziupla.spring.login.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.User;

import java.time.LocalTime;

public class EmployeeDTO {

    private Long id;


    private Office office;

    private Long officeId;
    private double salary;

    private LocalTime shiftStart;

    private LocalTime shiftEnd;


    private String email;

    private String name;

    private String lastName;

    private String role;

    @JsonIgnore
    private User user;

    public EmployeeDTO(){}
    public EmployeeDTO(Long id, Office office, double salary, LocalTime shiftStart, LocalTime shiftEnd, User user){
        this.id = id;
        this.office = office;
        this.salary = salary;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.user = user;
        this.email = user.getEmail();
        this.name = user.getName();
        this.lastName = user.getLastname();
        this.role = user.getRole().getName().name();
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setUser(User user) {this.user = user;}

    public User getUser() {return user;}
}
