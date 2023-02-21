package core.dtos;

import core.dtos.enums.UserRole;
import core.dtos.enums.UserStatus;
import core.exceptions.MultipleErrorResponse;
import core.validators.*;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class UserCreateDTO extends UserDTO {
    private String password;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String mail, String fio, UserRole role,
                         UserStatus status, String password) throws MultipleErrorResponse {
        super(UUID.randomUUID(), Instant.now(), Instant.now(), mail, fio, role, status);
        this.password = password;
    }

    public UserCreateDTO(UUID uuid, Instant dt_create, Instant dt_update, String mail,
                         String fio, UserRole role, UserStatus status, String password)
            throws MultipleErrorResponse {
        super(uuid, dt_create, dt_update, mail, fio, role, status);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void validate() throws MultipleErrorResponse {
        MultipleErrorResponse errorResponse = new MultipleErrorResponse("invalid fields");
        MailValidator.validate(errorResponse, this.mail);
        FIOValidator.validate(errorResponse, this.fio);
        RoleValidator.validate(errorResponse, this.role);
        StatusValidator.validate(errorResponse, this.status);
        PasswordValidator.validate(errorResponse, password);
        if (!errorResponse.getErrors().isEmpty()) {
            throw errorResponse;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateDTO that = (UserCreateDTO) o;
        return super.equals(o)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password);
    }

    @Override
    public String toString() {
        return "UserCreateDTO{" +
                "uuid='" + uuid + '\'' +
                "dt_create" + dtCreate +
                "dt_update" + dtUpdate +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                "password='" + password + '\'' +
                "} ";
    }
}
