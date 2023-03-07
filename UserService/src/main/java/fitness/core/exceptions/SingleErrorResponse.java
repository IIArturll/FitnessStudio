package fitness.core.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonPropertyOrder({"logref", "message"})
@JsonIgnoreProperties(value = {"cause", "localizedMessage", "stackTrace","suppressed"})
public class SingleErrorResponse extends Exception {
    @JsonProperty(value = "logref", required = true)
    private String logref;
    @JsonProperty("message")
    private String message;

    public SingleErrorResponse(String logref, String message) {
        this.logref = logref;
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public String getMessage() {
        return message;
    }
}
