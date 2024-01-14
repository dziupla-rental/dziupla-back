package shop.dziupla.spring.login.models.DAO;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;

    private double salary;

    private LocalTime shiftStart;

    private LocalTime shiftEnd;

    @OneToOne(optional = false, cascade =  CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Employee(){}
    public Employee(Office office, double salary, LocalTime shiftStart, LocalTime shiftEnd, User user){
            this.office = office;
            this.salary = salary;
            this.shiftStart = shiftStart;
            this.shiftEnd = shiftEnd;
            this.user = user;
    }
    public Long getId() {   return id;  }
    public void setId(Long id){ this.id = id;   }

    public Office getOffice() {return office;}
    public void setOffice(Office office) {this.office = office;}


    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}

    public LocalTime getShiftStart() {
        return shiftStart;
    }
    public void setShiftStart(LocalTime shiftStart) {this.shiftStart = shiftStart;}

    public LocalTime getShiftEnd() {return shiftEnd;}
    public void setShiftEnd(LocalTime shiftEnd) {this.shiftEnd = shiftEnd;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
