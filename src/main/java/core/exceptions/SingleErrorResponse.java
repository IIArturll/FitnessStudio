package core.exceptions;

public class SingleErrorResponse {
    private String logref;
    private String massage;

    public SingleErrorResponse(String logref, String massage) {
        this.logref = logref;
        this.massage = massage;
    }

    public String getLogref() {
        return logref;
    }

    public String getMassage() {
        return massage;
    }
}
