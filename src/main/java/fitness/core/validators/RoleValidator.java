package fitness.core.validators;

import fitness.core.user.dtos.enums.UserRole;
import fitness.core.exceptions.ErrorField;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;

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
