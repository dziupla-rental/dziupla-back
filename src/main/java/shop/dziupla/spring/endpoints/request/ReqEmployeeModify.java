package shop.dziupla.spring.endpoints.request;

import shop.dziupla.spring.endpoints.response.RespEmployeeDetails;

public class ReqEmployeeModify extends RespEmployeeDetails {
    String action;

    public ReqEmployeeModify() {
    }

    public ReqEmployeeModify(String first_name, String last_name, String position, String office, long id, double salary, int shift_start, int shift_end, String action) {
        super(first_name, last_name, position, office, id, salary, shift_start, shift_end);
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
