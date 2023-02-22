package fitness.core.validators;

import fitness.core.exceptions.ErrorField;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;

public class FIOValidator {
    public static void validate(MultipleErrorResponse errorResponse, String fio) {
        if (fio == null || fio.isBlank()) {
            errorResponse.add(new ErrorField("empty", "fio"));
        }
    }

    public static void validate(String fio) throws SingleErrorResponse {
        if (fio == null || fio.isBlank()) {
            throw new SingleErrorResponse("empty", "fio");
        }
    }
}
