package shop.dziupla.spring.endpoints.request;

import shop.dziupla.spring.endpoints.response.RespClientDetails;

public class ReqClientModify extends RespClientDetails {
    String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
