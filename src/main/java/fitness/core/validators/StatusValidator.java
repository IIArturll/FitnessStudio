package fitness.core.validators;

import fitness.core.dtos.enums.UserStatus;
import fitness.core.exceptions.ErrorField;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;

public class StatusValidator {
    public static void validate(MultipleErrorResponse errorResponse, UserStatus status) {
        if (status == null) {
            errorResponse.add(new ErrorField("empty", "status"));
        }
    }

    public static void validate(UserStatus status) throws SingleErrorResponse {
        if (status == null) {
            throw new SingleErrorResponse("empty", "status");
        }
    }
}
