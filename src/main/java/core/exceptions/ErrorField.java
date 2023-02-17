package core.exceptions;

public class ErrorField {
    private String massage;
    private String field;

    public ErrorField(String massage, String field) {
        this.massage = massage;
        this.field = field;
    }

    public String getMassage() {
        return massage;
    }

    public String getField() {
        return field;
    }
}
