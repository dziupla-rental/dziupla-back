package shop.dziupla.spring.login.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import shop.dziupla.spring.login.models.Role;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @NotNull
    private double salary;

    private LocalTime shiftStart;

    private LocalTime shiftEnd;

    @OneToOne(optional = false, cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Employee(){}
    public Employee(Office office, Role role, double salary, LocalTime shiftStart, LocalTime shiftEnd){
            this.office = office;
            this.role = role;
            this.salary = salary;
            this.shiftStart = shiftStart;
            this.shiftEnd = shiftEnd;
    }
    public Long getId() {   return id;  }
    public void setId(Long id){ this.id = id;   }

    public Office getOffice() {return office;}
    public void setOffice(Office office) {this.office = office;}

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}

    public LocalTime getShiftStart() {return shiftStart;}
    public void setShiftStart(LocalTime shiftStart) {this.shiftStart = shiftStart;}

    public LocalTime getShiftEnd() {return shiftEnd;}
    public void setShiftEnd(LocalTime shiftEnd) {this.shiftEnd = shiftEnd;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
