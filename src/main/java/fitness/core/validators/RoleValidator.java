package core.validators;

import core.dtos.enums.UserRole;
import core.exceptions.ErrorField;
import core.exceptions.MultipleErrorResponse;
import core.exceptions.SingleErrorResponse;

public class RoleValidator {
    public static void validate(MultipleErrorResponse errorResponse, UserRole role) {
        if (role == null) {
            errorResponse.add(new ErrorField("empty", "role"));
        }
    }

    public static void validate(UserRole role) throws SingleErrorResponse {
        if (role == null) {
            throw new SingleErrorResponse("empty", "role");
        }
    }
}
