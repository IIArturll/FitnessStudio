package core.validators;

import core.dtos.enums.UserStatus;
import core.exceptions.ErrorField;
import core.exceptions.MultipleErrorResponse;
import core.exceptions.SingleErrorResponse;

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
