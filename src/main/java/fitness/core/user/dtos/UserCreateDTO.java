package fitness.core.user.dtos;

import fitness.core.user.dtos.enums.UserRole;
import fitness.core.user.dtos.enums.UserStatus;
import fitness.core.exceptions.MultipleErrorResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class UserCreateDTO extends UserDTO {
    @NotNull
    @NotBlank
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
}
