package shop.dziupla.spring.login.payload.response;

import shop.dziupla.spring.login.models.DAO.Employee;
import shop.dziupla.spring.login.models.DAO.Office;
import shop.dziupla.spring.login.models.DAO.User;

import java.time.LocalTime;

public class EmployeeDTO {

    private Long id;

    private Office office;

    private double salary;

    private LocalTime shiftStart;

    private LocalTime shiftEnd;

    private User user;

    public EmployeeDTO(){}
    public EmployeeDTO(Office office, double salary, LocalTime shiftStart, LocalTime shiftEnd){
        this.office = office;
        //this.role = role;
        this.salary = salary;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
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

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public Employee toEmploee(){
        return new Employee(this.office, this.salary, this.shiftStart, this.shiftEnd, this.user);
    }
}
