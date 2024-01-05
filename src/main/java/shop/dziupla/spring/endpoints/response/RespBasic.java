package shop.dziupla.spring.endpoints.response;

public class RespBasic {
    String status;
    String error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public RespBasic(String status, String error) {
        this.status = status;
        this.error = error;
    }
}
