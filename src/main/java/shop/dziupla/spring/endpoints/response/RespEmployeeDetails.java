package shop.dziupla.spring.endpoints.response;

public class RespEmployeeDetails {
    String first_name;
    String last_name;
    String position;
    String office;
    long id;
    double salary;
    int shift_start;
    int shift_end;

    public RespEmployeeDetails() {
    }

    public RespEmployeeDetails(String first_name, String last_name, String position, String office, long id, double salary, int shift_start, int shift_end) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.office = office;
        this.id = id;
        this.salary = salary;
        this.shift_start = shift_start;
        this.shift_end = shift_end;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getShift_start() {
        return shift_start;
    }

    public void setShift_start(int shift_start) {
        this.shift_start = shift_start;
    }

    public int getShift_end() {
        return shift_end;
    }

    public void setShift_end(int shift_end) {
        this.shift_end = shift_end;
    }
}
