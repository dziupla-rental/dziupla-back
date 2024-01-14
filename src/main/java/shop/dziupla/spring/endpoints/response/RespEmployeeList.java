package shop.dziupla.spring.endpoints.response;

import shop.dziupla.spring.endpoints.response.entries.EmployeeListEntry;

public class RespEmployeeList {
    String offices[];
    String positions[];

    EmployeeListEntry employees[];

    public RespEmployeeList() {
    }

    public RespEmployeeList(String[] offices, String[] positions, EmployeeListEntry[] employees) {
        this.offices = offices;
        this.positions = positions;
        this.employees = employees;
    }

    public String[] getOffices() {
        return offices;
    }

    public void setOffices(String[] offices) {
        this.offices = offices;
    }

    public String[] getPositions() {
        return positions;
    }

    public void setPositions(String[] positions) {
        this.positions = positions;
    }

    public EmployeeListEntry[] getEmployees() {
        return employees;
    }

    public void setEmployees(EmployeeListEntry[] employees) {
        this.employees = employees;
    }
}
